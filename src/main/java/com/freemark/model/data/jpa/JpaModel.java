package com.freemark.model.data.jpa;

import com.freemark.config.SystemConfig;
import com.freemark.db.Connct;
import com.freemark.db.MySqldbOperate;
import com.freemark.model.BaseModel;
import com.freemark.utils.DbCluomsFormat;

import java.util.HashMap;
import java.util.Map;

public class JpaModel extends DefaultModel {

    public JpaModel(){
        super();
    }

    @Override
    public void initModel() {
        super.initModel();
        StringBuilder className = new StringBuilder(systemConfig.getKey("DB_TABLE_NAME"));
        className = DbCluomsFormat.firstUpName(className);
        String newClassName = DbCluomsFormat.humpFormat(className.toString());
        map.put("className",newClassName);
        map.put("pacgePath",systemConfig.getKey("PACGE_PATH"));
    }

}
