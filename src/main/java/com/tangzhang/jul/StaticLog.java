package com.tangzhang.jul;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class StaticLog {
    private StaticLog() {}

    private static Logger logger = Logger.getLogger(StaticLog.class.getPackage().getName());

    static {
        LogManager logManager = LogManager.getLogManager();
        try {
            String userDIR = System.getProperty("user.dir");
            logManager.readConfiguration(new FileInputStream(userDIR+"/src/main/resources/logger-jul.properties"));

            //判断日志文件目录是否存在--存在就创建目录
            final String filePattern = logManager.getProperty("java.util.logging.FileHandler.pattern");
            File logDir =  new File(filePattern).getParentFile();
            if(!logDir.exists()) {
                logDir.mkdirs();
            }
            //-----------------------------------------

        } catch (IOException e) {
            //加载日志配置文件失败
            e.printStackTrace();
        }
    }

    public void setLogger(String name){
        logger = Logger.getLogger(name);
    }

    public static StaticLog logger(String name){
        StaticLog staticLog = new StaticLog();
        staticLog.setLogger(name);
        return staticLog;
    }

    public static void info(String msg){
        logger.info(msg);
    }
    public static void severe(String msg){
        logger.severe(msg);
    }
    public static void config(String msg){
        logger.config(msg);
    }
    public static void finer(String msg){
        logger.finer(msg);
    }
    public static void fine(String msg){
        logger.fine(msg);
    }
    public static void finest(String msg){
        logger.finest(msg);
    }
    public static void warning(String msg){
        logger.warning(msg);
    }
}
