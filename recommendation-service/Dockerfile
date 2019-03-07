FROM openjdk:11.0-jdk
ADD ./target/recommendation-service-0.0.1-SNAPSHOT.jar /event/src/recommendation-service-0.0.1-SNAPSHOT.jar
EXPOSE 8104
WORKDIR event/src

ENTRYPOINT ["java", "-jar", "recommendation-service-0.0.1-SNAPSHOT.jar"]

