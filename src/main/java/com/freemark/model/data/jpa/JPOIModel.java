package com.freemark.model.data.jpa;

import com.freemark.model.data.DefaultModel;

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
        map.put("pacgePath",computePackeByPath(getOutPathName()));
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("JPOI_OUT_CLASS_PATH");
    }


}
