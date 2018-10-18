package com.freemark.model;

public class ModelFactoryImpl implements ModelFactory {
    @Override
    public BaseModel getModel(String className) {
        return getModel(className, null);
    }

    @Override
    public BaseModel getModel(String className,String outName) {
        try {
            Class clazz = Class.forName(className);
            BaseModel baseModel = (BaseModel) clazz.newInstance();
            if (null != outName) {
                baseModel.setModelName(outName);
            }
            baseModel.initModel();
            return baseModel;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
