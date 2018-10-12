package com.freemark.utils;

public class DbCluomsFormat {

    public static String firstUpName(String name) {
        StringBuilder className = new StringBuilder(name);
        className.replace(0, 1, className.substring(0, 1).toUpperCase());
        return className.toString();
    }

    public static StringBuilder firstUpName(StringBuilder className) {
        className.replace(0, 1, className.substring(0, 1).toUpperCase());
        return className;
    }

    public static String humpFormat(String name) {
        StringBuilder newName = new StringBuilder();
        int len = name.length();
        for (int i = 0; i < len; i++) {
            if (name.charAt(i) == '_'){
                if (i+1 < len && name.charAt(i+1) != '_'){
                    newName.append(String.valueOf(name.charAt(i+1)).toUpperCase());
                    i++;
                }
                continue;
            }
            newName.append(name.charAt(i));
        }
        return newName.toString();
    }

}
