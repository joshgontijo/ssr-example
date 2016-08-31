package com.josue.micro.account;

import com.josue.micro.registry.client.ServiceStore;
import com.josue.ssr.common.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
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
    @Produces(MediaType.TEXT_PLAIN)
    public String getAccount() {
        return "Account -> " + getBalance();
    }

    private String getBalance() {
        Instance instance = serviceStore.get(BALANCE_SERVICE);
        if (instance == null) {
            return "NO_BALANCE_SERVICE";
        }

        Response response = ClientBuilder.newClient()
                .target(instance.getAddress())
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
