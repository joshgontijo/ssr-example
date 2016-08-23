package com.josue.micro.balance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Josue on 23/06/2016.
 */
@Path("balances")
public class BalanceResource {

    @GET
    public String getBalance(){
        return "Balance";
    }

}
