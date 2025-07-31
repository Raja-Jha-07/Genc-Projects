# Genc Projects Repository

This repository contains a collection of training and learning projects covering various technologies including Spring Boot, Angular, and Java fundamentals.

## Projects Overview

### 🚀 Spring Boot Applications

#### 1. Coffee Machine (`coffeeMachine/`)
A Spring Boot application that simulates different types of coffee machines.

**Features:**
- Espresso Machine implementation
- Latte Machine implementation
- Dependency injection with Spring
- Cafe service for managing coffee operations

**Technologies:** Spring Boot 3.x, Java 21, Maven

**How to run:**
```bash
cd coffeeMachine
./mvnw spring-boot:run
```

#### 2. Demo - Book Management System (`demo/`)
A comprehensive Spring Boot application demonstrating enterprise-level features.

**Features:**
- RESTful API for book management
- JPA/Hibernate with H2 database
- Spring Security configuration
- Global exception handling
- Metrics and monitoring
- Input validation
- Logging service

**Technologies:** Spring Boot 3.x, Spring Security, JPA, H2 Database, Java 21, Maven

**How to run:**
```bash
cd demo
./mvnw spring-boot:run
```

### 🅰️ Angular Applications

#### 3. First Angular App (`first-angular-app/`)
A basic Angular application for learning Angular fundamentals.

**Technologies:** Angular 18+, TypeScript, CSS

**How to run:**
```bash
cd first-angular-app
npm install
npm start
```

#### 4. Welcome Project (`welcome-project/`)
Another Angular application project for practicing Angular development.

**Technologies:** Angular 18+, TypeScript, CSS

**How to run:**
```bash
cd welcome-project
npm install
npm start
```

### ☕ Java Training

#### 5. Java Training (`javaTraining/`)
A comprehensive Java training project focusing on SOLID principles and design patterns.

**Topics covered:**
- **Single Responsibility Principle (SRP)**
- **Open/Closed Principle (OCP)**
- **Liskov Substitution Principle (LSP)**
- **Interface Segregation Principle (ISP)**
- **Dependency Inversion Principle (DIP)**

**Features:**
- Practical examples of each SOLID principle
- Design pattern implementations
- Code organization and best practices

**Technologies:** Java 21

**How to run:**
```bash
cd javaTraining
javac -d bin src/com/example/solid/*.java
java -cp bin com.example.solid.MainSingle
```

#### 6. Maven Project Template (`My-Maven-Project/`)
A simple Maven project template for Java development.

**Technologies:** Java 21, Maven

**How to run:**
```bash
cd My-Maven-Project
mvn compile exec:java
```

## Prerequisites

### For Spring Boot Projects:
- Java 21
- Maven 3.6+ (or use included Maven wrapper)

### For Angular Projects:
- Node.js 18+ 
- npm 8+
- Angular CLI (`npm install -g @angular/cli`)

### For Java Training:
- Java 21
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

## Development Setup

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd Genc-Projects
   ```

2. **For Spring Boot projects:**
   ```bash
   cd <project-directory>
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

3. **For Angular projects:**
   ```bash
   cd <project-directory>
   npm install
   npm start
   ```

## Project Structure

```
Genc-Projects/
├── coffeeMachine/          # Spring Boot Coffee Machine App
├── demo/                   # Spring Boot Book Management System
├── first-angular-app/      # Basic Angular Application
├── welcome-project/        # Angular Welcome Application
├── javaTraining/           # Java SOLID Principles Training
├── My-Maven-Project/       # Maven Project Template
├── README.md              # This file
└── .gitignore             # Git ignore patterns
```

## Learning Objectives

This repository demonstrates:
- **Spring Boot Development**: REST APIs, Security, JPA, Dependency Injection
- **Angular Development**: Component-based architecture, TypeScript
- **Java Fundamentals**: SOLID principles, Design patterns, OOP concepts
- **Build Tools**: Maven for Java projects, npm for Angular
- **Version Control**: Git best practices with proper .gitignore

## Contributing

This is a personal learning repository. Feel free to explore the code and use it for educational purposes.

## License

This project is for educational purposes only.
