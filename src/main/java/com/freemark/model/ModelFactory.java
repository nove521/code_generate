package com.freemark.model;

public interface ModelFactory {
    BaseModel getModel(String className);
    BaseModel getModel(String className,String outName);
}
