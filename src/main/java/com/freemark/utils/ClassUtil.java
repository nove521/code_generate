package com.freemark.utils;

public class ClassUtil {

    /**
     * 获取原声类所在包
     * @return
     */
    public static String getPcakPathName(String type){

        String result = "";
        switch (type){
            case "LocalDateTime":
                result = "java.time.LocalDateTime";
                break;
            case "Date":
                result = "java.util.Date";
                break;
                default:
                    break;
        }

        return result;
    }

}
