package com.knightmoves.configuration;

import com.knightmoves.controllers.ServletController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/knight/servlet")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ServletController.class);
    }
}