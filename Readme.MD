# 🛒 Bamboo API - Java Spring Boot

Este projeto é uma API REST desenvolvida em **Java com Spring Boot**, que simula um sistema de gerenciamento de produtos para supermercados.

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Lombok
- JUnit e Mockito (Testes)
- Maven
- Git

---

## ✅ Pré-requisitos

Antes de rodar o projeto, você precisará ter instalado na sua máquina:

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [PostgreSQL](https://www.postgresql.org/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

---

## ⚙️ Configuração do banco de dados

1. Crie um banco no PostgreSQL com o nome desejado, ex:

CREATE DATABASE bamboo;

2. Altere o arquivo application.properties em:
    - src/main/resources/application.properties

Exemplo de configuração:

spring.datasource.url=jdbc:postgresql://localhost:5432/bamboo  </br>
spring.datasource.username=seu_usuario </br>
spring.datasource.password=sua_senha </br>

spring.jpa.hibernate.ddl-auto=update </br>
spring.jpa.show-sql=true </br>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect </br>

1. Clone o repositório
   git clone https://github.com/EduardoBorges0/Bamboo_API
   cd seu-repositorio

2. Compile e rode a aplicação com Maven
   mvn spring-boot:run

Ou, para compilar e gerar o .jar:
mvn clean install
java -jar target/seu-arquivo.jar

📫 Endpoints principais </br>
Após iniciar, a API estará disponível em: </br>

http://localhost:8080

🧪 Testes </br>
Para rodar os testes: </br>
mvn test

📌 Observações </br>
Use ferramentas como Postman ou Insomnia para testar os endpoints. </br>
A API segue os princípios RESTful. </br>

👨‍💻 Autor  </br>
Desenvolvido por Eduardo Borges </br>
🔗 LinkedIn: https://www.linkedin.com/in/eduardoo-borges/
