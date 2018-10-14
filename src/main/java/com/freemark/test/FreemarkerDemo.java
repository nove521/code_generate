package com.freemark.test;

import com.freemark.config.BaseConfig;
import com.freemark.config.SystemConfig;
import com.freemark.core.GenerateManage;
import com.freemark.model.BaseModel;
import com.freemark.model.ModelFactory;
import com.freemark.model.ModelFactoryImpl;
import com.freemark.model.data.jpa.JPOIModel;

public class FreemarkerDemo {

    public static void main(String[] args) {
        BaseConfig config = SystemConfig.getSystemConfig();
        GenerateManage generateManage = new GenerateManage(config);
        ModelFactory modelFactory = new ModelFactoryImpl();
        BaseModel jpaModel = modelFactory.getModel("com.freemark.model.data.jpa.JPOIModel");
        BaseModel boModel = modelFactory.getModel("com.freemark.model.data.jpa.BOModel");
        BaseModel voModel = modelFactory.getModel("com.freemark.model.data.jpa.VoModel");
        BaseModel requestGet = modelFactory.getModel("com.freemark.model.data.jpa.request.RequestGet");

        generateManage.buildToFile(jpaModel)
                .buildToFile(boModel)
                .buildToFile(voModel)
                .buildToFile(requestGet);
    }

}