FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/pedidos-0.0.1-SNAPSHOT.jar pedidos-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "pedidos-0.0.1-SNAPSHOT.jar"]