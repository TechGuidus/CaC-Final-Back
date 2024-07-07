# Usa una imagen base de OpenJDK para Java 21
FROM openjdk:21

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven al contenedor
COPY target/cac-final-0.0.1-SNAPSHOT.jar /app/app.jar
COPY src/main/resources/application.properties /app/application.properties

# Copia el archivo .env al contenedor
COPY .env /app/.env

# Establece las variables de entorno desde el archivo .env
ARG SPRING_DATASOURCE_URL
ARG SPRING_DATASOURCE_USERNAME
ARG SPRING_DATASOURCE_PASSWORD


ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL}
ENV SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME}
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}

# Expone el puerto en el que tu aplicación Spring Boot escucha
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
