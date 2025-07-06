# Use a lightweight OpenJDK image
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY /home/runner/work/target/nectar-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"] 