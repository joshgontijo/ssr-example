FROM openjdk:8
ADD target/balance-swarm.jar /account.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "account.jar"]