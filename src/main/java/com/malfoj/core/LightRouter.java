package com.malfoj.core;

import com.malfoj.core.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public enum LightRouter {
    INSTANCE;
    private final Map<String, Controller> controllerList = new HashMap<>();

    public void addController(Controller controller){
        controllerList.put(controller.getPath(), controller);
    }

    public Controller getController(String path){
        return controllerList.get(path);
    }
}
