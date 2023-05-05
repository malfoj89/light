package com.malfoj.core;

import java.util.HashSet;
import java.util.Set;

public class LightRouter {
    private static LightRouter instance = null;

    private LightRouter() {
        // Private constructor to prevent external instantiation
    }

    public static LightRouter get() {
        if (instance == null) {
            synchronized (LightRouter.class) {
                if (instance == null) {
                    instance = new LightRouter();
                    instance.addController(new NotFoundController());
                }
            }
        }
        return instance;
    }

    private final Set<Controller> controllerList = new HashSet<>();

    public void addController(Controller controller){
        controllerList.add(controller);
    }

    public Set<Controller> getControllerList(){
        return new HashSet<>(controllerList);
    }
}
