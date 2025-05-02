# 📘 StudentDBManagementSystem

This is a simple database management system in Java that performs CRUD operations on a student records table using JDBC (Java Database Connectivity).

### 🔍 Features

- ➕ **Add** new student records  
- 🧾 **Retrieve** individual or all student entries  
- 📝 **Update** existing student records  
- ❌ **Delete** student entries from the database  

### 📦 Technologies Used

- Java (OOP, JDBC)
- MySQL (or any relational DBMS using SQL)
- DAO (Data Access Object) design pattern

### 📁 Structure Overview

- `Student.java` — A plain Java object (POJO) representing the Student entity  
- `DAO.java` — A generic interface for all CRUD operations  
- `StudentDB.java` — JDBC implementation of DAO with database logic for `Student`  
 
### 📌 What I Learned

- How to connect Java applications to databases using JDBC  
- Writing SQL queries in Java and handling results  
- Applying interfaces and the DAO pattern to separate logic  

---

> ⚠️ Note: Ensure your database is configured with the correct table and credentials before running the app.
