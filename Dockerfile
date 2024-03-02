FROM eclipse-temurin:17-jre-alpine
WORKDIR /workspace
COPY target/capitulo6-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/workspace/app.jar"]