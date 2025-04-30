# ⛏️ Stage 1: Build the Spring Boot app
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copie uniquement les fichiers nécessaires au build Maven
COPY .mvn .mvn
COPY mvnw pom.xml ./
COPY src src

# Rendez le wrapper exécutable
RUN chmod +x mvnw

# Build (skip tests)
RUN ./mvnw clean package -DskipTests

# 🏃 Stage 2: Runtime image
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copie uniquement le JAR généré
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]