FROM java:8
EXPOSE 8091
VOLUME /tmp
ADD target/vehicle-service-1.0-1.jar vehicle-service-1.0-1.jar
ENTRYPOINT ["java","-jar","/vehicle-service-1.0-1.jar"]