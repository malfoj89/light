package com.malfoj.core;

public final class LightResponse<T> {

    private int statusCode;
    private String mediaType;
    private T response;

    public LightResponse(int statusCode, String mediaType, T response) {
        this.statusCode = statusCode;
        this.mediaType = mediaType;
        this.response = response;
    }

    public LightResponse(T body) {
        this.statusCode = 200;
        this.mediaType = "application/json";
        this.response = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMediaType() {
        return mediaType;
    }

    public T getResponse() {
        return response;
    }
}
