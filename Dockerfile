FROM bellsoft/liberica-runtime-container:jdk-21-musl
COPY build/libs/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]