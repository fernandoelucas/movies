FROM openjdk:8u131-jdk-alpine
ADD target/movies-videostream-0.0.1-SNAPSHOT.jar app-movies-videostream.jar
EXPOSE 8010
ENTRYPOINT ["java","-jar","/app-movies-videostream.jar"] 