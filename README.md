# Prices Service

## Project Overview

Prices Service is a Spring Boot service for querying applicable product prices by application date, product, and brand.

## Technical Stack

- Java 21 LTS
- Spring Boot 3.5.x
- Maven
- Spring Web
- Spring Data JPA
- H2 in-memory database
- springdoc-openapi for Swagger UI
- Lombok
- JUnit 5 and MockMvc for testing

## Architecture

The project follows a simple hexagonal architecture:

- `domain`: business model and ports.
- `application`: application use cases.
- `infrastructure.persistence`: database adapters.
- `infrastructure.rest`: REST adapters.

## API Documentation

The REST API is defined in the OpenAPI contract at:

```text
src/main/resources/openapi/prices-api.yml
```

Swagger UI is available once the application is running at:

```text
/swagger-ui.html
```

Main endpoint:

```text
GET /api/v1/prices?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1
```

## How to Run

Run the application with:

```bash
mvn spring-boot:run
```

The H2 Console is available once the application is running at:

```text
/h2-console
```

## How to Test

Run the project tests with:

```bash
mvn clean test
```

## Database Initialization

The H2 database schema and sample data are initialized on startup from:

```text
src/main/resources/db/schema.sql
src/main/resources/db/data.sql
```

## Implementation Notes

The project uses Java 21 LTS, Spring Boot 3.5.x, Lombok, and a manually maintained OpenAPI contract.

Application logs are configured at INFO level for the service package. Hibernate SQL logging is disabled to keep runtime logs focused.

The application is configured to honor forwarded headers, so Swagger UI and generated links work correctly behind HTTPS proxies such as Railway.
