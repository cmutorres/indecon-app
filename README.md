# Indecon

Este proyecto consume servicios expuestos por INDECOM.

Consta 2 sub-proyectos:
- indecon-app-back
- indecon-app-front

## indecon-app-front
		
Este proyecto esta generado con Angular CLI version 9.1.9


### Ambiente

- Instalar Git bash
- Tener instalado `Node.js` se utilizó `v14.4.0`, validar con el siguiente comando `node -v`
- Validar `npm` con el comando `npm -v` se utilizó versión `v6.14.5`

### Ejecución
- Abrir `terminal`, estar ubicado dentro de la raíz `/indecon-app-front`
- Ejecutar `npm install` para descargar módulos
- Ahora levantamos la app con `npm start` o `npm server`
- Cargar la app en algún `Browser`, navegar a `http://localhost:4200/`


## indecon-app-back

Este proyecto esta generado con `Maven 4.0.0`, utilizando framework `spring-boot` con `Java 11.0.4`


### Ambiente
		
- Instalar java SDK versión 11 validar con el siguiente comando `java -version` y agregar a PATH de variables de entorno.
- Agregar `Apache Maven` última versión a PATH de variables de entorno, validar con `mvn -version`.

### Ejecución
		
- Abrir `terminal`, estar ubicado dentro de la raíz `/indecon-app-back`	
- Empaquetar proyecto con el siguiente comando: `mvn clean package`. Se tendrá el ejecutable `onboarding-indecon-0.0.1-SNAPSHOT.jar`, válidar en el siguiente directorio `/indecon-app-back/target`	
- En la terminal se debe posicionar `/indecon-app-back/target` y ejecutar `.jar`, ejecutando `java -jar onboarding-indecon-0.0.1-SNAPSHOT.jar` en la consola
- Ya tenemos corriendo nuestra app java. Ir a browser y navegar `http://localhost:8096/onboarding-indecon/valores/anio?keyIndecon=COBRE` para válidar que este corriendo.

### Configuraciones

Archivo de configuración `application.properties`:
-Cambiar port en caso de ser necesario cambiar properties, actualmente `server.port=8096`
-Apuntar a otros ambientes cambiar properties, actualmente `api.indecon.link=http://www.indecon.online`

### TEST

Según IDE ejecutar test unitarios
-Para este desarrollo se utilizo `Intellij IDEA`, ubicarse en raíz de test `indecon-app-back\src\test\java\cl`, botón secundario y `Run tests with coverage`


