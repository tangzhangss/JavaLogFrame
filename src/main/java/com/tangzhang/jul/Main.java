package com.tangzhang.jul;

import java.util.logging.Logger;

public class Main {
    private static final Integer COUNT = 100;
    private static Logger logger =  Logger.getLogger(Main.class.getName());

    static {
        //需要加载jul配置
        LogJulConfig.init();
    }


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
            logger.info(">>>>>info "+i);
        }
    }
    private static void printWaring(){
        for (int i = 0; i < COUNT; i++) {
            logger.warning(">>>>>warning "+i);
        }
    }
    private static void printServe(){
        for (int i = 0; i < COUNT; i++) {
            logger.severe(">>>>>serve "+i);
        }
    }
}
