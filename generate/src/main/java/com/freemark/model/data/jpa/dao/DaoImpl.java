package com.freemark.model.data.jpa.dao;

import com.freemark.model.data.jpa.BOModel;

public class DaoImpl extends Dao {
    private static final String SUFFIX = "DaoImpl";

    @Override
    public void initModel() {
        super.initModel();
        super.setModelName(setModelNameBySUFFIX(SUFFIX));
        map.put("pacgePath",computePackeByPath(getOutPathName()));
        map.put("DaoPacgePath",computePackeByPath(systemConfig.getKey("DAO_OUT_CLASS_PATH")));
        map.put("EntityPacgePath",computePackeByPath(systemConfig.getKey("JPOI_OUT_CLASS_PATH")));
        map.put("boPacgePath",computePackeByPath(new BOModel().getOutPathName()));
        map.put("RepoPacgePath",computePackeByPath(new Repo().getOutPathName()));
        map.put("DefaultDaoPacgePath", systemConfig.getKey("PACGE_PATH") + "." + systemConfig.getKey("DEFAULTDAO_PACGE_PATH"));
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("DAO_IMPL_OUT_CLASS_PATH");
    }
}
