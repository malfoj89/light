package com.malfoj.core.controller;

import com.malfoj.core.LightHttpMethod;
import com.malfoj.core.LightResponse;

public class NotFoundController implements Controller {
    @Override
    public String getPath() {
        return "/404";
    }

    @Override
    public LightHttpMethod getMethod() {
        return LightHttpMethod.GET;
    }

    @Override
    public LightResponse<Void> run() {
        return new LightResponse<>(404, "application/json", null);
    }
}
