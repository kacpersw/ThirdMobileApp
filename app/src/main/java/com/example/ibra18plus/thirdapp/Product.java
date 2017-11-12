package com.example.ibra18plus.thirdapp;

/**
 * Created by Ibra18plus on 2017-11-12.
 */

public class Product {
    private String name;
    private String description;
    private int image;
    private boolean isChecked;

    public Product(String title, String description, int image) {
        this.name = title;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage(){
        return image;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getPrice(){
        return description.toString();
    }

}
