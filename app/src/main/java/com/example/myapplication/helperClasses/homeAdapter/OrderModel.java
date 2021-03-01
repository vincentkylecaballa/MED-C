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

    public void setOrderImg(int orderImg) {
        this.orderImg = orderImg;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }
}
