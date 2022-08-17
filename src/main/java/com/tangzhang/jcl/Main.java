package com.tangzhang.jcl;

import com.tangzhang.jul.LogJulConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {
    public static Log log = LogFactory.getLog(Main.class);
    static {
        //需要加载jul配置
        LogJulConfig.init();
    }
    public static void main(String[] args) {
        log.debug("---");//jul没有debug..将忽略
        log.info("info---");
    }

}
