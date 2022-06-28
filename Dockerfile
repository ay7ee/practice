FROM openjdk:18
EXPOSE 8090
ADD target/spring-docker.jar spring-docker.jar
ENTRYPOINT ["java", "-jar", "/spring-docker.jar"]