package com.apps;

/**
 * Created by 태섭 on 2021-11-09
 */

public class Data{
    public Data(String title, int price, int resId) {
        this.title = title;
        this.price = price;
        this.resId = resId;
    }

    private String title;
    private int price;
    private int resId;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int cost) {
        this.price = cost;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getResId() {
        return resId;
    }

}