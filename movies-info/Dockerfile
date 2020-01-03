FROM openjdk:8u131-jdk-alpine
VOLUME /tmp
ADD target/movies-info-0.0.1-SNAPSHOT.jar app-info.jar
ENTRYPOINT ["java","-jar","/app-info.jar"]