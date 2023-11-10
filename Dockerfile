FROM openjdk:11
COPY target/Springboot_dockerImage.jar Springboot_dockerImage.jar
ENTRYPOINT ["java","-jar","/Springboot_dockerImage.jar"]