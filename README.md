## Registry sample services
Sample services that demonstrate how the **service-registry** works

### Endpoints
The service accounts depends on balances service.
    
    //account
    GET http://IP:PORT/account/rest/accounts
    
    //balance
    GET http://IP:PORT/balance/rest/balances
    
    //sample-spring
    GET http://IP:PORT/
    
## Deploying

### Manually
With system property

**Account service**

    -Daccount.url=http://IP:PORT/account -Dregistry.url=http://IP:PORT
    
**Balance service**

    -Dbalance.url=http://IP:PORT/balance -Dregistry.url=http://IP:PORT

**Spring sample service**

    -DsampleSpring.url=http://IP:PORT/balance -Dregistry.url=http://IP:PORT

### Docker

    docker build -t balance balance/
    docker build -t account account/
    docker build -t account sample-spring/
    
    docker run -it -d -p 8081:8080 -e account.url=http://SERVICE_IP:8081/account -e registryUrl=http://REGISTRY_IP:PORT account
    docker run -it -d -p 8082:8080 -e balance.url=http://SERVICE_IP:8082/balance -e registryUrl=http://REGISTRY_IP:PORT balance
    docker run -it -d -p 8083:8080 -e sampleSpring.url=http://SERVICE_IP:8082/ -e registryUrl=http://REGISTRY_IP:PORT smple-spring

    