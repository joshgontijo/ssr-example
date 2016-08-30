package com.josue.micro.balance;


import com.josue.micro.registry.jee7.EnableClient;
import com.josue.micro.registry.jee7.EnableDiscovery;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by Josue on 13/02/2016.
 */
@EnableClient
@EnableDiscovery(name = "balance")
@ApplicationPath("rest")
public class JaxrsApp extends Application {
}
