## Workflows con Github Actions :hammer_and_wrench:

En este proyecto se utilizó Github Actions para automatizar los pipelines o workflows de CI/CD,
en este documento se detallan los workflows utilizados y las configuraciones necesarias para su correcto funcionamiento.

### Configuración de Github Actions

Para configurar Github Actions fue necesario crear un archivo `.github/workflows/[main].yml` en la raíz del proyecto,
en este archivo se definen los workflows junto con los distintos steps que se desean ejecutar,
a continuación se presenta un ejemplo de un archivo de configuración de Github Actions:

```
name: Java CI with Gradle

on:
  push:
    branches: [ "master" ]
  pull_request:
    branches: [ "master" ]

jobs:
  build:

    runs-on: ubuntu-latest
    permissions:
      contents: read

    steps:
    - uses: actions/checkout@v4
    - name: Set up JDK 8
      uses: actions/setup-java@v4
      with:
        java-version: '8'
        distribution: 'temurin'
```
Aqui se define un pipeline al cual se ejecuta cuando se hace un push o un pull request a la rama master,
configurando primeramente el sistema operativo en el cual se ejecutará el pipeline, en este caso ubunt, y luego
definir los steps que se desean ejecutar, en este caso se desea ejecutar el pipeline con la versión 8 de Java.
El archivo completo se puede ver aqui [gradle.yml](..%2F.github%2Fworkflows%2Fgradle.yml)

Una vez configurado el archivo de Github Actions, se procede a crear un pull request y se podrá ver el pipeline en accion.
En la siguientes imagenes se puede ver el pipeline en accion donde se realiza la compilación y ejecución de las pruebas unitarias del proyecto,
garantizando de esta forma que el código que se sube a la rama master cumpla con los estándares de calidad definidos.

![pipeline.png](..%2Fimg%2Fpipeline.png)
![pipeline1.png](..%2Fimg%2Fpipeline1.png)

Adicionalmente dicho workflow se puede complementar con un analisis de calidad de código, para esto se puede utilizar herramientas como SonarCloud,
sin embargo para este proyecto no se realizó dicha configuración ya que el proyecto al estar dentro de la organización no tiene accesos a la configuración de SonarCloud
y las llaves necesarias para la integracion.
