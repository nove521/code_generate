package com.freemark.db.enpty;


public class MySqlDbCulomEnpty implements DbCulomEnpty {

    private String name;
    // 字段类型
    private String type;

    private String typeLong;

    private boolean canNull;

    private boolean isPrimary;

    private String annotation;

    private String strDefault;

    private String primaryIsAuto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeLong() {
        return typeLong;
    }

    public void setTypeLong(String typeLong) {
        this.typeLong = typeLong;
    }

    public boolean isCanNull() {
        return canNull;
    }

    public void setCanNull(boolean canNull) {
        this.canNull = canNull;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getStrDefault() {
        return strDefault;
    }

    public void setStrDefault(String strDefault) {
        this.strDefault = strDefault;
    }

    public String getPrimaryIsAuto() {
        return primaryIsAuto;
    }

    public void setPrimaryIsAuto(String primaryIsAuto) {
        this.primaryIsAuto = primaryIsAuto;
    }

    @Override
    public String toString() {
        return "MySqlDbCulomEnpty{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", typeLong='" + typeLong + '\'' +
                ", canNull=" + canNull +
                ", isPrimary=" + isPrimary +
                ", annotation='" + annotation + '\'' +
                ", strDefault='" + strDefault + '\'' +
                ", primaryIsAuto='" + primaryIsAuto + '\'' +
                '}';
    }
}
