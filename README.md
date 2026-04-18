
# product-service

[![CI](https://github.com/kase2228/product-service/actions/workflows/ci.yml/badge.svg)](https://github.com/kase2228/product-service/actions/workflows/ci.yml)

A RESTful product microservice built with Spring Boot 3.

## Getting Started

```bash 
mvn spring-boot:run 
``` 

## Endpoints

| Method | Path             | Description            | 
|--------|------------------|------------------------| 
| GET    | /products        | List all products      | 
| GET    | /products/{id}   | Get product by ID      | 
| POST   | /products        | Create a new product   | 
| GET    | /health          | Service health check   | 