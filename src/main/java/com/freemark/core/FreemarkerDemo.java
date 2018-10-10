package com.freemark.core;

import com.freemark.db.Connct;
import com.freemark.db.MySqldbOperate;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerDemo {

    private static final String TEMPLATE_PATH = "D:\\demo\\idea-demo\\code_generate\\src\\main\\java\\com\\freemark\\templates";
    private static final String CLASS_PATH = "D:\\demo\\idea-demo\\code_generate\\src\\main\\java\\com\\freemark\\templates";

    public static void main(String[] args) {
        Connct connct = new Connct("root","root","mtest");
        MySqldbOperate mySqldbOperate = new MySqldbOperate(connct);
        mySqldbOperate.getCulomNames("t1");
    }
    public  void main2(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("classPath", "com.freemark.templates");
            dataMap.put("className", "User");
            dataMap.put("Id", "Id");
            dataMap.put("userName", "userName");
            dataMap.put("password","password");
            // step4 加载模版文件
            Template template = configuration.getTemplate("test.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH + "\\" + "User.java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^User.java 文件创建成功 !");
        } catch (Exception e) {
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
    }

}