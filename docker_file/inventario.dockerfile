#La línea de abajo indica que basaremos nuestra imagen  
FROM openjdk:11

#Identificar al mantenedor de una imagen
MAINTAINER miriameje@gmail.com

VOLUME /tmp

EXPOSE 8081

COPY docker_file/jar/ec.mjaramillo.inventario-0.0.1-SNAPSHOT.jar inventariomjaramillo.jar
ENTRYPOINT ["java", "-jar", "inventariomjaramillo.jar"]
