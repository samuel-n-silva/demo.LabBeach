# Api LabBeach

## Informações do projeto

### Requisitos da Aplicação 

- Cadastro de bairro - Verificando se já existe         --- Ok
- Listagem de bairro                                    --- Ok
- Exclusão de bairro                                    --- Ok
- Edição de bairro por identificador                    --- OK
- Cadastro de praia - Verificando se já existe          --- Ok
- Listagem de praias                                    --- Ok
- Edição de praias por identificador                    --- OK
- Exclusão de um praias por identificador               --- Ok 
- Listagem de praias conforme o status                  --- Ok
- Listagem de praias com acessibilidade                 --- Ok
- Documentação da Api                                   --- OK
- Listagens de praias por população no bairro

## Dependecias da Aplicação

- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Spring Doc
- Servlet
- Versão Spring Boot(3.0.2), Java 17

## Endpoints

| End-Points                               | Descrinção                                                         |
| -----------------------------------------| -------------------------------------------------------------------|
| `localhost:8080/api/bairros - POST`      | Cadastro de bairro - Verificando se já existe.                     |
| `localhost:8080/api/bairros - GET`       | Listagem de bairro                                                 |
| `localhost:8080/api/bairros/id - PUT`    | Atualização de bairro por identificado                             |
| `localhost:8080/api/bairros/id - DELETE` | Exclusão de bairro                                                 |
| `localhost:8080/api/praias - POST`       | Cadastro de praia - Verificando se já existe.                      |
| `localhost:8080/api/praias - GET`        | Listagem de praia                                                  |
| `localhost:8080/api/praias/id - PUT`     | Edição de bairro por identificador                                 |
| `localhost:8080/api/praias/id - DELETE`  | Exclusão de um praias por identificador                            |
| `localhost:8080/api/praias/status?status=propia - GET`  | Listagem de praias conforme o status                |
| `localhost:8080/api/praias/acessibilidade?acessibilidade=true - GET`  | Listagem de praias conforme o status  |

### Documentação da Api com Swagger

| End-Points                                  | Descrinção               |     
| --------------------------------------------|--------------------------|
|`localhost:8080/swagger-ui/index.html#`      | Swagger - Documentação.  |            