FROM java:8
EXPOSE 8090
VOLUME /tmp
ADD target/customer-service-1.0-1.jar customer-service-1.0-1.jar
ENTRYPOINT ["java","-jar","/customer-service-1.0-1.jar"]