FROM adoptopenjdk/openjdk11:alpine-jre
#VOLUME /tmp
MAINTAINER haritech.com
#ARG JAR_FILE=/var/lib/jenkins/workspace/spring-gradle-docker/build/libs/spring-rest-oracle-demo.war
#WORKDIR /opt/app
#COPY ${JAR_FILE} /var/lib/jenkins/workspace/spring-gradle-docker
ADD build/libs/spring-rest-oracle-demo.war spring-rest-oracle-demo.war
ENTRYPOINT ["java","-jar","spring-rest-oracle-demo.war"]
EXPOSE 8081