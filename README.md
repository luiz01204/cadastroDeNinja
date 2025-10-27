
# API Cadastro De Ninja 🥷

![Licença](https://img.shields.io/badge/licen%C3%A7a-MIT-blue.svg)
![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x.x-green.svg)

Uma API REST simples para cadastro de ninjas, desenvolvida durante o curso Batismo de Java. Basicamente, um CRUD para gerenciar seus shinobis!

## ✨ Funcionalidades

* [ ] Criar Ninjas (POST)
* [ ] Listar Ninjas (GET)
* [ ] Buscar Ninja por ID (GET)
* [ ] Atualizar Ninja (PUT)
* [ ] Deletar Ninja (DELETE)
*(Marque o que já está feito!)*

## 🛠️ Stack Utilizada

Essa API foi construída com as seguintes tecnologias:

* **Java 17** (Ou a versão que você usou)
* **Spring Boot**: Framework principal para criar a API.
* **Spring Data JPA**: Para facilitar a comunicação com o banco de dados.
* **Lombok**: Para reduzir o *boilerplate* (adeus, getters e setters!).
* **H2 Database**: Banco de dados em memória/arquivo, ótimo para desenvolvimento.
* **FlywayDB**: Para fazer o versionamento (migrations) do banco de dados.
* **Maven**: Gerenciador de dependências e build.

## 🚀 Como Rodar o Projeto

Siga os passos abaixo para rodar o projeto na sua máquina.

1.  **Clone o repositório**
    ```bash
    git clone [https://github.com/luiz01204/NOME-DO-SEU-REPO.git](https://github.com/luiz01204/NOME-DO-SEU-REPO.git)
    ```

2.  **Entre na pasta do projeto**
    ```bash
    cd NOME-DO-SEU-REPO
    ```

3.  **Execute o projeto**
    Você pode rodar pela sua IDE (IntelliJ, VSCode, etc.) ou direto pelo terminal usando o Maven Wrapper:
    ```bash
    ./mvnw spring-boot:run
    ```

A API estará disponível em `http://localhost:8080`.

## 🗄️ Configuração do Banco (H2 em Arquivo)

Para que o H2 salve os dados em um arquivo (em vez de perder tudo quando a API reinicia), seu arquivo `src/main/resources/application.properties` deve estar configurado assim:

```properties
# --- Configuração do H2 para salvar em arquivo ---
# Isso cria um arquivo 'ninjadb' na pasta 'data' na raiz do projeto
spring.datasource.url=jdbc:h2:file:./data/ninjadb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

# --- Habilitar o Console do H2 ---
# Acesse em: http://localhost:8080/h2-console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# --- JPA e Flyway ---
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
# Deixamos 'none' porque o Flyway vai cuidar de criar/alterar as tabelas!
spring.jpa.hibernate.ddl-auto=none

# --- Configuração do Flyway ---
# O Flyway vai procurar os scripts SQL em 'src/main/resources/db/migration'
spring.flyway.locations=classpath:db/migration

```

## Autores

- [@luiz01204](https://www.github.com/luiz01204)


## Licença

[MIT](https://choosealicense.com/licenses/mit/)

