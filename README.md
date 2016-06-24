## Registry sample services
Sample services that demonstrate how the **service-registry** works

### Endpoints
The service accounts depends on balances service.
    
    GET http://IP:PORT/account/rest/accounts
    GET http://IP:PORT/balance/rest/balances
    
## Deploying

### Manually
With system property

**Account service**

    -DserviceUrl=http://IP:PORT/account -DregistryUrl=http://IP:PORT
    
**Balance service**

    -DserviceUrl=http://IP:PORT/balance -DregistryUrl=http://IP:PORT

### Docker

    docker build -t balance balance/
    docker build -t account account/
    
    docker run -it -d -p 8081:8080 -e serviceUrl=http://SERVICE_IP:8081/account -e registryUrl=http://REGISTRY_IP:PORT account
    docker run -it -d -p 8082:8080 -e serviceUrl=http://SERVICE_IP:8082/balance -e registryUrl=http://REGISTRY_IP:PORT balance

    