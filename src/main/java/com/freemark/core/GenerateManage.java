package com.freemark.core;

import com.freemark.config.BaseConfig;
import com.freemark.db.MySqldbOperate;
import com.freemark.model.BaseModel;
import com.freemark.model.ModelFactory;
import com.freemark.model.ModelFactoryImpl;
import com.freemark.model.data.jpa.JPOIModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GenerateManage implements BaseManage {

    private Configuration configuration;
    private BaseConfig config;

    private GenerateManage() {

    }

    public GenerateManage(BaseConfig config) {
        configuration = new Configuration(Configuration.VERSION_2_3_23);
        this.config = config;
    }

    @Override
    public BaseManage buildToFile(String className, String outName) {
        ModelFactory modelFactory = new ModelFactoryImpl();
        BaseModel baseModel = modelFactory.getModel(className, outName);
        return buildToFile(baseModel);
    }

    @Override
    public BaseManage buildToFile(BaseModel model) {
        if (model == null) {
            return null;
        }
        Writer out = null;
        try {
            configuration.setDirectoryForTemplateLoading(new File(getTemplatesApPath(model)));
            Template template = configuration.getTemplate(getTemplatesName(model));
            Map<String, Object> dataMap = model.getModel();
            String outPathName = model.getOutPathName();
            if (null == outPathName) {
                outPathName = getTemplatesApPath(model);
            }
            File docFile = new File(outPathName + "\\" + model.getModelName() + "." + config.getKey("SUFFIX"));
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

        return this;
    }

    @Override
    public BaseManage buildToFile(MySqldbOperate operate) {
        return null;
    }

    @Override
    public String getTemplatesName(BaseModel baseModel) {
        return baseModel.getClass().getSimpleName() + ".ftl";
    }

    @Override
    public String getTemplatesApPath(BaseModel baseModel) {
        String currtPath = baseModel.getClass().getResource("").getPath().substring(1);
        currtPath = currtPath.replaceFirst("/target/classes", "/src/main/java");
        int cur = currtPath.indexOf("model", 1);
        int lencut = cur + "model".length();
        return currtPath.substring(0, cur) + "templates" + currtPath.substring(lencut);
    }

    @Override
    public String getTemplatesNamePath(BaseModel baseModel) {
        String tmName = baseModel.getClass().getSimpleName();
        String packPathName = baseModel.getClass().getPackage().getName();
        String packPathNames[] = packPathName.split(".");
        StringBuilder tmPackName = new StringBuilder();
        int i;
        for (i = 0; i < packPathNames.length; i++) {
            if ("model".equals(packPathNames[i])) {
                break;
            }
            tmPackName.append(packPathNames[i] + ".");
        }
        if (i == packPathNames.length) {
            return null;
        }
        tmPackName.append("templates.");
        tmPackName.append(tmName);
        return tmPackName.toString();
    }
}
