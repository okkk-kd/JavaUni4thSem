package com;

public class Group {
    String groupName = "lol";

    public void setGroupName(String name) {
        groupName = name;
    }

    @Override
    public String toString() {
        return "Group " + groupName;
    }
}
