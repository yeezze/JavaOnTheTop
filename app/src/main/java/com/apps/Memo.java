package com.apps;

public class Memo {
    String main;
    String sub;
    int i;

    public Memo(String main, String sub, int i) {
        this.main = main;
        this.sub = sub;
        this.i = i;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
