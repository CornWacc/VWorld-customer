package com.corn.shop;


import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;

@Runner
public class Main {

    public static void main(String[] args) {
        RunMain.springRun(Main.class);
    }
}
