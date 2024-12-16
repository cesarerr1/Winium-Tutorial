# Ejecución de pruebas en FarMax

## Versiones utilizadas

- ### Java: JDK 17
- ### Selenium: 4.1.0
- ### JUnit: 4.13.2
- ### Cucumber: 7.20.0
- ### Cucumber-JUnit: 7.20.0
- ### Winium: 0.1.0-1
- ### Allure-JUnit4: 2.29.0
- ### Allure-Cucumber7-JVM: 2.29.0

### Java

Descargar instalador de [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) o instalar desde terminal ejecutando el siguiente comando.

```powershell
winget install --id Oracle.JDK.17 -e
```

Después de instalar Java la versión 17, buscar "PowerShell" o "Terminal", dar clic derecho sobre la aplicación y ejecutarla como administrador.

Ejecutar el siguiente comando para agregar la ruta de Java a la variable de entorno de `JAVA_HOME`.

```powershell
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-17", "Machine")
```

### Allure Reporter

#### Instalar desde binario

Descargar [Allure Reporter .zip](https://maven.apache.org/download.cgi)

Descomprimir el archivo .zip y mover la carpeta a `C:\Program Files`

Debería quedar la carpeta `C:\Program Files\allure-version`

En el buscador de Windows buscar "Editar las variables de entorno del sistema", en la ventana emergente, dar clic en "Variables de entorno".

En las "Variables de usuario" seleccionar la variable `Path`, dar clic en editar, dar clic en "Nuevo", pegar la ruta de la carpeta `bin` de Allure,  `C:\Program Files\allure-version\bin` y dar clic en "Aceptar".

Después de agregar la variable de entorno, dar clic en "Aceptar" en la ventana "Variables de entorno".

#### Instalar desde Terminal

Instalar Scoop

```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser

Invoke-RestMethod -Uri https://get.scoop.sh | Invoke-Expression
```

Instalar Allure Reporter con Scoop

```powershell
Scoop install allure
```

#### Verificar la instalación de Allure

```powershell
allure --version
```

### Maven

Descargar Maven [Binary zip archive](https://maven.apache.org/download.cgi)

Descomprimir el archivo .zip y mover la carpeta a `C:\Program Files`

Debería quedar la carpeta `C:\Program Files\apache-maven-version`

En el buscador de Windows buscar buscar "Editar las variables de entorno del sistema", en la ventana emergente, dar clic en "Variables de entorno".

En las "Variables de usuario" seleccionar la variable `Path`, dar clic en editar, dar clic en "Nuevo", pegar la ruta de la carpeta `bin` de Maven,  `C:\Program Files\apache-maven-version\bin` y dar clic en "Aceptar".


En las "Variables del sistema", dar clic en editar, dar clic en "Nueva", en "Nombre de la variable" escribir `MAVEN_HOME` y en "Valor de la variable" escribir `C:\Program Files\apache-maven-version\bin` y dar clic en "Aceptar".

Después de agregar la variable de entorno, dar clic en "Aceptar" en la ventana "Variables de entorno".

### IntelliJ IDEA Community Edition

Descargar instalador de [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/) o instalar desde Winget.

```powershell
winget install --id JetBrains.IntelliJIDEA.Community -e
```

## Driver Winium Desktop

Descargar y ejecutar con permisos de administrador el driver de winium del repositorio
````
https://github.com/2gis/Winium.Desktop
````

## Creación de las clases runner
Ubicar el archivo `run.bat` que se encuentra en la ruta `src/test/resources/run.bat`

Una vez ubicado se debera ejecutar desde linea de comandos

```shell
./src/test/resurces/run.bat
```
Una vez ejecutado se mostraran las clases generadas, se crea una clase runner por cada archivo feature

En caso de que se requiera ejecutar las pruebas en un orden especifico, responder `s` a la pregunta `¿Quieres ingresar un orden específico para las clases? (s/n):` en caso de seleccionar `n` las pruebas se ejecutarán con el orden que se muestra

Una vez que se contesto `s` se debe colocar el orden de las pruebas separadas por comas, unicamente con los números que aparecen en la pantalla

Para aquellos archivos features que cuenten con más de un escenario se preguntará que tags (escenarios) se desean ejecutar, la selección de los escenarios es igual a la anterior

## Configuración de los CSV

Para que los archivos features extraigan la información de los archivos CSV se deben configurar en el archivo `pom.xml` en el espacio de `build` y `<arguments>`

Por cada archivo feature se debera especificar el CSV del que se tomaran los datos, a continuación se presenta un ejemplo de ello

```shell
<argument>src/test/resources/data/Usuarios.csv</argument>
<argument>src/test/resources/features/Login.feature</argument>
```
Primero se debe especificar el archivo CSV y después el archivo feature que hará uso del CSV
## Ejecución de las pruebas 

Una vez que se hayan creado los runner con los pasos anteriores se podran ejecutar las pruebas con el comando en la terminal

Nota: ejecutar el Ide (entorno de desarrollo) con permisos de administrador 
```shell
mvn test
```

## Levantar reporte de allure
Una vez que se hayan ejecutado todas las pruebas se podrán ver los reusltados de allure ejecutando en la linea de comandos
```shell
allure serve
```