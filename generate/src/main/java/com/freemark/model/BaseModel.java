package com.freemark.model;

import com.freemark.db.enpty.MySqlDbCulomEnpty;

import java.util.List;
import java.util.Map;

public interface BaseModel {

    String getModelName();
    void setModelName(String name);

    /**
     * 初始化模板
     */
    void initModel();

/*    *//**
     * 初始化模板
     *//*
    void initModel(String name);*/

    /**
     * 给出模板数据
     * @return
     */
    Map<String,Object> getModel();

    /**
     * 输出的模板路径
     * @return
     */
    String getOutPathName();


    /**
     * 输出数据类型的包路径2
     * @return
     */
    List<String> getPackNames(List<MySqlDbCulomEnpty> name);
}
