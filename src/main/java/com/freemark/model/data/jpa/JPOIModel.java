package com.freemark.model.data.jpa;

import com.freemark.utils.DbCluomsFormat;

public class JPOIModel extends DefaultModel {

    private static final String SUFFIX = "Entity";

    public JPOIModel(){
        super();
    }

    @Override
    public void initModel() {
        super.initModel();
        if (null == getModelName()){
            super.setModelName(setModelNameBySUFFIX(SUFFIX));
        }
        map.put("className",getModelName());
        map.put("pacgePath",systemConfig.getKey("PACGE_PATH"));
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("JPOI_OUT_CLASS_PATH");
    }

    protected String setModelNameBySUFFIX(String suffix){
        StringBuilder className = new StringBuilder(systemConfig.getKey("DB_TABLE_NAME"));
        className = DbCluomsFormat.firstUpName(className);
        String newClassName = DbCluomsFormat.humpFormat(className.toString());
        return newClassName + suffix;
    }
}
