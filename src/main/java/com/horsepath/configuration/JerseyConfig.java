package com.horsepath.configuration;

import javax.ws.rs.ApplicationPath;
import com.horsepath.controllers.ServletHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/horse/servlet")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ServletHandler.class);
    }
}