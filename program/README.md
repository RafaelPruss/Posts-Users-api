# Program (Spring Boot + MongoDB) ✅

**Descrição**

Projeto de exemplo em Spring Boot que expõe APIs REST para `User` e `Post` e utiliza **MongoDB** como banco de dados.

---

## 🔧 Pré-requisitos

- Java 17 (conforme `pom.xml`)
- Maven (ou use o wrapper `./mvnw` / `mvnw.cmd` incluído)
- MongoDB rodando (padrão: `mongodb://localhost:27017/produtos`)

> Você pode sobrescrever a URI do MongoDB via variável de ambiente `SPRING_DATA_MONGODB_URI` ou alterando `src/main/resources/application.yml`.

---

## ▶️ Como executar (desenvolvimento)

No Windows:

```powershell
# rodar com o wrapper (recomendado)
.\\mvnw.cmd spring-boot:run

# ou executar testes
.\\mvnw.cmd test
```

Ou com Maven instalado:

```bash
mvn spring-boot:run
```

---

## 📦 Build e execução do JAR

```bash
./mvnw.cmd clean package
java -jar target/program-0.0.1-SNAPSHOT.jar
```

---

## 🧭 Endpoints principais

- `GET /users` — lista todos os usuários
- `GET /users/{id}` — busca usuário por id
- `POST /users` — cria usuário (envia JSON)
- `PUT /users/{id}` — atualiza usuário
- `DELETE /users/{id}` — remove usuário
- `GET /users/{id}/posts` — posts de um usuário

- `GET /Posts` — lista todos os posts (observe a letra maiúscula `P`)
- `GET /Posts/{id}` — busca post por id
- `POST /Posts` — cria post
- `PUT /Posts/{id}` — atualiza post
- `DELETE /Posts/{id}` — remove post
- `GET /Posts/titlesearch?text={texto}` — busca posts por título (case-insensitive, usa regex)

**Exemplo:**

- `GET /Posts/titlesearch?text=Spring%20Boot` — busca posts cujo título contenha "Spring Boot"
- Exemplo via curl:

```bash
curl -G "http://localhost:8080/Posts/titlesearch" --data-urlencode "text=Spring Boot"
```

---

## ✅ Testes

Execute:

```powershell
.\mvnw.cmd test
```

---

## 📝 Observações & dicas

- O projeto usa Lombok em tempo de compilação — mantenha o plugin do seu IDE (opcional) para uma melhor experiência.
- Caso esteja usando Docker para o MongoDB, a URI padrão `mongodb://host.docker.internal:27017/produtos` pode ser útil dependendo do setup.
- O endpoint `GET /Posts/titlesearch` aceita o parâmetro de query `text` e decodifica automaticamente valores URL-encoded (via `SelfUrl.decodeParam`), então você pode passar espaços e caracteres especiais desde que estejam URL-encoded.

---

## 🤝 Contribuição

Sinta-se à vontade para abrir issues e pull requests. Adicione instruções de contribuição e de estilo conforme necessário.



