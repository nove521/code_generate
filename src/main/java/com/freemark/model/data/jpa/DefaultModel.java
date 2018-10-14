package com.freemark.model.data.jpa;

import com.freemark.config.SystemConfig;
import com.freemark.db.Connct;
import com.freemark.db.MySqldbOperate;
import com.freemark.db.enpty.MySqlDbCulomEnpty;
import com.freemark.model.BaseModel;
import com.freemark.utils.ClassUtil;
import com.freemark.utils.DbCluomsFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DefaultModel implements BaseModel {

    String modelName;

    protected Map<String, Object> map = new HashMap<>();
    SystemConfig systemConfig;

    public DefaultModel() {

    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public void setModelName(String name) {
        this.modelName = name;
    }


    @Override
    public void initModel() {
        systemConfig = SystemConfig.getSystemConfig();
        Connct connct = new Connct(systemConfig.getKey("DB_USER"), systemConfig.getKey("DB_PASW"), systemConfig.getKey("DB_NAME"));
        MySqldbOperate operate = new MySqldbOperate(connct);
        List<MySqlDbCulomEnpty> mySqlDbCulomEnpties =operate.getCulomsList(systemConfig.getKey("DB_TABLE_NAME"), systemConfig.getKey("DB_NAME"));
        map.put("tableKey", mySqlDbCulomEnpties);
        map.put("packNames",getPackNames(mySqlDbCulomEnpties));
        map.put("tableName",systemConfig.getKey("DB_TABLE_NAME"));
        List<MySqlDbCulomEnpty> list = (List<MySqlDbCulomEnpty>) map.get("tableKey");
        List<String> nameFormats = new ArrayList<>();
        String nameFormat = "";
        for (int i = 0; i < list.size(); i++) {
            nameFormat = list.get(i).getName();
            if ("true".equals(systemConfig.getKey("IS_HUMP"))) {
                nameFormat = DbCluomsFormat.humpFormat(nameFormat);
            }
            nameFormats.add(nameFormat);
        }
        map.put("tableKeyNameFormat",nameFormats);
        map.put("className",getModelName());
    }

    @Override
    public Map<String, Object> getModel() {
        return map;
    }

    @Override
    public String getOutPathName() {
        return null;
    }

    @Override
    public List<String> getPackNames(List<MySqlDbCulomEnpty> name) {
        List<String> packNames = new ArrayList<>();
        String pn = null;
        for (MySqlDbCulomEnpty item : name){
            pn = ClassUtil.getPcakPathName(item.getType());
            if (!"".equals(pn)) {
                packNames.add(pn);
            }
        }
        return packNames;
    }


}
