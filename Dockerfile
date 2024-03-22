FROM --platform=linux/amd64 openjdk:17-alpine

WORKDIR /service

COPY ./time-tracking-service.jar ./time-tracking-service.jar

RUN /bin/sh -c 'touch /service/time-tracking-service.jar'

CMD ["java", "-jar", "time-tracking-service.jar"]