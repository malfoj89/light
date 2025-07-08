package com.malfoj.core;

import com.google.gson.Gson;
import com.malfoj.core.gson.LightGson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LightServlet extends HttpServlet {

    private final static LightRouter router = LightRouter.INSTANCE;
    private final static Logger LOGGER = LoggerFactory.getLogger(LightServlet.class);
    private final static Gson gson = new LightGson().get();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        handleRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            var process = router.getController(request.getRequestURI()).run();
            response.setStatus(process.getStatusCode());
            response.setContentType(process.getMediaType());
            var controllerResponse = process.getResponse();
            if (controllerResponse != null) {
                response.getWriter().write(gson.toJson(controllerResponse));
            }
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage());
            response.sendRedirect("/404");
        }
    }
}
