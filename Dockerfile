FROM openjdk:17
EXPOSE 8001
ADD banking.jar banking.jar
ENTRYPOINT ["java","-jar","/banking.jar"]