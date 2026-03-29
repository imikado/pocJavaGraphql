FROM maven:3.9-eclipse-temurin-17-alpine
WORKDIR /app

# Cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -q

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]
