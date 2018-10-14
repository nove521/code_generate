package com.freemark.model.data.jpa.dao;

import com.freemark.model.data.jpa.DefaultModel;
import com.freemark.utils.DbCluomsFormat;

public class Repo extends DefaultModel {
    private static final String SUFFIX = "Repo";
    public Repo(){
        super();
    }

    @Override
    public void initModel() {
        super.initModel();
        if (null == getModelName()){
            super.setModelName(setModelNameBySUFFIX(SUFFIX));
        }
        StringBuilder className = new StringBuilder(systemConfig.getKey("DB_TABLE_NAME"));
        map.put("class", DbCluomsFormat.humpFormat(className.toString()));
        map.put("suffix",SUFFIX);
        map.put("className",getModelName());
        map.put("pacgePath",computePackeByPath(getOutPathName()));
        map.put("EntityPacgePath",computePackeByPath(systemConfig.getKey("JPOI_OUT_CLASS_PATH")));

    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("REPO_OUT_CLASS_PATH");
    }
}
