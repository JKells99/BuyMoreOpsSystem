# 🛠️ Buy More Ops - Backend (Spring Boot)

Welcome to the backend system for **Buy More Ops**, a fictional employee and secret agent management system based on the TV show *Chuck*. This API powers both employee operations at the Buy More store and the secret activities of government agents working behind the scenes.

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Spring Security (for BCrypt only, not enforcing security)**
- **BCrypt password hashing**
- **RESTful APIs**
- **Lombok (for cleaner code)**

## 📦 Project Purpose

This project demonstrates the following concepts:

- One-to-One, One-to-Many, and Many-to-Many relationships in Spring Boot
- Secure password storage using **BCrypt**
- Clean layering (Controller → Service → Repository)
- Stateless authentication (no sessions or JWT for now)
- Prep for future integration with **Keycloak** (for role-based access and OAuth2)

- ## 🔐 Authentication Flow (Simplified)

- Users register with a **plain-text password and username**
- Password is hashed using **BCrypt** before being saved
- During login, we compare the raw password against the hashed one
- If it matches, the login is accepted (for now, just a success response)
- for login I am using just a LoginDTO which will just pass in the username and password from the user OBJ

> _Note: No JWTs or sessions are used right now — we're focusing on **manual password hashing and login checks**._

## 📖 Entity Relationships

- **User** → Represents all system users
- **Employee** → Extends a user to represent Buy More staff
- **Agent** → Represents government operatives, Extends a User 
- **Department** → Has many Employees (one-to-many)
- **Missions** → Can involve many Agents (many-to-many)


> - One-to-Many (Department → Employees)
> - One To Many ( HQ -> Doors)
> - Many-to-Many (Agent ↔ Missions)

## 🧪 Example API Endpoints

- `POST /auth/register` → Register a new user
- `POST /auth/login` → Log in and validate credentials
- `GET /employees` → Get list of employees (secured in the future)
- `GET /agents` → List of active agents (secured in the future)
