FROM openjdk:11.0-jdk

ADD ./target/game-manager-service-0.0.1-SNAPSHOT.jar /event/src/game-manager-service-0.0.1-SNAPSHOT.jar
ADD ./assets/GameMovies.xlsx /event/src/assets/GameMovies.xlsx
EXPOSE 8102
WORKDIR event/src
ENTRYPOINT ["java","-jar","game-manager-service-0.0.1-SNAPSHOT.jar"]
