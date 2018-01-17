FROM java:8
EXPOSE 8081
VOLUME /tmp
ADD target/netflix-eureka-server-1.0-1.jar netflix-eureka-server-1.0-1.jar
ENTRYPOINT ["java","-jar","/netflix-eureka-server-1.0-1.jar"]