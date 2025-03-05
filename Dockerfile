# Utiliser une image OpenJDK comme base
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application fonctionne (modifie selon ton application)
EXPOSE 8080

# Lancer l'application
CMD ["java", "-jar", "app.jar"]
