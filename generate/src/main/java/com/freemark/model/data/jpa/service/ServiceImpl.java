package com.freemark.model.data.jpa.service;

import com.freemark.model.data.jpa.JPOIModel;
import com.freemark.model.data.jpa.dao.Repo;
import com.freemark.utils.DbCluomsFormat;

public class ServiceImpl extends Service{
    private static final String SUFFIX = "ServiceImpl";

    @Override
    public void initModel() {
        super.initModel();
        super.setModelName(setModelNameBySUFFIX(SUFFIX));
        map.put("pacgePath",computePackeByPath(getOutPathName()));
        map.put("ServicePacgePath",computePackeByPath(systemConfig.getKey("SERVICE_OUT_CLASS_PATH")));
        map.put("DaoPacgePath",computePackeByPath(systemConfig.getKey("DAO_OUT_CLASS_PATH")));
        map.put("EntityPacgePath",computePackeByPath(new JPOIModel().getOutPathName()));
        map.put("RepoPacgePath",computePackeByPath(new Repo().getOutPathName()));

    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("SERVICE_IMPL_OUT_CLASS_PATH");
    }
}
