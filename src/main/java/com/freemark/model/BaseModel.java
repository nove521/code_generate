package com.freemark.model;

import java.util.Map;

public interface BaseModel {

    /**
     * 初始化模板
     */
    void initModel();

    /**
     * 给出模板数据
     * @return
     */
    Map<String,Object> getModel();
}
