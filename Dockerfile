FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./build/libs/currency-convertor-1.0.0.jar /app/currency-convertor.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/currency-convertor.jar"]
