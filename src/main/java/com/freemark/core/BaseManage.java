package com.freemark.core;

import com.freemark.config.BaseConfig;
import com.freemark.db.MySqldbOperate;
import com.freemark.model.BaseModel;

public interface BaseManage {

    BaseManage buildToFile(String className,String outName);

    BaseManage buildToFile(BaseModel model);

    BaseManage buildToFile(MySqldbOperate operate);

    /**
     * 获取模板绝对路径
     * @param baseModel
     * @return
     */
    String getTemplatesApPath(BaseModel baseModel);

    /**
     * 获取模板包路径
     *
     * @param baseModel
     * @return
     */
    String getTemplatesNamePath(BaseModel baseModel);

    String getTemplatesName(BaseModel baseModel);
}
