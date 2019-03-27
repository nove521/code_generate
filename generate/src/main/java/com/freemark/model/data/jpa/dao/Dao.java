package com.freemark.model.data.jpa.dao;

import com.freemark.model.data.DefaultModel;
import com.freemark.model.data.jpa.VoModel;
import com.freemark.utils.DbCluomsFormat;

public class Dao extends DefaultModel {
    private static final String SUFFIX = "Dao";

    public Dao() {
        super();
    }

    @Override
    public void initModel() {
        super.initModel();
        if (null == getModelName()) {
            super.setModelName(setModelNameBySUFFIX(SUFFIX));
        }
        StringBuilder className = new StringBuilder(systemConfig.getKey("DB_TABLE_NAME"));
        map.put("class", DbCluomsFormat.humpFormat(className.toString()));
        map.put("suffix", SUFFIX);
        map.put("className", getModelName());
        map.put("pacgePath", computePackeByPath(getOutPathName()));
        map.put("voPacgePath", computePackeByPath(new VoModel().getOutPathName()));
        map.put("pagePacgePath", systemConfig.getKey("PACGE_PATH") + "." + systemConfig.getKey("PAGE_CLASS_PATH"));
        map.put("EntityPacgePath", computePackeByPath(systemConfig.getKey("JPOI_OUT_CLASS_PATH")));
        map.put("BaseDaoPacgePath", systemConfig.getKey("PACGE_PATH") + "." + systemConfig.getKey("BASE_DAO_PACGE_PATH"));
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("DAO_OUT_CLASS_PATH");
    }
}
