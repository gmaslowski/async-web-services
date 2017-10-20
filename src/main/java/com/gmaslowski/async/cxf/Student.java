package com.gmaslowski.async.cxf;

public class Student {
    private String name;

    Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}