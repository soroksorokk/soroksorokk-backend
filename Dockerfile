FROM openjdk:17-ea-3-jdk-slim
RUN mkdir -p deploy
WORKDIR /deploy
COPY ./build/libs/soroksorokk-0.0.1-SNAPSHOT.jar api.jar
ENTRYPOINT ["java", "-jar", "/deploy/api.jar"]