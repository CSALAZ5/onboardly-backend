Quiero que generes un proyecto completo en Java con Spring Boot 3.x y Java 17, siguiendo arquitectura MVC. El objetivo es desarrollar el backend de una aplicación de gestión de onboardings llamada "Onboardly".

Lenguaje: Java 17
Framework: Spring Boot 3.x
Arquitectura: MVC (Model - View - Controller)
Base de datos: MySQL o H2 (configurable)
ORM: Spring Data JPA
Validaciones: Bean Validation (javax.validation)
Controladores REST (@RestController)
API base path: /api
Generar DTOs para entrada/salida de datos
Incluir configuración de CORS habilitado para Angular frontend
com.onboardly ├── controller ├── dto ├── model ├── repository ├── service └── config

id: Long, PK, auto-incremental
nombreCompleto: String (100), obligatorio
correo: String (100), obligatorio, único
fechaIngreso: LocalDate
onboardingBienvenida: boolean (default false)
onboardingTecnico: boolean (default false)
eventoTecnico: EventoOnboardingTecnico (relación ManyToOne, nullable)
id: Long, PK
nombre: String (100)
fechaInicio: LocalDate
fechaFin: LocalDate
id: Long, PK
colaborador: Colaborador (ManyToOne)
tipo: String (solo valores “bienvenida” o “tecnico”)
fechaCompletado: LocalDate
Un Colaborador puede estar asignado a un EventoOnboardingTecnico
Un Colaborador puede tener múltiples registros en HistorialOnboarding
Relación: Colaborador (N) → (1) EventoOnboardingTecnico
Relación: HistorialOnboarding (N) → (1) Colaborador
GET / → Listar todos los colaboradores
GET /{id} → Obtener un colaborador por ID
POST / → Crear un nuevo colaborador
PUT /{id} → Editar colaborador existente
DELETE /{id} → Eliminar colaborador
PATCH /{id}/completar → Marcar onboarding como completado (recibe body con campo tipo: 'bienvenida' o 'tecnico')
GET / → Listar todos los eventos técnicos del calendario
POST / → Crear un nuevo evento técnico (opcional si se precargan desde SQL)
GET /verificar → Verifica si algún onboarding técnico está a 7 días y muestra alerta simulada por consola
Validar correos con @Email, campos obligatorios con @NotBlank
Usar DTOs y mapeos entre entidades con ModelMapper o manual
Agregar manejo de errores central con @ControllerAdvice
Agregar configuración de CORS abierta para http://localhost:4200 (frontend Angular)
Agregar documentación con Swagger/OpenAPI
Agregar logs con SLF4J
Por favor genera el proyecto listo para compilar, correr con ./mvnw spring-boot:run, y exponer la API en http://localhost:8080/api.