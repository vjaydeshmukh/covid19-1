FROM openjdk:8-jre-slim
COPY ./target/covid19-stats-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "covid19-stats-1.0-SNAPSHOT-jar-with-dependencies.jar"]