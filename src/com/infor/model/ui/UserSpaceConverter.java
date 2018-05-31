package com.infor.model.ui;

import com.birst.UserSpace;
import javafx.util.StringConverter;

import java.util.HashMap;
import java.util.Map;

public class UserSpaceConverter extends StringConverter<UserSpace> {

    private Map<String, UserSpace> spaceMap = new HashMap<String, UserSpace>();
    @Override
    public String toString(UserSpace space) {
        spaceMap.put(space.getName(), space);
        return space.getName();
    }

    @Override
    public UserSpace fromString(String name) {
        return spaceMap.get(name);
    }
}
