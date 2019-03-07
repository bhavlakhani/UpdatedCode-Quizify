#FROM openjdk:11.0-jdk
#ADD ./target/user-authentication-0.0.1-SNAPSHOT.jar app/user-authentication-0.0.1-SNAPSHOT.jar
#WORKDIR muzix/app
#ENTRYPOINT ["java", "-jar", "user-authentication-0.0.1-SNAPSHOT.jar"]
FROM openjdk:11

ADD ./target/user-authentication-service-0.0.1-SNAPSHOT.jar /event/src/user-authentication-service-0.0.1-SNAPSHOT.jar
EXPOSE 8095
WORKDIR event/src
ENTRYPOINT ["java","-jar","user-authentication-service-0.0.1-SNAPSHOT.jar"]

