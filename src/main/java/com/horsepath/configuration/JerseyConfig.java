package com.horsepath.configuration;

import com.horsepath.controllers.ServletHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/horse/servlet")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ServletHandler.class);
    }
}