package com.josue.micro.account;

import com.josue.micro.registry.jee7.EnableClient;
import com.josue.micro.registry.jee7.EnableDiscovery;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by Josue on 13/02/2016.
 */
@EnableClient
@EnableDiscovery(name = "account")
@ApplicationPath("api")
public class JaxrsApp extends Application {
}
