FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM openjdk:11
#COPY build/libs/filescan-0.0.1-SNAPSHOT.jar filescan-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","filescan-0.0.1-SNAPSHOT.jar"]
