package com.example.myapplication.helperClasses.homeAdapter;

public class FeaturedHelper {

    int img, addtocart;
    String title, desc, price;

    public FeaturedHelper(int img, int addtocart, String title, String desc, String price) {
        this.img = img;
        this.title = title;
        this.desc = desc;
        this.addtocart = addtocart;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getAddtocart() {
        return addtocart;
    }

    public String getPrice() {
        return price;
    }
}
