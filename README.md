# Coupon Management System (Spring Boot)

A clean and modular Spring Boot application that provides a simple coupon engine for e-commerce use cases.  
It supports creating coupons with detailed eligibility rules and selecting the best applicable coupon for a user and cart.

---

## 1. Features
- Create and store coupons (in-memory)
- Define eligibility rules: age, location, past categories, order count, cart value
- Supports both flat and percentage discounts with optional caps
- Automatically selects the best coupon for any given user and cart
- Auto-seeded demo coupons on startup
- Assignment-required demo login included

---

## 2. Tech Stack
- **Java 17**
- **Spring Boot**
- **Maven**
- **In-memory storage** (no external database)

---

## 3. Running the Project

### Prerequisites
- Java 17+
- Maven installed

### Steps
```bash
git clone https://github.com/PolakiJayaKrishna/coupon-management-system
cd coupon-management-system
mvn spring-boot:run

Application runs at:
``` 
http://localhost:8080
```
## 4. API Endpoints
### Create Coupon
**POST** `/api/coupons`
``` json
{
  "code": "NEW10",
  "description": "10% off",
  "discountType": "PERCENT",
  "discountValue": 10,
  "startDate": "2025-01-01",
  "endDate": "2025-12-31"
}
```
### Best Coupon
**POST** `/api/best-coupon`
``` json
{
  "user": {
    "userId": "u1",
    "totalOrders": 0,
    "age": 25,
    "location": "IN",
    "pastCategories": ["electronics"]
  },
  "cart": {
    "items": [
      {"productId": "p1", "category": "electronics", "unitPrice": 1200, "quantity": 1}
    ]
  }
}
```
### Get All Coupons
**GET** `/api/coupons`
## 5. Demo Login (Assignment Requirement)
A demo user is auto-loaded at startup:
``` 
email: hire-me@anshumat.org
password: HireMe@2025!
```
## 6. Error Handling
The project currently uses Spring Boot's default error responses. This can be expanded with:
- Request validation (`@Valid`)
- Centralized exception handling (`@ControllerAdvice`)
- Standard error response format

The current implementation is aligned with the assignment's scope and in-memory requirements.
## 7. Project Structure
``` 
src/main/java/com/example/couponmanagement/
│
├── config/              # Demo seed data & login
├── controller/          # REST API controllers
├── service/             # Business logic (rules, discount engine)
├── repository/          # In-memory repository
├── model/               # Domain + request/response models
└── CouponManagementApplication.java
```
## 8. How AI Was Used (Process Transparency)
AI was used to support:
- Understanding assignment requirements
- Designing class structure and flow
- Reviewing logic for correctness
- Improving consistency and readability
- Formatting this README

All core logic (rules, discount calculations, service flow, structure) was implemented manually.
## 9. Future Improvements
- Add database support (MySQL/MongoDB)
- Add validation + custom error responses
- Add JUnit test coverage
- Add Dockerfile for deployment


**Made with ☕ and 💻**
``` 

---

## Changes Made:

✅ Added the complete "Application runs at" section  
✅ Included all API endpoint details with JSON examples  
✅ Added "Get All Coupons" endpoint  
✅ Completed sections 5-9 (Demo Login, Error Handling, Project Structure, AI Usage, Future Improvements)  
✅ Added a friendly footer  
✅ Maintained professional formatting throughout
```
