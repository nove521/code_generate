package com.freemark.model.data.jpa.service;

import com.freemark.model.data.jpa.BOModel;
import com.freemark.model.data.DefaultModel;
import com.freemark.model.data.jpa.JPOIModel;
import com.freemark.model.data.jpa.VoModel;
import com.freemark.utils.DbCluomsFormat;

public class Service extends DefaultModel {

    private static final String SUFFIX = "Service";

    public Service(){
        super();
    }

    @Override
    public void initModel() {
        super.initModel();
        if (null == getModelName()){
            super.setModelName(setModelNameBySUFFIX(SUFFIX));
        }
        StringBuilder className = new StringBuilder(systemConfig.getKey("DB_TABLE_NAME"));
        map.put("class",DbCluomsFormat.humpFormat(className.toString()));
        map.put("suffix",SUFFIX);
        map.put("className",getModelName());
        map.put("pacgePath",computePackeByPath(getOutPathName()));
        map.put("voPacgePath",computePackeByPath(new VoModel().getOutPathName()));
        map.put("boPacgePath",computePackeByPath(new BOModel().getOutPathName()));
        map.put("EntityPacgePath",computePackeByPath(new JPOIModel().getOutPathName()));
        map.put("pagePacgePath",systemConfig.getKey("PACGE_PATH") + "." + systemConfig.getKey("PAGE_CLASS_PATH"));
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("SERVICE_OUT_CLASS_PATH");
    }

}
