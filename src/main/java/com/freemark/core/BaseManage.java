package com.freemark.core;

import com.freemark.config.BaseConfig;
import com.freemark.db.MySqldbOperate;
import com.freemark.model.BaseModel;

public interface BaseManage {

    BaseManage buildToFile(BaseModel model);
    BaseManage buildToFile(MySqldbOperate operate);

}
