package com.josue.micro.balance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Josue on 23/06/2016.
 */
@Path("balances")
public class BalanceResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBalance(){
        return "Balance";
    }

}
