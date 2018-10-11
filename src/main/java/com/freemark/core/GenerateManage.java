package com.freemark.core;

import com.freemark.config.BaseConfig;
import com.freemark.db.MySqldbOperate;
import com.freemark.model.BaseModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GenerateManage implements BaseManage{

    Configuration configuration;
    BaseConfig config;

    private GenerateManage(){

    }

    public GenerateManage(BaseConfig config){
        configuration = new Configuration(Configuration.VERSION_2_3_23);
        this.config = config;
        try {
            configuration.setDirectoryForTemplateLoading(new File(config.getKey("TEMPLATE_PATH")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BaseManage buildToFile(BaseModel model) {
        if (model == null ){
            return null;
        }
        Writer out = null;
        try {
            Template template = configuration.getTemplate(config.getKey("TEMPLATE_NAME"));
            Map<String, Object> dataMap = model.getModel();
            File docFile = new File(config.getKey("CLASS_PATH") + "\\" +model.getModel().get("className")+"." + config.getKey("SUFFIX"));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            template.process(dataMap, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public BaseManage buildToFile(MySqldbOperate operate) {
        return null;
    }
}
