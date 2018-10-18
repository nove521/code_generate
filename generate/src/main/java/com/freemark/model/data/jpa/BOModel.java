package com.freemark.model.data.jpa;

public class BOModel extends JPOIModel {
    private static final String SUFFIX = "Bo";

    public BOModel(){
        super();
    }

    @Override
    public void initModel() {
        super.initModel();
        setModelName(setModelNameBySUFFIX(SUFFIX));
        map.put("className",getModelName());
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("BO_OUT_CLASS_PATH")+ "\\" + setModelNameBySUFFIX2("");
    }
}
