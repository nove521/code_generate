package com.freemark.model.data.react;

import com.freemark.db.enpty.MySqlDbCulomEnpty;
import com.freemark.model.data.DefaultModel;
import com.freemark.utils.DbCluomsFormat;

import java.util.List;

public class IndexModel extends DefaultModel {
    private static final String PREFIX = "index";

    @Override
    public void initModel() {
        super.initModel();
        setModelName(PREFIX);
        this.map.put("className",getModelName());
        StringBuilder className = new StringBuilder(systemConfig.getKey("DB_TABLE_NAME"));
        map.put("class", DbCluomsFormat.humpFormat(className.toString()));
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("REACT_INDEX_OUT_PATH") + "\\" + setModelNameBySUFFIX2("");
    }
}
