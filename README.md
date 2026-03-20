# Project Setup & Evaluation Guide: Personal Expense Tracker

This document provides the necessary instructions to configure, run, and evaluate the Personal Expense Tracker application. 

### 1. System Prerequisites
To run this project locally, ensure the following environments are installed on your machine:
* **Java Development Kit (JDK):** Version 21 (Required for modern Spring Boot and `ProcessBuilder` execution).
* **Database:** PostgreSQL (Version 14 or higher recommended).
* **Build Tool:** Apache Maven (The project includes a Maven Wrapper, so a local Maven installation is optional).

### 2. Database Configuration
The application utilizes Hibernate for automatic schema generation, but an empty database must be created prior to execution.
1. Open your PostgreSQL interface (e.g., pgAdmin or psql CLI).
2. Create a new, empty database named exactly: `expense_db`
3. Navigate to the project source code and open the `src/main/resources/application.properties` file.
4. Update the `spring.datasource.password` value to match your local PostgreSQL `postgres` user password.

### 3. Application Execution
This project is built as a monolithic full-stack application. The frontend (HTML/JS) is served directly by the Spring Boot embedded Tomcat server, requiring no separate Node.js or frontend server startup.

1. Open a terminal and navigate to the root directory of the extracted project folder (where the `pom.xml` is located).
2. Execute the application using the Maven Wrapper:
   * **Windows:** `.\mvnw spring-boot:run`
   * **Mac/Linux:** `./mvnw spring-boot:run`
3. The server will initialize on port `8080` (or `8081` if configured otherwise).

### 4. Evaluation Notes & Features
To streamline the evaluation process, the following quality-of-life features have been implemented:

* **Automated Data Seeding:** Upon a successful startup, Hibernate will generate the required tables. Immediately following this, a `data.sql` script will execute, utilizing idempotent `INSERT` operations to populate the database with three sample expense records. You will not need to manually input data to test the read operations.
* **Auto-Launch Interface:** The main `ExpenseTrackerApplication.java` class contains an `@EventListener` mapped to `ApplicationReadyEvent`. Once the embedded server confirms it is fully operational, it will automatically launch your system's default web browser and navigate directly to the application dashboard.
* **Full CRUD Operations:** The single-page interface supports Creating, Reading, Updating, and Deleting records, communicating with the backend REST API via asynchronous `fetch` requests.

***
