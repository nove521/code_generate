package com.freemark.model.data.jpa;

import com.freemark.config.SystemConfig;
import com.freemark.db.Connct;
import com.freemark.db.MySqldbOperate;
import com.freemark.model.BaseModel;

import java.util.HashMap;
import java.util.Map;

public class JpaModel implements BaseModel {

    Map<String,Object> map = new HashMap<>();

    public JpaModel(){

    }

    @Override
    public void initModel() {
        SystemConfig systemConfig = SystemConfig.getSystemConfig();
        Connct connct = new Connct(systemConfig.getKey("DB_USER"),systemConfig.getKey("DB_PASW"),systemConfig.getKey("DB_NAME"));
        MySqldbOperate operate = new MySqldbOperate(connct);
        map.put("tableKey",operate.getCulomsList(systemConfig.getKey("DB_TABLE_NAME"),systemConfig.getKey("DB_NAME")));
        map.put("tableName",systemConfig.getKey("DB_TABLE_NAME"));
        StringBuilder className = new StringBuilder(systemConfig.getKey("DB_TABLE_NAME"));
        if (className.charAt(0)>'A'){
            className.replace(0,1,className.substring(0,1).toUpperCase());
        }
        map.put("className",className);
        map.put("pacgePath",systemConfig.getKey("PACGE_PATH"));
    }

    public Map<String,Object> getModel(){
        return map;
    }
}
