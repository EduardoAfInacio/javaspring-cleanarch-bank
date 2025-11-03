# javaspring-cleanarch-bank

Projeto de exemplo/produção que implementa os princípios do backend de uma aplicação bancária em Java usando Spring Boot e Clean Architecture (arquitetura em camadas). O repositório está organizado em módulos Gradle para separar responsabilidades e facilitar testes e manutenção.

## Visão geral

- Aplicação modularizada com separação clara entre domínio, casos de uso, implementação de casos de uso e camada de infraestrutura (API, persistência, integração).
- Objetivo: demonstrar padrões de Clean Architecture aplicados a um domínio bancário (usuários, carteiras, transações, autenticação, validações).

## Módulos

- `core` — Entidades de domínio, tipos e exceções (camada mais interna).
- `usecase` — Interfaces e casos de uso (regras de negócio).
- `application` — Implementações dos gateways e adaptadores entre usecases e infraestrutura.
- `infrastructure` — Aplicação Spring Boot (controllers, repositórios, mapeadores, config, clients externos). Contém o ponto de execução `BankApplication.java` e arquivos de configuração (`application.yml`, `application-local.yml`).

## Tecnologias

- Java (versão definida no build.gradle)
- Spring Boot
- Gradle (multi-module)
- Possível uso de Flyway para migrations (arquivos SQL em `*/db/migration`)
- Testes com JUnit (configurado via Gradle)

## Requisitos

- JDK compatível (ver `build.gradle`)
- Gradle Wrapper (incluído) — em Windows use `gradlew.bat`
- Banco de dados configurado conforme `application.yml` (os scripts de migração estão em `infrastructure/src/main/resources/db/migration`)

## Como rodar (Windows)

1. Compilar todo o projeto:
   .\gradlew.bat build
2. Executar a aplicação (módulo de infraestrutura):
   .\gradlew.bat :infrastructure:bootRun

   Ou, após build, executar o JAR:
   java -jar infrastructure\build\libs\*.jar --spring.profiles.active=local
3. Executar testes:
   .\gradlew.bat test

Observação: use a propriedade `--spring.profiles.active=local` para carregar `application-local.yml` quando necessário.

## Banco de dados e migrations

- Scripts de criação/tabelas em: `infrastructure/src/main/resources/db/migration` (nomes V001...).
- A configuração de migrações e datasource está em `infrastructure/src/main/resources/application*.yml`.
- Ajuste as credenciais/URL do banco antes de rodar em ambiente local.

## Estrutura do código

- `io.github.eduardoafinacio.core` — domínio e exceções.
- `io.github.eduardoafinacio.usecase` — casos de uso (interfaces).
- `io.github.eduardoafinacio.application` — gateways e implementações de casos de uso.
- `io.github.eduardoafinacio.infrastructure` — controllers REST, repositórios, mapeadores, config e o bootstrap Spring Boot.

## Convenções

- Segue princípios da Clean Architecture: dependências apontam para dentro (infra -> application -> usecase -> core).
- Nomes e pacotes padronizados conforme domínio.
