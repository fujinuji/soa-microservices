FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.18_10

ADD target/email-service.jar email-service.jar
EXPOSE 5555
ENTRYPOINT ["java", "-jar", "/email-service.jar"]