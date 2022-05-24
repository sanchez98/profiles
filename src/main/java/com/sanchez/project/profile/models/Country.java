package com.sanchez.project.profile.models;

public class Country {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Country() {
        this.code = null;
        this.name = null;
    }
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
