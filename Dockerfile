FROM openjdk:17
EXPOSE 8001
ADD target/bankingApi-0.0.1-SNAPSHOT.jar bankingApiMicroservice.jar
ENTRYPOINT ["java","-jar","/bankingApiMicroservice.jar"]