FROM openjdk:8
EXPOSE 8080
ADD target/date_of_birth-calculation.jar date_of_birth-calculation.jar
ENTRYPOINT ["java", "-jar", "/springboot-images-new.jar"]