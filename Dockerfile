FROM openjdk:8-jdk-alpine

MAINTAINER Sinan Goo 

RUN apk update; apk add --no-cache bash 

RUN mkdir -p /spring_service
WORKDIR /spring_service

COPY build.gradle gradlew gradlew.bat gradle .gradle src /spring_service


