package com.josue.micro.gateway;

import com.josue.micro.registry.jee7.EnableClient;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by Josue on 13/02/2016.
 */
@EnableClient(name = "gateway")
@ApplicationPath("api")
public class JaxrsApp extends Application {
}
