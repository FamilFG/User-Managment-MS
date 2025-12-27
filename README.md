# User-Management Microservice

## Overview
The **User-Management Microservice** is a core component of a larger microservices-based system. It is responsible for handling all user-related operations and exposes RESTful APIs that are consumed by other backend services and client applications, including a Flutter mobile frontend.

## Responsibilities
- User registration and profile management
- User data CRUD operations
- Role and permission handling
- User lifecycle management

## Project Context
This microservice is developed as part of a distributed system following a **microservices architecture**.  
Other backend services, the event-driven messaging infrastructure, and the frontend application are maintained in **separate repositories**.

The service is designed to be independent, scalable, and easily integrated with other components of the system.

## Technology Stack
- **Java**
- **Spring Boot**
- **MySQL**
- **REST APIs**

## Architecture Notes
- Stateless REST endpoints
- Database-backed user persistence
- Designed for inter-service communication within a microservices ecosystem

## Usage
This service is intended to be run as an independent backend service and integrated with other system components via REST APIs.

