FROM openjdk:21
ADD target/*.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","/app.jar"]
