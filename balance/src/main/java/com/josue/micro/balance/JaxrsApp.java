package com.josue.micro.balance;


import com.josue.micro.registry.jee7.EnableDiscovery;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by Josue on 13/02/2016.
 */
@EnableDiscovery(name = "balance")
@ApplicationPath("api")
public class JaxrsApp extends Application {
}
