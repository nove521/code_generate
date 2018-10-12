package com.freemark.model.data.jpa;

import com.freemark.config.SystemConfig;
import com.freemark.db.Connct;
import com.freemark.db.MySqldbOperate;
import com.freemark.db.enpty.MySqlDbCulomEnpty;
import com.freemark.model.BaseModel;
import com.freemark.utils.DbCluomsFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultModel implements BaseModel {

    Map<String, Object> map = new HashMap<>();
    SystemConfig systemConfig;

    public DefaultModel() {

    }

    @Override
    public void initModel() {
        systemConfig = SystemConfig.getSystemConfig();
        Connct connct = new Connct(systemConfig.getKey("DB_USER"), systemConfig.getKey("DB_PASW"), systemConfig.getKey("DB_NAME"));
        MySqldbOperate operate = new MySqldbOperate(connct);
        map.put("tableKey", operate.getCulomsList(systemConfig.getKey("DB_TABLE_NAME"), systemConfig.getKey("DB_NAME")));
        List<MySqlDbCulomEnpty> list = (List<MySqlDbCulomEnpty>) map.get("tableKey");
        for (int i = 0; i < list.size(); i++) {
            if ("true".equals(systemConfig.getKey("IS_HUMP"))) {
                String name = list.get(i).getName();
                name = DbCluomsFormat.humpFormat(name);
                list.get(i).setName(name);
            }
        }
        map.put("tableKey",list);
        map.put("tableName", systemConfig.getKey("DB_TABLE_NAME"));
    }

    @Override
    public Map<String, Object> getModel() {
        return map;
    }
}
