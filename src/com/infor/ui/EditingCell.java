package com.infor.ui;

import com.birst.SourceColumnSubClass;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class EditingCell extends TableCell<SourceColumnSubClass, Object> {

        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            super.startEdit();
            if (textField == null) {
                createTextField();
            }
            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    textField.selectAll();
                    textField.requestFocus();
                }
            });
            System.out.println("start edit" + textField.getText());
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);
            System.out.println("cancel edit " + getItem());
        }

        @Override
        public void updateItem(Object item, boolean empty) {
            super.updateItem(item, empty);
            System.out.println("update item " + item);
            if (item != null) {
                if (item instanceof String) {
                    setText((String) item);
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                } else if (item instanceof Integer) {
                    setText(Integer.toString((Integer) item));
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.TEXT_ONLY);

                } else if (item instanceof Boolean) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setSelected((boolean) item);
                    setGraphic(checkBox);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else if (item instanceof Image) {
                    setText(null);
                    ImageView imageView = new ImageView((Image) item);
                    imageView.setFitWidth(100);
                    imageView.setPreserveRatio(true);
                    imageView.setSmooth(true);
                    setGraphic(imageView);
                } else {
                    setText("N/A");
                    setGraphic(null);
                }
            } else {
                setText(null);
                setGraphic(null);
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            // textField.setOnAction((e) -> commitEdit(textField.getText()));
            textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(textField.getText());
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    } else if (t.getCode() == KeyCode.TAB) {
                        commitEdit(textField.getText());
                        TableColumn nextColumn = getNextColumn(!t.isShiftDown());
                        if (nextColumn != null) {
                            getTableView().edit(getTableRow().getIndex(), nextColumn);
                        }
                    }
                }
            });

            textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue && textField != null) {
                    System.out.println("Commiting " + textField.getText());
                    commitEdit(textField.getText());
                }
            });
        }

        private TableColumn<SourceColumnSubClass, ?> getNextColumn(boolean forward) {
            List<TableColumn<SourceColumnSubClass, ?>> columns = new ArrayList<>();
            for (TableColumn<SourceColumnSubClass, ?> column : getTableView().getColumns()) {
                columns.addAll(getLeaves(column));
            }
            //There is no other column that supports editing.
            if (columns.size() < 2) {
                return null;
            }

            int currentIndex = columns.indexOf(getTableColumn());
            int nextIndex = currentIndex;
            if (forward) {
                nextIndex++;
                if (nextIndex > columns.size() - 1) {
                    nextIndex = 0;
                }
            } else {
                nextIndex--;
                if (nextIndex < 0) {
                    nextIndex = columns.size() - 1;
                }
            }
            return columns.get(nextIndex);
        }

        private List<TableColumn<SourceColumnSubClass, ?>> getLeaves(TableColumn<SourceColumnSubClass, ?> root) {
            List<TableColumn<SourceColumnSubClass, ?>> columns = new ArrayList<>();
            if (root.getColumns().isEmpty()) {
                //We only want the leaves that are editable.
                if (root.isEditable()) {
                    columns.add(root);
                }
                return columns;
            } else {
                for (TableColumn<SourceColumnSubClass, ?> column : root.getColumns()) {
                    columns.addAll(getLeaves(column));
                }
                return columns;
            }
        }

        private String getString() {
            return getItem() == null ? "" : String.valueOf(getItem());
        }
    }

