FROM ubuntu:latest
WORKDIR /opt
RUN apt-get update && apt-get upgrade && apt install -y openjdk-8-jdk
RUN apt install -y maven
RUN mkdir app
COPY pom.xml ./app
COPY src ./app/src
RUN cd /opt/app && mvn package
EXPOSE 9099

CMD cd ./app/target && java -jar first-task.jar
