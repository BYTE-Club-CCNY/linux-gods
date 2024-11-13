FROM eclipse-temurin:jdk-21 AS base
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN /.mvnw dependency:go-offline -B
COPY src ./src

RUN .mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app
COPY --from=build /app/target/*.jar application.jar
EXPOSE 8080
USER jar
ENTRYPOINT [ "java", "-jar", "application.jar" ]