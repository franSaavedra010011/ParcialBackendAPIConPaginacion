# TP: API sin paginacion
## Fecha de entrega: 
Miercoles 4 de Octubre - hora 23:00 hs.

## Descripcion:
Realizar las siguientes actividades correspondientes al estudio del modelo de Biblioteca expresado en los videos de Colmena Tec

## 1️⃣ Crear el Modelo de Diagrama de Clase que se muestra en el video:

Capturar la pantalla del diagrama y pegarla en un documento word. El nombre del archivo será apellidoLegajoDia.doc

## 2️⃣ Estudiar la siguiente Playlist:

https://www.youtube.com/watch?v=rmCvCOBAqEA&list=PLRFOqDrY-6nueU8NwtjRIcX5-nsD6jkru&ab_channel=ColmenaTEC

Desde el video :
- API REST con Spring Boot 1 Introducción

Hasta el video:
- API REST con Spring Boot 12 Probando la API con Postman

a)  No considerar la sección de auditoría de Enver.

b) Refactorice el código  de los videos para utilizar una base de datos H2.

c) Coloque las dependencias correspondientes de Swagger como dependencia en el buil.gradle:

	// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
	implementation group: 'org.springdoc', name: 'springdoc-openapi-starter-webmvc-ui', version:'2.1.0'
`
d) Crearse una cuenta en Render

f) Incorporar en el archivo de build.gradle:

	jar {
	   manifest {
		  attributes 'RestfakeApplication': 'com.facu.restfake.RestfakeApplication' // Reemplaza 'tu.paquete.MainClass' con la clase principal de tu aplicación
	   }
	}

:fa-exclamation-triangle: **OJO ACA **: 'RestfakeApplication' ES EL NOMBRE DE TU MAIN Y com.facu.restfake.RestfakeApplication' PONELE EL NOMBRE DE TU PAQUETE!

Ejecute el comando `gradle build`  desde la terminal para crear el jar correspondiente.
Se creará en el proyecto una carpeta:

	build/libs/restfake-0.0.1-SNAPSHOT.jar

e)  Utilizar el Archivo Dockerfile que se propone en el github y actualizar el nombre de tu jar:

	FROM openjdk:17-alpine
	EXPOSE 9000
	COPY --from=build ./build/libs/elnombredetujar-0.0.1-SNAPSHOT.jar ./app.jar

f ) Descargar el proyecto **MODELO AUXILIAR**  a analizar desde el Link de Github:

https://github.com/cortezalberto/claseFakeGenerico
