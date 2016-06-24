package com.josue.micro.address;

import com.josue.micro.registry.client.discovery.EnableDiscovery;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by Josue on 13/02/2016.
 */
@EnableDiscovery(serviceName = "balance")
@ApplicationPath("rest")
public class JaxrsApp extends Application {
}
