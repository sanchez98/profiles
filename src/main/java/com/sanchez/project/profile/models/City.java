package com.sanchez.project.profile.models;

public class City {
    private String name;
    private String country;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", id=" + id +
                '}';
    }

    public City(int id, String country, String name) {
        this.name = name;
        this.country = country;
        this.id = id;
    }

    public City() {
        this.name = null;
        this.country = null;
        this.id = 0;
    }
}
