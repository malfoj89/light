package com.malfoj.core;

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
