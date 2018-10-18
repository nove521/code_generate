package com.freemark.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class SystemConfig implements BaseConfig {

    private static SystemConfig systemConfig;
    private Properties config;

    private SystemConfig() {
        config=new Properties();
        InputStream is=Thread.currentThread().getContextClassLoader().getSystemResourceAsStream("config/base_config.properties");
        try {
            config.load(is);
        } catch (IOException e) {
            config = null;
        }
    }

    public static synchronized SystemConfig getSystemConfig() {
        if (systemConfig == null ){
            systemConfig = new SystemConfig();
        }
        return systemConfig;
    }

    public String getKey(String name) {
        return config.getProperty(name);
    }

    public static void main(String[] args) {
        SystemConfig systemConfig = SystemConfig.getSystemConfig();
    }
}
