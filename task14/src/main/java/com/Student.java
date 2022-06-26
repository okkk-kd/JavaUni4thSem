package com;

public class Student {
    String firstName;
    String middleName;
    String lastName;

    public void setFirstName(String fn) {
        firstName = fn;
    }

    public void setMiddleName(String mn) {
        middleName = mn;
    }

    public void setLastName(String ln) {
        lastName = ln;
    }

    @Override
    public String toString() {
        return firstName + ' ' + middleName + ' ' + lastName;
    }
}
