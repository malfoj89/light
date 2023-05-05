package com.malfoj.core;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.slf4j.LoggerFactory;

public class LightServer {

    public void run() throws Exception {
        Server server = new Server();
        ServerConnector serverConnector = new ServerConnector(server);
        serverConnector.setPort(8080);
        server.setConnectors(new Connector[]{serverConnector});
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(LightServlet.class, "/");

        server.setHandler(servletHandler);
        server.start();
        fanfare();
    }

    private static void fanfare() {
        LoggerFactory.getLogger(LightServer.class).info("""
                                
                .____    .__       .__     __    ___.                          .__   _____          __\s
                |    |   |__| ____ |  |___/  |_  \\_ |__ ___.__.   _____ _____  |  |_/ ____\\____    |__|
                |    |   |  |/ ___\\|  |  \\   __\\  | __ <   |  |  /     \\\\__  \\ |  |\\   __\\/  _ \\   |  |
                |    |___|  / /_/  >   Y  \\  |    | \\_\\ \\___  | |  Y Y  \\/ __ \\|  |_|  | (  <_> )  |  |
                |_______ \\__\\___  /|___|  /__|    |___  / ____| |__|_|  (____  /____/__|  \\____/\\__|  |
                        \\/ /_____/      \\/            \\/ \\/            \\/     \\/                \\______|
                """);
    }
}
