package com.tangzhang.jul;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class LogJulConfig{

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
}
