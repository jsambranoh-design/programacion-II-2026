Nombre del proyecto: PF-19 Control de Gastos Personales

Nombre completo del estudiante: Juan Otoniel Sambrano Hernández

Número de carné: 9941-25-14918

Descripción del problema: La clasificación de gastos es una solución al problema de la desorganización monetaria la cual ayuda a clasificar los tipos de gastos y saber cuáles de ellos siguen pendientes, La falta de la organización monetaria afecta el destino de dinero destinado a ciertas actividades sin saber si los gastos principales ya han sido cubiertos, con la creación de este programa se organizará gasto a gasto por categoría con la cual se podrá enfatizar los gastos pendientes y los ya pagados

Tecnologías utilizadas:
-Java
-Spring boot
-Dependencias Spring web MVC, Spring Data JPA, jakarta validation.
-PostgreSQL
-Maven
-HTML, CSS Y JavaScript
-Postman
-GitHub

Estructura general del sistema.

├──.mvn/
├    ├──wrappeer
│       ├──maven-wrapper.properties
├──database/
├    ├──scrips.sql
├──Evidencias/
├    ├──Evidencias.docx
├──src/main/java/paquete-del-proyecto/
    ├── controller/
    │   └── CategoriaController.java
    │   └── GastoController.java
    ├── dto/
    │   └── CategoriaRequest.java
    │   └── CategoriaRequest.java
    │   └── GastoResponse.java
    │   └── EstadoRequest.java
    │   └── TotalCategoriaResponse.java
    │   └── ErrorResponse.java
    │   └── GasstoResponse.java
    ├── entity/
    │   └── Categoria.java
    │   └── EstadoGasto.java
    │   └── Gasto.java
    ├── exception/
    │   ├── RecursoNoEncontradoException.java
    │   └── ReglaNegocioException.java
    │   └── GlobalExceptionHandler.java
    ├── repository/
    │   └── CategoriaRepository.java
    │   └── GastoRespository.java
    └── service/
    │       └── CateogriaService.java
    │    └── GastoService.java
    └── ControlGastosPersonalesApplication
├──src/main/java/resources/
    ├── static/
    │   └── index.html
    ├── templates/
    ├── application.properties/
├──.gitattributes
├──.gitignore
├──mvnw.cmd
├──mvnw
├──HELP.md
├──pom.xml
├──README.md


Requisitos para ejecutar el proyecto. 

-Abrir y ejecutar el proyecto en IntelliJ.
-Tener PostgreSQL instalado y en ejecución.
-Tener pgAdmin activo para ejecutar el script database/gastos.sql.
-Conexión a internet para descargar las dependencias de Maven.
-Usar el link de la web para acceder a la parte visual http://localhost:8080/.
-Usar Postman para probar la API REST.
-Despues de la verification, ingresar datos desde la web.

Configuración de PostgreSQL.
spring.application.name=controlGastosPersonales

server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/control_gastos_personales
spring.datasource.username=postgres
spring.datasource.password= ${Password}

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

--La contraseña ha sido guardada en una variable de entorno para no exponerla en el repositorio.--

Instrucciones para iniciar el backend.

-Abrir la carpeta del proyecto ControlGastosPersonales.
-Confirmar que las dependencias de Maven esten sincronizadas
-Confirmar que PostgreSQL este en ejecución.
-Confirmar que la base de datos este conectada.
-Ejecutar la clase ControlGastosPersonalesApplication
-Confirmar que la clase corra sin ningun problema y abrir el navegador.

Instrucciones para abrir el frontend.

-Abrir la carpeta del proyecto ControlGastosPersonales.
-Confirmar que PostgreSQL este en ejecución.
-Ejecutar la clase ControlGastosPersonalesApplication.
-Confirmar que la clase corra sin ningun problema.
-Abrir el navegador en el link: http://localhost:8080/
-Confirmar la carga visual del proyecto para comenzar con la inyeccion de datos.

Descripción de los endpoints.

Categorías
Método	Endpoint	                    Descripción
GET	    /api/categorias                 Obtiene todas las categorías.
GET 	/api/categorias/{id}	        Obtiene una categoría por su identificador.
POST	/api/categorias	                Registra una categoría.
PUT	    /api/categorias/{id}	        Actualiza una categoría existente.
DELETE	/api/categorias/{id}	        Elimina una categoría si no tiene gastos asociados.

Gastos
Método	Endpoint	                                             Descripción
GET	    /api/gastos                                 	        Obtiene todos los gastos.
GET 	/api/gastos/id                                          Obtiene un gasto por su identificador.
POST	/api/gastos	                                            Registra un gasto asociado a una categoría existente.
PUT 	/api/gastos/id                                       	Actualiza los datos de un gasto.
DELETE	/api/gastos/id                                         	Elimina un gasto.
PATCH	/api/gastos/id/estado	                                Cambia el estado a PAGADO o PENDIENTE.
GET	    /api/gastos/categoria/categoriaId           	        Obtiene los gastos de una categoría.
GET	    /api/gastos/rango?inicio=2026-10-01&fin=2026-10-31	    Obtiene los gastos entre las fechas indicadas, incluyendo ambos días.
GET	    /api/gastos/pendientes	                                Obtiene únicamente los gastos en estado PENDIENTE.
GET	    /api/gastos/resumen-mensual?anio=2026&mes=10	        Obtiene el monto total y la cantidad de gastos por categoría del mes indicado. Incluye PAGADOS y PENDIENTES.

Reglas principales del negocio:
1. El monto debe ser mayor que cero y la fecha no puede estar vacía.
2. Permitir marcar un gasto como pagado o pendiente.
3. Calcular totales sin duplicar registros.