# Banking Application 

A **RESTful Banking Application** built using **Spring Boot 3**, **Spring Data JPA (Hibernate)**, and **MySQL**.

---

## 📌 Features

* Create bank accounts
* Fetch account details
* Deposit money into an account
* Withdraw money from an account
* Delete bank accounts
* RESTful API design
* Exception handling
* Layered architecture (Controller, Service, Repository)

---

## 🛠️ Tech Stack

| Technology      | Description                   |
| --------------- | ----------------------------- |
| Java 17         | Programming language          |
| Spring Boot 3   | Backend framework             |
| Spring Data JPA | ORM & database abstraction    |
| Hibernate       | JPA implementation            |
| MySQL           | Relational database           |
| Maven           | Build & dependency management |
| Postman         | API testing                   |
| Lombok          | Reduces boilerplate code      |

---

## 📂 Project Structure

```
banking-app
 └── src/main/java/com/bankname/bankingapp
     ├── controller
     │   └── AccountController.java
     ├── dto
     │   └── AccountDto.java
     ├── entity
     │   └── Account.java
     ├── repository
     │   └── AccountRepository.java
     ├── service
     │   ├── AccountService.java
     │   └── impl/AccountServiceImpl.java
     ├── exception
     │   └── ResourceNotFoundException.java
     └── BankingappApplication.java

 └── src/main/resources
     ├── application.properties
```

---

## 🧱 Application Architecture (High Level)

The application follows a **layered architecture**:

1. **Controller Layer**

   * Handles HTTP requests & responses
   * Exposes REST endpoints

2. **Service Layer**

   * Contains business logic
   * Acts as a bridge between Controller and Repository

3. **Repository Layer**

   * Interacts with the database
   * Uses Spring Data JPA

4. **Entity Layer**

   * Represents database tables

5. **DTO Layer**

   * Used for transferring data between layers

---

## 🗄️ Database Design

### Account Table

| Column            | Type    | Description         |
| ----------------- | ------- | ------------------- |
| id                | BIGINT  | Primary key         |
| accountHolderName | VARCHAR | Account holder name |
| balance           | DOUBLE  | Account balance     |

## 🚀 REST API Endpoints

### 1️⃣ Create Account

**POST** `/api/accounts`

```json
{
  "accountHolderName": "Anuj",
  "balance": 5000
}
```

---

### 2️⃣ Get Account By ID

**GET** `/api/accounts/{id}`

---

### 3️⃣ Deposit Amount

**PUT** `/api/accounts/{id}/deposit`

```json
{
  "amount": 1000
}
```

---

### 4️⃣ Withdraw Amount

**PUT** `/api/accounts/{id}/withdraw`

```json
{
  "amount": 500
}
```

---

### 5️⃣ Delete Account

**DELETE** `/api/accounts/{id}`

---

## ❗ Exception Handling

* Handles account not found scenarios
* Prevents withdrawing more than available balance
* Uses custom exceptions like:

```java
ResourceNotFoundException
```

---

## 🧪 Testing APIs

You can test all APIs using **Postman**:

1. Start the Spring Boot application
2. Use `http://localhost:8080`
3. Send requests to the respective endpoints

---

## 🎯 Key Learnings

* Building REST APIs using Spring Boot 3
* Using Spring Data JPA with Hibernate
* Connecting Spring Boot with MySQL
* Implementing CRUD operations
* Clean code & layered architecture
* Exception handling best practices


## 📌 Future Enhancements

* Add authentication & authorization (JWT + Spring Security)
* Transaction history
* Validation using Spring Validation
* Pagination & sorting

---

## 👨‍💻 Author

**Hitakshi Ajmera**

