FROM openjdk:11-jdk-alpine
COPY target/Springboot_dockerImage.jar Springboot_dockerImage.jar
ENTRYPOINT ["java","-jar","/Springboot_dockerImage.jar"]