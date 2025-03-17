package com.example.ecommerce;

public class Product {
    private String name;
    private String img;

    private int id;
     private int price;
     private int rate;

    public Product() {
        // Để Firestore tự động tạo
    }
    public Product(String name, String imageUrl, int id, int price, int rate) {
        this.name = name;
        this.img = img;
        this.id = id;
        this.price = price;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getRate() {
        return rate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String img) {
        this.img = img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
