package com.apps;

/**
 * Created by 태섭 on 2021-11-09
 */

public class Data{
    public Data(String title, int price, int resId, int viewNum) {
        this.title = title;
        this.price = price;
        this.resId = resId;
        this.viewNum = viewNum;
    }

    private String title;
    private int price;
    private int resId;
    private int viewNum;

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getResId() {
        return resId;
    }

    public int getViewNum() { return viewNum; }

}