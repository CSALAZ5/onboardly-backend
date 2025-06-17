# 🚀 Onboardly Backend

Backend de **Onboardly**, una aplicación diseñada para gestionar el proceso de onboarding técnico de nuevos colaboradores. Esta API REST está desarrollada con **Java 17** usando **Spring Boot** y desplegada en **AWS Elastic Beanstalk**.

---

## 📦 Tecnologías utilizadas

* ✅ Java 17
* ✅ Spring Boot 3
* ✅ Spring Web + Spring Data JPA
* ✅ Maven
* ✅ MySQL (Base de datos)
* ✅ AWS Elastic Beanstalk (Despliegue)
* ✅ GitHub Actions (propuesto para CI/CD)
* ✅ CORS y configuración de seguridad básica

---

## 📁 Estructura del proyecto

```
src/
├── main/
│   ├── java/com/onboardly/
│   │   ├── config         # Configuraciones de CORS y SWAGGER
|   |   ├── controller     # Controladores REST
|   |   ├── dto            # Objetos DTO
│   │   ├── model          # Entidades JPA
│   │   ├── repository     # Interfaces para acceso a datos
│   │   └── service        # Lógica de negocio
│   └── resources/
│       ├── application.properties  # Configuración general
│       └── ...
└── test/                  # Pruebas unitarias y de integración
```

---

## ⚙️ Configuración local

### 1. Clonar el repositorio

```bash
git clone https://github.com/CSALAZ5/Onboardly-back.git
cd Onboardly-back
```

### 2. Configurar la base de datos

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/onboardly
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 3. Ejecutar el proyecto

```bash
./mvnw spring-boot:run
```

---

## 🌐 Endpoints principales

| Método | Endpoint                | Descripción                 |
| ------ | ----------------------- | --------------------------- |
| GET    | /api/colaboradores      | Listado de colaboradores    |
| POST   | /api/colaboradores      | Crear colaborador           |
| PUT    | /api/colaboradores/{id} | Actualizar colaborador      |
| DELETE | /api/colaboradores/{id} | Eliminar colaborador        |
| GET    | /api/calendario            | Listado de eventos técnicos |
| POST   | /api/calendario            | Crear nuevo evento          |
| DELETE | /api/calendario/{id}       | Eliminar evento             |

---

## ℹ️ Información adicional

Este proyecto es de carácter **personal** y fue desarrollado como solución a un **reto técnico individual**. No representa un producto comercial ni está destinado para uso en producción real.

El despliegue se realizó en **AWS Elastic Beanstalk** utilizando un paquete `.jar` generado localmente con Maven, el cual fue cargado en un entorno de AWS Beanstalk para su ejecución.

---

## 🔒 Notas sobre seguridad

* CORS configurado para permitir llamadas desde el frontend en CloudFront.
* La aplicación está expuesta por HTTPS en Elastic Beanstalk mediante el dominio temporal `.elasticbeanstalk.com`.

---

## 🧑‍💻 Autor

Desarrollado por [Christian Salazar](https://github.com/CSALAZ5)

---
