package com.example.orgconnect.orgs.SYMS;

public class SymsData {

    private String name, email, image, key;

    public SymsData(){

    }

    public SymsData(String name, String email, String image, String key) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
