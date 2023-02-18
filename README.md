# Api LabBeach

## Informações do projeto

### Requisitos da Aplicação 

- Cadastro de bairro - Verificando se já existe  --- Ok
- Listagem de bairro  --- Ok
- Exclusão de bairro --- Ok
- Edição de bairro por identificador --- OK
- Cadastro de praia - Verificando se já existe  --- Ok
- Listagem de praias --- Ok
- Edição de praias por identificador --- OK
- Exclusão de um praias por identificador --- Ok
- Listagem de praias conforme o status --- Ok
- Listagem de praias com acessibilidade --- Ok
- Listagens de praias por população no bairro

## Dependecias da Aplicação

- Spring Web
- Spring Data JPA
- PostgreSQL Driver

- Versão Spring Boot(3.0.2), Java 17

## Endpoints

- localhost:8080/api/bairros - GET
- localhost:8080/api/bairros - POST
- localhost:8080/api/bairros/id - PUT
- localhost:8080/api/bairros/id - DELETE

- localhost:8080/api/praias - GET 

- localhost:8080/api/praias/status?status=propia - GET
- localhost:8080/api/praias/acessibilidade?acessibilidade=true - GET

- localhost:8080/api/praias - POST
- localhost:8080/api/praias/id - DELETE