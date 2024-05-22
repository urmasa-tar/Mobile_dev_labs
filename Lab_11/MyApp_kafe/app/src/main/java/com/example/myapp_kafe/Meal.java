package com.example.myapp_kafe;

public class Meal {
    int img;
    String name;
    int price;
    int quan;
    int total;

    public Meal(int img, String name, int price, int quan) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.quan = quan;
        this.total=price*quan;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

