# javaspring-cleanarch-bank

Example/production project that implements banking application backend principles using Java with Spring Boot and Clean Architecture (layered architecture). The repository is organized in Gradle modules to separate responsibilities and facilitate testing and maintenance.

## Overview

- Modularized application with clear separation between domain, use cases, use case implementation and infrastructure layer (API, persistence, integration).
- Goal: demonstrate Clean Architecture patterns applied to a banking domain (users, wallets, transactions, authentication, validations).

## Modules

- `core` — Domain entities, types and exceptions (innermost layer).
- `usecase` — Interfaces and use cases (business rules).
- `application` — Gateway implementations and adapters between usecases and infrastructure.
- `infrastructure` — Spring Boot application (controllers, repositories, mappers, config, external clients). Contains the execution point `BankApplication.java` and configuration files (`application.yml`, `application-local.yml`).

## Technologies

- Java (version defined in build.gradle)
- Spring Boot
- Gradle (multi-module)
- Possible use of Flyway for migrations (SQL files in `*/db/migration`)
- Tests with JUnit (configured via Gradle)

## Requirements

- Compatible JDK (see `build.gradle`)
- Gradle Wrapper (included) — on Windows use `gradlew.bat`
- Database configured according to `application.yml` (migration scripts are in `infrastructure/src/main/resources/db/migration`)

## How to run (Windows)

1. Build the entire project:
   .\gradlew.bat build
2. Run the application (infrastructure module):
   .\gradlew.bat :infrastructure:bootRun

   Or, after build, run the JAR:
   java -jar infrastructure\build\libs\*.jar --spring.profiles.active=local
3. Run tests:
   .\gradlew.bat test

Note: use the `--spring.profiles.active=local` property to load `application-local.yml` when needed.

## Database and migrations

- Creation/table scripts in: `infrastructure/src/main/resources/db/migration` (names V001...).
- Migration and datasource configuration is in `infrastructure/src/main/resources/application*.yml`.
- Adjust database credentials/URL before running in local environment.

## Code structure

- `io.github.eduardoafinacio.core` — domain and exceptions.
- `io.github.eduardoafinacio.usecase` — use cases (interfaces).
- `io.github.eduardoafinacio.application` — gateways and use case implementations.
- `io.github.eduardoafinacio.infrastructure` — REST controllers, repositories, mappers, config and Spring Boot bootstrap.

## Conventions

- Follows Clean Architecture principles: dependencies point inward (infra -> application -> usecase -> core).
- Standardized names and packages according to domain.-
