package com.josue.micro.example.spring;

import com.josue.micro.registry.client.ServiceInstance;
import com.josue.micro.registry.client.ServiceStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Josue on 17/07/2016.
 */
@RestController
public class SampleResource {

    private static final String serviceName = "balance";

    @Autowired
    private ServiceStore serviceStore;

    @RequestMapping
    public String getMessage() {
        String response = getBalance();
        return "Spring sample -> " + response;
    }

    private String getBalance() {
        ServiceInstance instance = serviceStore.get(serviceName);
        if (instance == null) {
            return "NO_BALANCE_SERVICE";
        }

        String url = instance.getAddress() + "/balances";

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            String body = response.getBody();
            if (!HttpStatus.OK.equals(response.getStatusCode())) {
                return "REQUEST_ERROR: " + response.getStatusCode() + " -> " + body;
            }
            return body;

        } catch (RestClientException rcex){
            return rcex.getMessage();
        }
    }
}
