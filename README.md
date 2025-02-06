# Scheduling API

This project is an appointment scheduling API that allows users to create and manage appointments based on specific business rules, including validations for date and amount. The application is developed using Spring Boot and utilizes Springdoc OpenAPI for automatic documentation.

## Features

- **Create Appointment**: Allows users to create appointments with necessary details in a DTO (Data Transfer Object).
- **Business Rule Validation**: Business rules are applied to ensure that the appointment dates and values are within defined limits.
- **Exception Handling**: Custom exceptions are thrown and globally handled using `@ControllerAdvice`.
- **Factory Design Pattern**: Used for creating different scheduling objects based on specific business rules, allowing for flexibility and ease of maintenance.
- **Strategy Design Pattern**: Applied to handle different business strategies for scheduling, allowing for dynamic selection of rules based on the amount or other criteria.

## Technologies Used

- **Spring Boot**: The main framework for building the application.
- **Springdoc OpenAPI**: Used for generating the Swagger documentation for the API.
- **H2 Database**: In-memory database for data persistence during development.
- **JUnit & Mockito**: For unit testing and mocking dependencies.

## How to Run

### Prerequisites

- **JDK 17+**: The application was built using JDK 17.
- **Maven**: For managing dependencies and building the project.

### Steps to Run Locally

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/scheduling-api.git
   cd scheduling-api
