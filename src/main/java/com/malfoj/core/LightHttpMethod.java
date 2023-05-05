package com.malfoj.core;

public enum LightHttpMethod {

    GET("GET"),
    POST("POST");

    private final String value;

    public String getValue() {
        return value;
    }

    LightHttpMethod(String value) {
        this.value = value;
    }
}
