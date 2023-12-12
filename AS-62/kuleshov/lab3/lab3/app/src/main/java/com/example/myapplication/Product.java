package com.example.myapplication;

public class Product {
    String name;
    String price;
    String id;
    int image;
    boolean box;

    public Product(String name, String id, String price, int image, boolean box) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.image = image;
        this.box = box;
    }
}
