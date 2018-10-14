package com.freemark.model.data.jpa.request;

import com.freemark.db.enpty.MySqlDbCulomEnpty;
import com.freemark.model.data.jpa.JPOIModel;

import java.util.List;

public class RequestPost extends JPOIModel {
    private static final String PREFIX = "Request";
    private static final String SUFFIX = "Post";

    @Override
    public void initModel() {
        super.initModel();
        setModelName(PREFIX + setModelNameBySUFFIX(SUFFIX));
        this.map.put("className",getModelName());
        List<MySqlDbCulomEnpty> list = (List<MySqlDbCulomEnpty>) this.map.get("tableKey");
        formatType(list);
    }

    private void formatType(List<MySqlDbCulomEnpty> list){
        for (int i=0 ; i< list.size();i++){
            String type = list.get(i).getType();
            switch (type){
                case "LocalDateTime":
                    list.get(i).setType("String");
                    break;
                default:
            }
        }
    }

    @Override
    public String getOutPathName() {
        return systemConfig.getKey("REQUESTPACGEPATH_OUT_CLASS_PATH") + "\\" + setModelNameBySUFFIX2("");
    }
}
