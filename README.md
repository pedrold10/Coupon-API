# Coupon API

API REST para gerenciamento de cupons de desconto, desenvolvida como parte de um desafio técnico.  
O projeto foi estruturado seguindo princípios de **Clean Architecture / Hexagonal Architecture**, com separação clara entre camadas de domínio, aplicação, infraestrutura e interface.

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- H2 Database (in-memory)  
- Maven  
- Docker e Docker Compose  
- JUnit 5  
- SpringDoc OpenAPI (Swagger)  

---

## 📐 Arquitetura do Projeto

O projeto foi estruturado com foco em boas práticas de design de software, separando responsabilidades por camadas.

com.coupon
├── controller # Camada de entrada (REST Controllers)

├── dto # DTOs de request/response

├── application

│ ├── usecase # Casos de uso (Application Layer)

│ ├── port # Interfaces (Ports)

│ └── config

├── domain

│ ├── model # Entidades e Value Objects

│ └── exception # Regras de negócio e exceções

├── infrastructure

│ └── persistence

│ ├── adapter # Adapters de persistência

│ ├── repository # Implementações JPA

│ └── mapper # Mapeamento Entity <-> Domain


### Princípios aplicados

- Separation of Concerns  
- SOLID  
- Domain-Driven Design (DDD básico)  
- Hexagonal Architecture (Ports & Adapters)  
- Value Objects para validação de regras de domínio  

---

## 🧩 Funcionalidades

- Criar cupom  
- Buscar cupom por código  
- Deletar cupom (soft delete)  
- Validações de domínio:
  - Código inválido  
  - Data de expiração inválida  
  - Valor de desconto inválido  
  - Cupom já deletado  

---

## 🧪 Testes

Testes unitários implementados para:

- Casos de uso  
- Value Objects  
- Regras de negócio  

Localização:

src/test/java/com/coupon

## 🐳 Executando com Docker

### Build da aplicação

```bash
docker build -t coupon-api
```
### Subir com Docker Compose
```
docker-compose up
```
### A aplicação ficará disponível em:
```
http://localhost:8080
```

##🧠 Banco de Dados (H2)

### Console H2 habilitado:

```
http://localhost:8080/h2-console
```

### Configuração:

- JDBC URL: jdbc:h2:mem:coupondb

- User: sa

- Password: (vazio)

## 📚 Swagger / OpenAPI

A documentação interativa pode ser acessada em:

```
http://localhost:8080/swagger-ui.html
```
ou
```
http://localhost:8080/v3/api-docs
```

## 📌 Endpoints Principais
Método	Endpoint	Descrição
POST	/coupons	Criar cupom
GET	/coupons/{code}	Buscar cupom
DELETE	/coupons/{code}	Deletar cupom

## ⚙️ Configurações

### Arquivo principal:

- application.yaml

### Exemplo:

spring:
  datasource:
    url: jdbc:h2:mem:coupondb
    driver-class-name: org.h2.Driver
    username: sa
    password: ""
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

## 💡 Decisões Técnicas

- Uso de Value Objects para garantir invariantes de domínio

- Separação entre Domain Model e Persistence Model com Mapper

- Use Cases isolados para garantir independência de framework

- Soft delete para manter histórico de cupons

- Testes unitários focados em regras de negócio

- Docker para facilitar execução local e avaliação

