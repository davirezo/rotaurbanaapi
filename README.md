# 🍕 Rota Urbana API

API REST desenvolvida em **Java + Spring Boot** para gerenciar o sistema da pizzaria **Rota Urbana**.

O objetivo do projeto é fornecer toda a camada de back-end para o site da pizzaria, permitindo o gerenciamento de produtos, pedidos, painel administrativo e futuras integrações com meios de pagamento.

---

## 🚀 Tecnologias

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Lombok
* Jakarta Validation

---

## 📋 Funcionalidades

### 👨‍🍳 Cliente

* Visualizar cardápio
* Consultar categorias
* Adicionar produtos ao carrinho
* Finalizar pedidos
* Informar nome, telefone e endereço
* Escolher entrega ou retirada
* Escolher forma de pagamento
* Consultar status do pedido (futuramente)

### 👨‍💼 Administrador

* Login administrativo *(em desenvolvimento)*
* Gerenciar produtos
* Gerenciar categorias
* Gerenciar promoções
* Visualizar pedidos
* Atualizar status dos pedidos
* Dashboard administrativo *(em desenvolvimento)*

---

## 📦 Estrutura do Projeto

```text
src
 ├── config
 ├── controller
 ├── dto
 ├── entity
 ├── exception
 ├── repository
 ├── service
 └── validation
```

O projeto segue a arquitetura em camadas:

* **Controller** → Recebe as requisições HTTP.
* **Service** → Contém as regras de negócio.
* **Repository** → Comunicação com o banco de dados.
* **Entity** → Modelagem das tabelas.
* **DTO** → Objetos utilizados para entrada e saída de dados.

---

## 🗄️ Banco de Dados

O projeto utiliza **PostgreSQL**.

Principais entidades:

* Category
* Product
* Order
* OrderItem
* Admin

---

## 📌 Endpoints (Planejados)

### Produtos

* `GET /api/products`
* `GET /api/products/{id}`
* `POST /api/products`
* `PUT /api/products/{id}`
* `DELETE /api/products/{id}`

### Categorias

* `GET /api/categories`
* `POST /api/categories`
* `PUT /api/categories/{id}`
* `DELETE /api/categories/{id}`

### Pedidos

* `POST /api/orders`
* `GET /api/orders`
* `GET /api/orders/{id}`
* `PUT /api/orders/{id}/status`

### Administração

* `POST /api/auth/login`
* `GET /api/admin/dashboard`

---

## 🛣️ Roadmap

* [ ] CRUD de Categorias
* [ ] CRUD de Produtos
* [ ] Carrinho de Compras
* [ ] Criação de Pedidos
* [ ] Painel Administrativo
* [ ] Login com Spring Security + JWT
* [ ] Integração com pagamento online
* [ ] Notificações em tempo real
* [ ] Deploy da API
* [ ] Documentação com Swagger

---

## 🎯 Objetivo

Este projeto está sendo desenvolvido como uma solução real para a pizzaria **Rota Urbana**, aplicando boas práticas de desenvolvimento com Spring Boot, arquitetura em camadas e APIs REST.

Além de atender às necessidades do negócio, o projeto também tem como objetivo consolidar conhecimentos em desenvolvimento back-end e servir como parte do portfólio profissional.

---

## 👨‍💻 Desenvolvedores

Projeto desenvolvido por:

* Davi De Aro Rezo Cardoso
---

## 📄 Licença

Este projeto está em desenvolvimento e possui uso privado até sua conclusão.
