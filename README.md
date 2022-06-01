# MutantesAPi

_El proyecto es para determinar si un humano es muntante o no, esto se hace por medio de su dna, al encontrar una secuencia de 4 coincidencias continuas se determina que es mutante._

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_Que cosas necesitas para instalar el software y como instalarlas_

```
java-1.8.0-openjdk
apache-maven-3.8.5
git
```

### Instalación 🔧

_Desde tu consola de git utilizar:_
```
git clone https://github.com/Charalo/mutantes.git
git fetch
git checkout master
```
_Una vez descargado el proyecto, abrirlo con el IDE de tu preferencia. Posteriormente ejecutar:_
```
mvn dependency:resolve
```
_Con esto descargara todas las dependencias necesarias._

_El proyecto ya contiene un tomcat integrado por lo que solo tendras que levantarlo de manera manual o utilizar:_
```
mvn spring-boot:run
```
## Ejecutando las pruebas ⚙️

_Para ejecutar todas las pruebas lo pueden realizar con:_
```
mvn test
```
O tambien pueden ejecutarse de manera unitaria en el paquete com/example/mutantes/service/MutantServiceTest.java


## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [SPRING-BOOT](https://spring.io/projects/spring-boot) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [JUNIT](https://junit.org/junit5/docs/current/user-guide/) - Usado para generar RSS
* [H2](https://h2database.com/html/main.html) - Como BD
* [JAVA](https://www.java.com/es/)

#
## Autor ✒️

* **Carlos Alcalá** 

## Expresiones de Gratitud 🎁

* A todo el team de tribu chido, gracias por ayudarme con tantas dudas, los tqm.
