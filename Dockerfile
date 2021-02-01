FROM openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}

ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /target/pessoas-api-1.0.0-SNAPSHOT.jar pessoas-api.jar

SHELL ["/bin/sh","-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar pessoas-api.jar --spring.profile.active=${PROFILE}





