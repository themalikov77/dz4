package com.example.homework4;

public class Country {
    private String name;
    private Integer image;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Country(String name, Integer image) {
        this.name = name;
        this.image = image;
    }
}
