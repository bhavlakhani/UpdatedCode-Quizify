FROM openjdk:11.0-jdk

ADD ./target/single-player-engine-0.0.1-SNAPSHOT.jar /event/src/single-player-engine-0.0.1-SNAPSHOT.jar
EXPOSE 8108
WORKDIR event/src
ENTRYPOINT ["java","-jar","single-player-engine-0.0.1-SNAPSHOT.jar"]

