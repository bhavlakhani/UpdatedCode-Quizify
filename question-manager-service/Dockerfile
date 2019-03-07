FROM openjdk:11.0-jdk
ADD ./target/question-manager-service-0.0.1-SNAPSHOT.jar /event/src/question-manager-service-0.0.1-SNAPSHOT.jar
ADD ./assets/MoviesBasicAll.xlsx /event/src/assets/MoviesBasicAll.xlsx
EXPOSE 8001
WORKDIR event/src

ENTRYPOINT ["java", "-jar", "question-manager-service-0.0.1-SNAPSHOT.jar"]