package com.malfoj.core.controller;

import com.malfoj.core.LightHttpMethod;
import com.malfoj.core.LightResponse;

public interface Controller {

    String getPath();

    LightHttpMethod getMethod();

    LightResponse run();
}
