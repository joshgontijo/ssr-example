package com.josue.micro.account;

import com.josue.micro.registry.client.ServiceConfig;
import com.josue.micro.registry.client.ServiceStore;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * Created by Josue on 23/06/2016.
 */
@Path("accounts")
@ApplicationScoped
public class AccountResournce {

    private static final String BALANCE_SERVICE = "balance";
    private static final String BALANCE_RESOURCE_PATH = "balances";

    @Inject
    private ServiceStore serviceStore;

    @GET
    public String getAccount() {
        return "Account -> " + getAddress();
    }

    private String getAddress() {
        ServiceConfig serviceConfig = serviceStore.getAny(BALANCE_SERVICE);
        if (serviceConfig == null) {
            return "NO_ADDRESS_SERVICE";
        }

        Response response = ClientBuilder.newClient()
                .target(serviceConfig.getAddress())
                .path(BALANCE_RESOURCE_PATH)
                .request()
                .get();

        String body = response.readEntity(String.class);

        if (!Response.Status.OK.equals(response.getStatusInfo())) {
            return "REQUEST_ERROR: " + response.getStatus() + " -> " + body;
        }
        return body;
    }

}
