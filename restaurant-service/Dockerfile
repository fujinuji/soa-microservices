FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.18_10

ADD target/restaurant-service.jar restaurant-service.jar
EXPOSE 3333
ENTRYPOINT ["java", "-jar", "/restaurant-service.jar"]