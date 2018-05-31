package com.infor.model.ui;

public class LevelColumn{
    public Checkbox select = new Checkbox();
    private String name;

    public LevelColumn(String name){
        this.name = name;
    }
    public LevelColumn(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
