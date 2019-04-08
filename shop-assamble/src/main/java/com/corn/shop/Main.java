package com.corn.shop;


import com.corn.boot.annotations.Runner;
import com.corn.boot.base.RunMain;
import org.springframework.context.annotation.ImportResource;

@Runner
@ImportResource(value = "dubbo-admin.xml")
public class Main {

    public static void main(String[] args) {
        RunMain.springRun(Main.class);
    }
}
