package com.example.orgconnectapp;

public class HelperClass {

    String name, password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HelperClass(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public HelperClass() {
    }
}
