package com.freemark.model.data.jpa;

public class VoModel extends JPOIModel {
    private static final String SUFFIX = "Vo";

    @Override
    public void initModel() {
        super.initModel();
        setModelName(setModelNameBySUFFIX(SUFFIX));
        map.put("className",getModelName());
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("VO_OUT_CLASS_PATH")+ "\\" + setModelNameBySUFFIX2("");
    }
}
