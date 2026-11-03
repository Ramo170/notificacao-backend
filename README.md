# 🔔 Sistema de Notificações — Back-end

API REST em **Java 21** com **Spring Boot** para envio de notificações por **E-mail**, **SMS** ou **WhatsApp**. O tipo de notificação é escolhido em tempo de execução com o padrão de projeto **Factory**, e todas as implementações seguem a mesma interface `Notificacao`.

O envio de e-mail é real, feito via **SMTP do Gmail** com o **Spring Mail**.

🔗 **Front-end:** [notifica-o-front](https://github.com/Ramo170/notifica-o-front) · [Demo](https://notificacao-front-seven.vercel.app)

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4** (Spring Web MVC)
- **Spring Boot Starter Mail** (JavaMailSender)
- **Maven**
- **Docker**

---

## 🧱 Arquitetura

```text
src/main/java/br/com/senai/sistema_notificacoes/
├── cotroller/     # NotificacaoController (endpoint REST)
├── factory/       # NotificacaoFactory: cria a implementação certa a partir do tipo
├── interfaces/    # Interface Notificacao
├── model/         # NotificacaoRequest e NotificacaoResponse
└── service/       # EmailService, SmsService e WhatsappService
```

### Padrões aplicados
- **Factory:** a `NotificacaoFactory` recebe o tipo (`EMAIL`, `SMS` ou `WHATSAPP`) e devolve a implementação correspondente.
- **Polimorfismo / Interface:** o controller trabalha apenas com a interface `Notificacao`, sem conhecer a implementação concreta.

> O envio por **SMS** e **WhatsApp** é simulado (retorna uma mensagem de confirmação). O envio por **e-mail** é real.

---

## 🔌 Endpoint

### `POST /notificacoes`

**Corpo da requisição:**
```json
{
  "tipo": "EMAIL",
  "destinatario": "cliente@email.com",
  "mensagem": "Seu pedido foi enviado!"
}
```

Valores aceitos para `tipo`: `EMAIL`, `SMS`, `WHATSAPP`.

**Resposta:**
```json
{
  "status": "Email enviado com sucesso para cliente@email.com"
}
```

---

## ▶️ Como Executar

### Pré-requisitos
- Java 21
- Uma conta Gmail com **senha de app** (necessária para o envio via SMTP)

### Variáveis de ambiente

| Variável | Descrição |
|---|---|
| `MAIL_USER` | E-mail do Gmail usado para enviar as mensagens |
| `MAIL_PASSWORD` | Senha de app do Gmail |

### Rodando localmente
```bash
git clone https://github.com/Ramo170/notificacao-backend.git
cd notificacao-backend
./mvnw spring-boot:run
```
A API ficará disponível em `http://localhost:8080`.

### Rodando com Docker
```bash
docker build -t notificacao-backend .
docker run -p 8080:8080 -e MAIL_USER=seu@gmail.com -e MAIL_PASSWORD=sua_senha_de_app notificacao-backend
```

---

## 👤 Autor

**Ícaro Bihum** — [GitHub](https://github.com/Ramo170) · [LinkedIn](https://www.linkedin.com/in/%C3%ADcaro-bihum-9b9b62381/)
