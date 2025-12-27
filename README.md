# 📘 Posts-Users-api — API REST (Spring Boot + MongoDB)

## 🔧 Descrição
**Posts-Users-api** é uma API REST em **Spring Boot** que gerencia **Users** e **Posts**, armazenando dados em **MongoDB**. Projeto de exemplo com endpoints para CRUD e busca por título.

---

## 🚀 Tecnologias
- Java 17
- Spring Boot 3.x
- Spring Data MongoDB
- Maven (usar `mvnw.cmd` no Windows)
- Lombok (verificar se está habilitado no IDE)

---

## ⚙️ Pré-requisitos
- JDK 17 instalado
- MongoDB rodando em `mongodb://localhost:27017/produtos` (padrão do projeto)

Dica (Docker):
```bash
docker run -d -p 27017:27017 --name mongo -e MONGO_INITDB_DATABASE=produtos mongo:6.0
```

---

## ▶️ Como executar (Windows)
1. Build:
```powershell
mvnw.cmd clean package
```
2. Rodar com Spring Boot:
```powershell
mvnw.cmd spring-boot:run
```
Ou executar o jar:
```powershell
java -jar target\program-0.0.1-SNAPSHOT.jar
```

Executar testes:
```powershell
mvnw.cmd test
```

---

## 🔎 Endpoints principais
> Observação: o endpoint de Posts usa `"/Posts"` (P maiúsculo) — atenção à sensibilidade de maiúsculas.

- **Users**
  - `GET /users` — listar todos os usuários
  - `GET /users/{id}` — obter usuário por id
  - `POST /users` — criar usuário
  - `PUT /users/{id}` — atualizar usuário
  - `DELETE /users/{id}` — apagar usuário
  - `GET /users/{id}/posts` — listar posts do usuário

- **Posts**
  - `GET /Posts` — listar todos os posts
  - `GET /Posts/{id}` — obter post por id
  - `POST /Posts` — criar post
  - `PUT /Posts/{id}` — atualizar post
  - `DELETE /Posts/{id}` — apagar post
  - `GET /Posts/titlesearch?text=TERMO` — buscar posts por título (query param `text`)

---

## 🧩 Exemplos de requisições (curl)

Criar usuário:
```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"João","email":"joao@example.com"}'
```

Criar post:
```bash
curl -X POST http://localhost:8080/Posts \
  -H "Content-Type: application/json" \
  -d '{
    "date":"2025-12-27T00:00:00Z",
    "title":"Meu post",
    "body":"Conteúdo do post",
    "author":{"id":"<userId>","name":"João","email":"joao@example.com"}
  }'
```

Buscar por título:
```bash
curl "http://localhost:8080/Posts/titlesearch?text=meu%20post"
```

---

## 📝 Modelo de dados (resumo)
- **User**: `{ "id", "name", "email", "posts" }`
- **Post**: `{ "id", "date", "title", "body", "author", "commentDTOs" }`

`AuthorDTO` inclui `{ "id", "name", "email" }`.

---

## ⚠️ Notas importantes
- MongoDB URI: definido em `src/main/resources/application.yml` → `spring.data.mongodb.uri = mongodb://localhost:27017/produtos`
- Verifique se o Lombok está habilitado no IDE (annotation processing).
- Rotas são case-sensitive (`/Posts` com P maiúsculo).

---

## 📄 Contribuição
- Abra issues e PRs.
- Mantenha testes atualizados.

---

## 🏷️ Licença
MIT (adicione o arquivo de licença adequado se desejar)
