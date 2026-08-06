FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN ./mvne clean package -DskipTests

EXPOSE 8080

CMD ["java","jar","target/sistema-notificacoes-0.0.1-SNAPSHOT.jar"]