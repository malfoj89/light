package com.malfoj.core;

public interface Controller {

    String getPath();

    LightHttpMethod getMethod();

    LightResponse run();
}
