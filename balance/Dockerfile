FROM openjdk:8
ADD target/balance-swarm.jar /balance.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "balance.jar"]