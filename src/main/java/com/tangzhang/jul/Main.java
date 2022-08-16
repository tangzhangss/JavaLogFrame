package com.tangzhang.jul;

public class Main {
    private static final Integer COUNT = 100;

    public static void main(String[] args) {
        new Thread(()->{
            printInfo();
        }).start();

 /*       new Thread(()->{
            printWaring();
        }).start();

        new Thread(()->{
            printServe();
        }).start();*/


    }


    private static void printInfo(){
        for (int i = 0; i < COUNT; i++) {
            StaticLog.info(">>>>>info "+i);
        }
    }
    private static void printWaring(){
        for (int i = 0; i < COUNT; i++) {
            StaticLog.warning(">>>>>warning "+i);
        }
    }
    private static void printServe(){
        for (int i = 0; i < COUNT; i++) {
            StaticLog.severe(">>>>>serve "+i);
        }
    }
}
