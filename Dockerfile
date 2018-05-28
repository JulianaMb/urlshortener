FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY target/urlshortener-1.0.0.jar $PROJECT_HOME/urlshortener-1.0.0.jar

WORKDIR $PROJECT_HOME
CMD ["java", "-Dspring.data.mongodb.uri=mongodb://mongod:27017/urlsDb","-Djava.security.egd=file:/dev/./urandom","-jar","./urlshortener-1.0.0.jar"]