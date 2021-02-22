FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
MAINTAINER haritech.com
ARG JAR_FILE=/var/lib/jenkins/workspace/SpringRestOracleDemo/SpringRestOracleDemo.war
WORKDIR /opt/app
COPY ${JAR_FILE} SpringRestOracleDemo.war
ENTRYPOINT ["java","-jar","SpringRestOracleDemo.war"]
EXPOSE 8081