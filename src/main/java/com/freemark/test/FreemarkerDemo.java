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
        BaseModel requestPost = modelFactory.getModel("com.freemark.model.data.jpa.request.RequestPost");
        BaseModel responseGet = modelFactory.getModel("com.freemark.model.data.jpa.response.ResponseGet");
        BaseModel serviceModel = modelFactory.getModel("com.freemark.model.data.jpa.service.Service");
        BaseModel ServiceImplModel = modelFactory.getModel("com.freemark.model.data.jpa.service.ServiceImpl");
        BaseModel DaoImplModel = modelFactory.getModel("com.freemark.model.data.jpa.dao.DaoImpl");
        BaseModel DaoModel = modelFactory.getModel("com.freemark.model.data.jpa.dao.Dao");
        BaseModel RepoModel = modelFactory.getModel("com.freemark.model.data.jpa.dao.Repo");
        BaseModel ControllerModel =modelFactory.getModel("com.freemark.model.data.jpa.controller.Controller");

        generateManage
                .buildToFile(jpaModel).buildToFile(boModel).buildToFile(voModel)
                .buildToFile(responseGet)
                .buildToFile(requestGet)
                .buildToFile(requestPost)
        .buildToFile(serviceModel).buildToFile(ServiceImplModel).buildToFile(DaoImplModel).buildToFile(DaoModel).buildToFile(RepoModel).buildToFile(ControllerModel);
    }

}