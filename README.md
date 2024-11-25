# API Usuários

Uma API desenvolvida em Java com Spring Boot para gerenciar usuários, perfis e permissões. Este projeto utiliza JPA, PostgreSQL e está configurado para ser implantado com facilidade.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.4.0**
- **JPA / Hibernate**
- **PostgreSQL**
- **SpringDoc OpenAPI**
- **Maven**

## Endpoints

### Usuários
- `/usuarios` (POST, GET, PUT, DELETE)
- `/usuarios/{id}` (GET, PUT, DELETE)

### Perfis
- `/perfis` (POST, GET, PUT, DELETE)
- `/perfis/{id}` (GET, PUT, DELETE)

### Permissões
- `/permissoes` (POST, GET, PUT, DELETE)
- `/permissoes/{id}` (GET, PUT, DELETE)

### Autenticação
- `/auth/login` (POST)
- `/auth/logout` (POST)

## Configuração
1. Clone o repositório:
   ```bash
   git clone https://github.com/paulolima3350/apiUsuarios.git
