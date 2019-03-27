package com.freemark.model.data.jpa.controller;

import com.freemark.model.data.jpa.BOModel;
import com.freemark.model.data.DefaultModel;
import com.freemark.model.data.jpa.JPOIModel;
import com.freemark.model.data.jpa.request.RequestGet;
import com.freemark.model.data.jpa.request.RequestPost;
import com.freemark.model.data.jpa.response.ResponseGet;
import com.freemark.utils.DbCluomsFormat;

public class Controller extends DefaultModel {
    private static final String SUFFIX = "Controller";
    public Controller(){
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
        map.put("ProjdectRootpacgePath",systemConfig.getKey("PACGE_PATH"));
        map.put("pacgePath",computePackeByPath(getOutPathName()));
        map.put("EntityPacgePath",computePackeByPath(new JPOIModel().getOutPathName()));
        map.put("boPacgePath",computePackeByPath(new BOModel().getOutPathName()));
        map.put("pagePacgePath",systemConfig.getKey("PACGE_PATH") + "." + systemConfig.getKey("PAGE_CLASS_PATH"));
        map.put("ServicePacgePath",computePackeByPath(systemConfig.getKey("SERVICE_OUT_CLASS_PATH")));
        map.put("RequestGetPacgePath",computePackeByPath(new RequestGet().getOutPathName()));
        map.put("ResponseGetPacgePath",computePackeByPath(new ResponseGet().getOutPathName()));
        map.put("RequestPostPacgePath",computePackeByPath(new RequestPost().getOutPathName()));


    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("CONTROLLER_OUT_CLASS_PATH");
    }
}
