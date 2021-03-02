package com.example.myapplication.helperClasses.homeAdapter;

public class OrderModel {
    int orderImg;
    String orderName, totalPrice, quan;

    public OrderModel(int orderImg, String orderName, String totalPrice, String quan) {
        this.orderImg = orderImg;
        this.orderName = orderName;
        this.totalPrice = totalPrice;
        this.quan = quan;
    }

    public int getOrderImg() {
        return orderImg;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getQuan() {
        return quan;
    }


}
