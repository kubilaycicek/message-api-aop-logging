FROM adoptopenjdk/maven-openjdk11:latest
WORKDIR /home/app/api
COPY /spring-boot-aop-test .


RUN ["mvn", "install", "-Dmaven.test.skip=true"]


EXPOSE 8080:9090

ENTRYPOINT ["java","-jar","/home/app/api/target/spring-boot-aop-test-0.0.1-SNAPSHOT.jar"]

