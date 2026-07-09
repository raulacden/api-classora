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

The project uses Java 21 LTS, Spring Boot 3.5.x, and a manually maintained OpenAPI contract.
