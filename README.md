# Coupon Management System

A simple Coupon Management System for an e-commerce use case, built with Spring Boot.

## Project Overview
This system provides a RESTful API to:
1.  **Create Coupons**: Define coupons with various eligibility rules (cart value, user tier, categories, etc.).
2.  **Find Best Coupon**: Determine the best applicable coupon for a given user and cart context, maximizing the discount.

## Tech Stack
*   **Language**: Java 17
*   **Framework**: Spring Boot 3.3.5
*   **Build Tool**: Maven (Wrapper included)
*   **Dependencies**: Spring Web, Spring Boot Starter Test

## How to Run

### Prerequisites
*   Java 17 or higher installed.

### Setup & Run
1.  Clone the repository.
2.  Open a terminal in the project root.
3.  Run the application using the Maven Wrapper:
    *   **Windows**: `.\mvnw.cmd spring-boot:run`
    *   **Linux/Mac**: `./mvnw spring-boot:run`
    *   **IntelliJ IDEA**: Simply right-click `CouponManagementApplication.java` and select **Run**.

The application will start on port `8081`.

### Demo Login
A demo user is seeded at startup:
*   **Email**: `hire-me@anshumat.org`
*   **Password**: `HireMe@2025!`

## API Endpoints

### 1. Create Coupon
*   **POST** `/coupons`
*   **Body**:
    ```json
    {
      "code": "SAVE50",
      "description": "Save 50 on orders above 500",
      "discountType": "FLAT",
      "discountValue": 50.0,
      "startDate": "2023-01-01T00:00:00",
      "endDate": "2025-12-31T23:59:59",
      "eligibility": {
        "minCartValue": 500.0
      }
    }
    ```
### 2. Get Best Coupon
*   **POST** `/applicable-coupons`
*   **Body**:
    ```json
    {
      "user": {
        "userId": "u123",
        "userTier": "GOLD",
        "lifetimeSpend": 5000,
        "ordersPlaced": 10,
        "country": "IN"
      },
      "cart": {
        "items": [
          { "productId": "p1", "category": "electronics", "unitPrice": 1000, "quantity": 1 }
        ]
      }
    }
    ```

### 3. Login (Demo)
*   **POST** `/api/login`
*   **Body**: `{ "email": "...", "password": "..." }`

## How to Run Tests
Run the following command to execute the automated test suite:
*   **Windows**: `.\mvnw.cmd test`
*   **Linux/Mac**: `./mvnw test`
*   **IntelliJ IDEA**:
    1.  Navigate to `src/test/java`.
    2.  Right-click on the `com.example.couponmanagement` package (or the `CouponManagementApplicationTests.java` file).
    3.  Select **Run 'Tests in...'** (look for the green play icon).

## Quick Testing
A `test_requests.http` file is included in the project root. This file can be used in IntelliJ IDEA or VS Code to run API requests directly against the running application, eliminating the need for external tools like Postman.

## AI Usage & Workflow
This project was developed by leveraging AI tools to simulate a modern, high-efficiency software development workflow. I utilized AI assistance to:
*   **Accelerate Development**: Rapidly scaffold the project structure and generate boilerplate code, allowing me to focus on the core business logic.
*   **Debug Efficiently**: Quickly diagnose and resolve build configuration issues (e.g., Maven dependency conflicts).
*   **Ensure Quality**: Generate comprehensive test scenarios to validate edge cases in the coupon eligibility logic.
*   **Documentation**: Assist in structuring clear and professional documentation.

*All code and logic were reviewed, tested, and validated by me to ensure correctness and adherence to the assignment requirements.*
