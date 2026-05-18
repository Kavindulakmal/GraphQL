# 🛒 Product Inventory API

A **Spring Boot** REST/GraphQL API backed by **MySQL**, providing product inventory management with support for querying and updating stock via GraphQL.

---

## 🧰 Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java · Spring Boot |
| API | GraphQL (`/graphql`) |
| Database | MySQL |
| ORM | Spring Data JPA / Hibernate |

---

## 🚀 Getting Started

### Prerequisites

- Java 21+
- Maven 
- MySQL 8+

### 1. Clone the repository

```bash
git clone https://github.com/Kavindulakmal/GraphQL.git
cd your-repo-name
```

### 2. Configure the database

Create a MySQL database and update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

The GraphQL endpoint will be available at:

```
http://localhost:8080/graphql
```

> You can use the **GraphiQL** playground (if enabled) at `http://localhost:8080/graphiql`

---

## 📡 GraphQL API

### Queries

#### `getProductsByCategory`

Fetch all products in a given category.

```graphql
query GetProductsByCategory {
    getProductsByCategory(category: "Electronics") {
        name
        price
    }
}
```

**Response:**

```json
{
    "data": {
        "getProductsByCategory": [
            { "name": "Laptop", "price": 1000 },
            { "name": "Smartphone", "price": 500 }
        ]
    }
}
```

---

### Mutations

#### `receiveNewShipment`

Update the stock of a product when a new shipment arrives.

```graphql
mutation ReceiveNewShipment {
    receiveNewShipment(id: "4", quantity: 850) {
        name
        category
        price
        stock
    }
}
```

**Response:**

```json
{
    "data": {
        "receiveNewShipment": {
            "name": "Chair",
            "category": "Furniture",
            "price": 100,
            "stock": 865
        }
    }
}
```

---

## 🗄️ Database Schema

The core `product` table structure:

```sql
CREATE TABLE product (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    category    VARCHAR(255),
    price       DECIMAL(10, 2),
    stock       INT
);
```

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/
    │   └── com/graphql.inventory/
    │       ├── controller/       # GraphQL resolvers
    │       ├── model/            # JPA entities
    │       ├── repository/       # Spring Data repositories
    │       └── service/          # Business logic
    └── resources/
        ├── graphql/
        │   └── schema.graphqls   # GraphQL schema definition
        └── application.properties
```

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

# Contributing
Pull requests are welcomed. For major changes, please open an issue first to discuss what you would like to change. Thanks!

Happy Coding!!!

## Copyright
© KAVINDU™ 2026
