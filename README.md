# JDBC-Proj

A Java-based JDBC project demonstrating **database connectivity, CRUD operations, and transaction management** using **MySQL** and **PostgreSQL**.

## 🚀 Features

* Java Database Connectivity using JDBC
* MySQL database integration
* PostgreSQL database integration
* CRUD operations

  * Create
  * Read
  * Update
  * Delete
* Database transaction management
* Commit and Rollback
* Auto-commit configuration
* PreparedStatement for parameterized queries
* Exception handling
* Transaction consistency and failure handling

## 🛠️ Technologies Used

* **Java**
* **JDBC (Java Database Connectivity)**
* **MySQL**
* **PostgreSQL**
* **IntelliJ IDEA**
* **Git & GitHub**

## 🔌 Database Connectivity

The project demonstrates connectivity with both MySQL and PostgreSQL.

### MySQL

```text
Java Application
       ↓
      JDBC
       ↓
     MySQL
```

### PostgreSQL

```text
Java Application
       ↓
      JDBC
       ↓
   PostgreSQL
```

## 🔄 CRUD Operations

The project implements the basic database operations:

| Operation | Description               |
| --------- | ------------------------- |
| CREATE    | Insert new records        |
| READ      | Retrieve existing records |
| UPDATE    | Modify existing records   |
| DELETE    | Delete records            |

## 💳 Transaction Management

The project also demonstrates **JDBC transaction management** to ensure that multiple database operations are treated as a single logical unit.

### Transaction Flow

```text
Start Transaction
       ↓
   Operation 1
       ↓
   Operation 2
       ↓
   Operation 3
       ↓
  All Successful?
     ↙       ↘
   YES        NO
    ↓          ↓
 COMMIT      ROLLBACK
```

### Important JDBC Transaction Methods

```java
connection.setAutoCommit(false);

try {
    // Database operations

    connection.commit();
} catch (Exception e) {
    connection.rollback();
}
```

### Transaction Properties

* **Auto Commit** – Controls whether each SQL statement is committed automatically.
* **Commit** – Permanently saves the successful transaction.
* **Rollback** – Reverts the changes when an error occurs.
* **Transaction Boundary** – Defines the beginning and end of a transaction.

## 🔐 Why Transactions?

Transactions help maintain **data consistency** when multiple database operations depend on each other.

For example:

```text
Account A
   ↓
Debit ₹1000
   ↓
Account B
   ↓
Credit ₹1000
```

If the debit succeeds but the credit fails, the transaction can be rolled back so that the database does not remain in an inconsistent state.

## ⚙️ Setup

### 1. Clone the Repository

```bash
git clone <your-repository-url>
cd JDBC-Proj
```

### 2. Configure Database

Configure the required database connection:

```text
Database URL
Username
Password
```

The project can be configured to work with **MySQL** or **PostgreSQL**.

### 3. Add JDBC Drivers

Add the appropriate JDBC drivers for MySQL and PostgreSQL to the project dependencies.

### 4. Run the Project

Open the project in **IntelliJ IDEA**, configure the database credentials, and run the application.

## 🔒 Security

Do not commit real database credentials to GitHub.

Use environment variables or a local configuration file for sensitive information and add it to `.gitignore`.

## 🎯 Learning Objectives

This project helped in understanding:

* JDBC architecture
* Database connectivity
* SQL execution using Java
* CRUD operations
* PreparedStatement
* Transaction management
* Commit and Rollback
* Auto-commit
* Exception handling
* MySQL and PostgreSQL integration
* Maintaining database consistency

## 👨‍💻 Author

**Ravi Ranjan**

---

⭐ If you find this project useful, consider giving it a star!
