FROM openjdk:11.0-jdk
ADD ./target/search-service-0.0.1-SNAPSHOT.jar /event/src/search-service-0.0.1-SNAPSHOT.jar
EXPOSE 8106
WORKDIR event/src

ENTRYPOINT ["java", "-jar", "search-service-0.0.1-SNAPSHOT.jar"]