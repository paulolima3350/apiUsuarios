# API Usuários

Uma API desenvolvida em Java com Spring Boot para gerenciar usuários e suas permissões. Este projeto utiliza JPA, PostgreSQL e está configurado para ser implantado com facilidade.

## Funcionalidades

- Gerenciamento de usuários:
  - Criação, leitura, atualização e exclusão (CRUD).
- Sistema de autenticação com tokens JWT.
- Gerenciamento de perfis e permissões:
  - Perfis como `Administrador` e `Operador`.
  - Permissões específicas para ações como `Cadastrar`, `Consultar`, `Editar` e `Excluir`.
- Documentação da API com OpenAPI (Swagger).

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.1**
- **JPA (Hibernate)**
- **PostgreSQL**
- **SpringDoc OpenAPI**
- **Lombok**

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Git](https://git-scm.com/)

## Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL com o nome `api_usuarios`.
2. Configure as credenciais no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/api_usuarios
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
