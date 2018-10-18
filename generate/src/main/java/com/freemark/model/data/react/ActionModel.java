package com.freemark.model.data.react;

import com.freemark.model.data.DefaultModel;
import com.freemark.utils.DbCluomsFormat;

public class ActionModel extends DefaultModel {
    private static final String PREFIX = "Action";

    @Override
    public void initModel() {
        super.initModel();
        setModelName(setModelNameBySUFFIX(PREFIX));
        this.map.put("className",getModelName());
        StringBuilder className = new StringBuilder(systemConfig.getKey("DB_TABLE_NAME"));
        map.put("class", DbCluomsFormat.humpFormat(className.toString()));
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("REACT_ACTION_OUT_PATH");
    }
}
