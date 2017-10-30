FROM openjdk:8-jdk-alpine

MAINTAINER Sinan Goo 

RUN apk update; apk add --no-cache bash 

RUN mkdir -p /spring_service
WORKDIR /spring_service

COPY build.gradle gradlew gradlew.bat /spring_service/
COPY gradle /spring_service/gradle
# COPY .gradle /spring_service/.gradle
COPY src /spring_service/src

RUN ./gradlew build

EXPOSE 8080

ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -jar build/libs/spring_service.jar

