FROM java:8
EXPOSE 8080
VOLUME /tmp
ADD target/ribbon-web-clients-1.0-1.jar ribbon-web-clients-1.0-1.jar
ENTRYPOINT ["java","-jar","/ribbon-web-clients-1.0-1.jar"]