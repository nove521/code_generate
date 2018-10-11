package com.freemark.test;

import com.freemark.config.BaseConfig;
import com.freemark.config.SystemConfig;
import com.freemark.core.BaseManage;
import com.freemark.core.GenerateManage;
import com.freemark.db.Connct;
import com.freemark.db.MySqldbOperate;
import com.freemark.model.BaseModel;
import com.freemark.model.data.jpa.JpaModel;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerDemo {

    private static final String TEMPLATE_PATH = "D:\\demo\\idea-demo\\code_generate\\src\\main\\java\\com\\freemark\\templates";
    private static final String CLASS_PATH = "D:\\demo\\idea-demo\\code_generate\\src\\main\\java\\com\\freemark\\templates";

/*    public static void main(String[] args) {
        Connct connct = new Connct("root","root","mtest");
        MySqldbOperate mySqldbOperate = new MySqldbOperate(connct);
        System.out.printf(mySqldbOperate.getCulomsList("t1","mtest").toString());
    }*/
    public static void main(String[] args) {
        BaseConfig config = SystemConfig.getSystemConfig();
        GenerateManage generateManage = new GenerateManage(config);
        BaseModel jpaModel = new JpaModel();
        jpaModel.initModel();
        generateManage.buildToFile(jpaModel);
    }

}