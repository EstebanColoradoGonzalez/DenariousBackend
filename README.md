# DenariousBackend

Bienvenido al repositorio **DenariousBackend**, el núcleo del sistema de gestión financiera de Denarious. Este repositorio contiene el código fuente y los servicios necesarios para manejar la lógica de negocio, procesamiento de datos y la comunicación con la base de datos para nuestra aplicación.

## Descripción del Proyecto

**DenariousBackend** proporciona una serie de API y servicios que soportan las funcionalidades de la aplicación Denarious, permitiendo a los usuarios gestionar sus finanzas personales de manera eficiente. Entre las principales funcionalidades se incluyen:

- **Gestión de Transacciones:** Creación, edición y eliminación de ingresos y egresos.
- **Visualización de Estadísticas Financieras:** Suministro de datos para gráficos y resúmenes financieros.
- **Filtros y Consultas Personalizadas:** Filtrado de transacciones por fecha, categoría, subcategoría y otros parámetros.
- **Autenticación y Autorización:** Seguridad robusta para garantizar que solo los usuarios autorizados accedan a sus datos financieros.

## Requisitos Previos

Antes de configurar y ejecutar el proyecto, asegúrese de tener instalados los siguientes requisitos previos:

- **Lenguaje de Programación:** Java 17
- **Framework:** Spring Bott 3.3.0
  - **Base de Datos:** PostgreSQL 16
- **Herramienta de Construcción:** Gradle 8.8
- **Sistema de Control de Versiones:** Git
- **Insomnia o Postman:** Para probar las APIs
- **Intellij IDEA:** Para abrir el proyecto y ejecutar el repositorio

## Instrucciones de Configuración y Ejecución

Siga los pasos a continuación para configurar y ejecutar el proyecto localmente.

### Clonar el Repositorio

```bash
git clone https://github.com/estebancoloradogonzalez/DenariousBackend.git
cd DenariousBackend
```

### Abrir el Proyecto en IntelliJ IDEA

1. **Abrir IntelliJ IDEA**:
    - Inicie IntelliJ IDEA desde su menú de aplicaciones.

2. **Importar el Proyecto**:
    - Seleccione `Open or Import` en la pantalla de bienvenida.
    - Navegue hasta el directorio donde clonó el repositorio de **DenariousBackend**.
    - Seleccione el archivo `build.gradle` (o `pom.xml` si está utilizando Maven) y haga clic en `OK`.

3. **Configurar el SDK de Java**:
    - Vaya a `File > Project Structure > Project`.
    - En `Project SDK`, seleccione `Add SDK` y elija la versión de Java que requiere el proyecto (por ejemplo, Java 11 o Java 17).
    - Asegúrese de que `Project language level` esté configurado correctamente según la versión de Java.

4. **Configurar Gradle**:
    - Vaya a `File > Settings > Build, Execution, Deployment > Build Tools > Gradle`.
    - En `Gradle JVM`, seleccione el SDK de Java configurado anteriormente.
    - Asegúrese de que `Use Gradle from` esté configurado en `wrapper task in Gradle build script`.

### Configuración de la Base de Datos con PostgreSQL 16 y pgAdmin 4

1. **Instalar PostgreSQL 16**:
    - Descargue e instale PostgreSQL 16 desde el [sitio oficial de PostgreSQL](https://www.postgresql.org/download/).

2. **Configurar PostgreSQL**:
    - Durante la instalación, configure un nombre de usuario y contraseña para el superusuario (por ejemplo, `postgres` y `password`).

3. **Abrir pgAdmin 4**:
    - Inicie pgAdmin 4 desde su menú de aplicaciones.
    - Conéctese a su servidor PostgreSQL utilizando las credenciales configuradas durante la instalación.

4. **Crear una Base de Datos**:
    - Haga clic derecho en `Databases` y seleccione `Create > Database`.
    - Nombre la base de datos como `denarious` y haga clic en `Save`.

### Configurar Variables de Entorno

1. **Crear un Archivo de Configuración**:
    - En el directorio raíz del proyecto, cree un archivo llamado `.env`.
    - Añada las siguientes variables de entorno al archivo:

    ```env
    DATABASE_URL=jdbc:postgresql://localhost:5432/denarious
    DATABASE_USER=postgres
    DATABASE_PASSWORD=password
    JWT_SECRET=tu_secreto_jwt
    ```

###Ejecutar el Proyecto en IntelliJ IDEA

1. **Cargar Dependencias**:
    - IntelliJ IDEA automáticamente detectará el archivo `build.gradle` (o `pom.xml`) y comenzará a descargar las dependencias necesarias.

2. **Compilar el Proyecto**:
    - Vaya a `View > Tool Windows > Gradle`.
    - En la ventana de Gradle, expanda su proyecto y haga clic en `Tasks > build > build`.

3. **Configurar la Ejecución de la Aplicación**:
    - Vaya a `Run > Edit Configurations`.
    - Haga clic en el icono `+` y seleccione `Spring Boot` (o `Application` si usa otro framework).
    - Configure el nombre de la configuración y asegúrese de que la clase principal esté seleccionada correctamente.
    - Asegúrese de que las variables de entorno del archivo `.env` estén configuradas en `Environment variables`.

4. **Ejecutar la Aplicación**:
    - Haga clic en el botón `Run` o presione `Shift + F10`.

### Ejecutar Pruebas en IntelliJ IDEA

1. **Ejecutar Todas las Pruebas**:
    - Vaya a `View > Tool Windows > Gradle`.
    - En la ventana de Gradle, expanda su proyecto y haga clic en `Tasks > verification > test`.

2. **Ver Resultados de las Pruebas**:
    - Los resultados de las pruebas se mostrarán en la ventana de `Run`.

### Probar las APIs

Utilice Postman o cualquier otra herramienta de su elección para probar las APIs. Puede importar la colección de Postman proporcionada en el directorio `docs/apis` para facilitar las pruebas.

## Estructura del Proyecto

DenariousBackend usa una arquitectura hexagonal basada en el modelo C4. Puede consultar el diagrama de componentes del backend para más detalles.

```
DenariousBackend/
│
├── src/
│   ├── main/
│   │   ├── java/com/denarious/backend/
│   │   │   ├── application/         # Servicios de aplicación
│   │   │   ├── domain/              # Entidades y lógica de dominio
│   │   │   ├── infrastructure/      # Adaptadores y configuración de infraestructura
│   │   │   └── web/                 # Controladores y configuraciones web
│   │   ├── resources/               # Archivos de configuración y recursos estáticos
│   │   └── docker/                  # Archivos Docker
│   └── test/                        # Pruebas unitarias e integradas
├── docs/                            # Documentación del proyecto
│   ├── postman/                     # Colección de Postman para pruebas de API
│   └── architecture/                # Diagramas de arquitectura
├── .env                             # Archivo de configuración de entorno
├── Dockerfile                       # Archivo Docker para crear la imagen de la aplicación
├── README.md                        # Documentación del proyecto
└── pom.xml                          # Archivo de configuración de Maven
```

## Información sobre Contribución y Contacto

### Contribuir al Proyecto

¡Gracias por considerar contribuir a DenariousBackend! A continuación, se detallan los pasos para contribuir al proyecto de manera efectiva.

#### 1. Guía para Escribir los Commits

La calidad del historial de commits en un proyecto es crucial para mantener la claridad, la trazabilidad y la colaboración efectiva entre los desarrolladores. Esta guía establece un estándar para la creación de mensajes de commit en nuestro proyecto. Siguiendo estas pautas, aseguraremos que nuestro historial de commits sea fácil de entender y de gestionar.

**1. Usa el verbo imperativo**

Los mensajes de commit deben comenzar con un verbo en imperativo (por ejemplo, Add, Change, Fix, Remove). Considera el mensaje del commit como una instrucción para cambiar el estado del proyecto.

**Ejemplos:**

- `Add a new search feature`
- `Fix a problem with the topbar`
- `Change the default system color`
- `Remove a random notification`

**2. No uses punto final ni puntos suspensivos**

Evita usar puntos finales y puntos suspensivos en los mensajes de commit.

**Ejemplos:**

- `git commit -m "Add new search feature."` # ❌
- `git commit -m "Fix a problem with the topbar..."` # ❌
- `git commit -m "Change the default system color"` # ✅

**3. Usa como máximo 50 caracteres para el mensaje del commit**

Los mensajes de commit deben ser cortos y concisos. Si necesitas más espacio para explicar los cambios, considera dividir el commit en varios más pequeños.

**Ejemplos:**

- `git commit -m "Add new search feature and change typography to improve performance"` # ❌
- `git commit -m "Add new search feature"` # ✅
- `git commit -m "Change typography to improve performance"` # ✅

**4. Añade contexto en el cuerpo del mensaje del commit**

Proporciona más contexto sobre los cambios realizados en el cuerpo del mensaje del commit.

```bash
git commit -m "Add new search feature" -m "This feature allows users to search for products using keywords and filters."
```

**5. Usa un prefijo para tus commits para hacerlos más semánticos**

Para mejorar la legibilidad del historial de commits, añade un prefijo que indique el tipo de cambio realizado.

Formato:

```bash
<tipo-de-commit>[scope]: <descripción>
```

**Ejemplos:**

- `feat: add new search feature`
- `fix: remove wrong color`
- `feat(backend): add filter for cars`
- `fix(web): correct header alignment`

**Tipos de Cambios:**

- `feat`: Una nueva característica para el usuario.
- `fix`: Arregla un bug que afecta al usuario.
- `perf`: Cambios que mejoran el rendimiento del sitio.
- `build`: Cambios en el sistema de build, tareas de despliegue o instalación.
- `ci`: Cambios en la integración continua.
- `docs`: Cambios en la documentación.
- `refactor`: Refactorización del código como cambios de nombre de variables o funciones.
- `style`: Cambios de formato, tabulaciones, espacios o puntos y coma; no afectan al usuario.
- `test`: Añade tests o refactoriza uno existente.

**Por qué es importante:**
El uso de commits semánticos facilita la lectura del historial de commits y permite la generación automatizada de changelogs, la publicación de nuevas versiones y el despliegue de aplicaciones.

### Ejemplos de Mensajes de Commit

#### Correcto

- `feat: add user authentication`
- `fix: resolve crash on login screen`
- `docs: update API documentation`
- `style: format code with prettier`
- `refactor: rename user service to auth service`
- `test: add unit tests for login feature`
- `perf: improve query performance`
- `build: update webpack configuration`
- `ci: add GitHub Actions workflow`

#### Incorrecto

- `Added user authentication...`
- `Fixed a bug in the login screen.`
- `Refactoring the user service.`
- `Added tests and fixed bugs and updated documentation.`

Siguiendo estas pautas, aseguraremos que nuestro historial de commits sea consistente, claro y útil para todos los miembros del equipo.

---

#### 2. Guía de despliegue a los diferentes ambientes

Para asegurar un flujo de trabajo ordenado y eficiente, utilizaremos un esquema de ramas en Git que nos permita gestionar los cambios de manera clara y controlada. Este esquema incluirá tres ramas principales: `develop`, `test` y `main`. A continuación, se describen las reglas y pasos a seguir para llevar los cambios a los diferentes ambientes.

### Estructura de Ramas

- **`develop`**: Esta rama es utilizada para el desarrollo local. A partir de esta rama se crean las ramas de características (features).
- **`test`**: Esta rama se usa para pruebas. Los cambios provenientes de `develop` se integran aquí para ser testeados.
- **`main`**: Esta es la rama de producción. Sólo los cambios probados y certificados llegan a esta rama.

### Flujo de Trabajo

#### 1. Desarrollo en la Rama `develop`

Todo el desarrollo inicial se realiza en la rama `develop`. Esta es la rama base para crear nuevas características (features).

#### Crear una Rama de Feature

Para comenzar a trabajar en una nueva característica, se debe crear una rama de feature a partir de `develop`. La estructura del nombre de la rama debe seguir el siguiente formato:

```bash
<codigo_de_la_subtarea>_<nombre_de_la_subtarea_en_especifico_en_ingles>
```

**Ejemplo:**

Si tienes una historia de usuario con el código 1.1.1.1 y el nombre "Implementar búsqueda avanzada", la rama de feature se llamará:

```bash
feature/1.1.1.1_Implement_advanced_search
```


**Comandos:**

```bash
git checkout develop
git pull origin develop
git checkout -b 1.1.1.1_Implement_advanced_search
```

### 2. Desarrollo en la Rama de Feature

Realiza todos los cambios necesarios en la rama de feature. Asegúrate de seguir las guías de estilo y de commit descritas en este manual.

### 3. Pull Request a `develop`

Una vez completado el desarrollo en la rama de feature, crea un Pull Request (PR) para fusionar los cambios en `develop`.

### Pasos para Crear un PR:

1. **Push de la Rama de Feature:**

    ```bash
    git add .
    git commit -m "feat: Implements advanced search"
    git push origin 1.1.1.1_Implement_advanced_search
    ```

2. **Crear el PR en la Plataforma de Git:**
   - Ve a la interfaz de tu repositorio en GitHub, GitLab o la plataforma que estés utilizando.
   - Navega a la sección de Pull Requests y crea un nuevo PR desde tu rama de feature (`1.1.1.1_Implement_advanced_search`) hacia `develop`.

3. **Revisión del PR:**
   - Asegúrate de que al menos un desarrollador revise y apruebe el PR antes de fusionarlo.
   - Realiza los cambios necesarios según los comentarios de la revisión.

4. **Merge del PR:**
   - Una vez aprobado, fusiona el PR en `develop`.

### 4. Integración en la Rama `test`

Después de que los cambios se hayan fusionado en `develop`, es momento de integrarlos en `test` para pruebas más exhaustivas.

### Pasos para Integrar en `test`:

1. **Actualizar `develop` y Crear un PR a `test`:**

    ```bash
    git checkout test
    git pull origin test
    git checkout develop
    git pull origin develop
    git merge develop
    git push origin test
    ```

2. **Crear el PR:**
   - Navega a la sección de Pull Requests en tu plataforma de Git.
   - Crea un PR desde `test` hacia `main`.

3. **Revisión del PR:**
   - Asegúrate de que el equipo responsable de la producción revise y apruebe los cambios.

4. **Merge del PR:**
   - Una vez aprobado, fusiona el PR en `main`.

### Resumen del Flujo de Trabajo

1. **Desarrollo Local:**
   - `develop` -> Crear rama de feature: `<codigo_de_la_subtarea>_<nombre_de_la_subtarea_de_usuario_en_especifico>`
   - Desarrollar en la rama de feature
   - Crear PR de feature a `develop`

2. **Integración y Pruebas:**
   - `develop` -> Crear PR a `test`
   - Realizar pruebas en `test`

3. **Despliegue a Producción:**
   - `test` -> Crear PR a `main`
   - Desplegar en `main`

## Conclusión

Siguiendo este flujo de trabajo estructurado, garantizamos que los cambios en nuestro proyecto se realicen de manera ordenada y controlada, minimizando los riesgos y asegurando la calidad del código en cada etapa del desarrollo.

### Contacto

Si tienes alguna pregunta, sugerencia o necesitas asistencia, no dudes en ponerte en contacto con nosotros:

- **Proyecto en GitHub**: [DenariousBackend](https://github.com/estebancoloradogonzalez/DenariousBackend.git)
- **Correo Electrónico**: [denarioues@gmail.com](mailto:denarious@gmail.com)

Estamos aquí para ayudarte y agradecemos tu contribución al proyecto.
