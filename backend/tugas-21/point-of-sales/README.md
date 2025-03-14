# Dapur Emmak (Backend)

## Overview
This project serves as the backend service for the Dapur Emmak web application, built with Java Spring Boot and PostgreSQL hosted in Render as the backend. It Provides some essential services for Point of Sales (POS) system. enabling efficient management of sales transactions and inventory. Key features of this backend included:
1. CRUD operation for managing resources
2. Searching, filtering, and sorting for optimiezed data retrieval

## Technology
Technologies used in this project:
1. Spring Boot
2. PostgreSQL
3. Docker

## Installation & Setup
How to run this project:
1. Replace the URL, username, and password in the docker-compose.yaml with your own
```
   services:
     app:
       build: .
       container_name: spring_app
       restart: always
       environment:
         SPRING_DATASOURCE_URL: jdbc:postgresql://(render hostname).(render region)-postgres.render.com/point_of_sales
         SPRING_DATASOURCE_USERNAME: (render user)
         SPRING_DATASOURCE_PASSWORD: (render password)
       ports:
         - "8080:8080"
```

2. Build application
```bash
   mvn clean package -DskipTests
```

3. Run application in Docker
```bash
   docker-compose up -d
```

## API Endpoints
- Base endpoint: /api/v1
- Product
  1. GET /product/all -> retrieve all products
  2. GET /product/{id} -> retrieve product with certain id
  3. POST /product/add -> add new product
  4. PUT /product/update/{id} -> update product with certain id
  5. DELETE /product/delete/{id} -> delete product with certain id
- Category
  1. GET /category/all -> retrieve all cateogories
  2. GET /category/{name} -> retrieve category with certain name
  3. POST /category/add -> add new category
  4. PUT /category/update/{id} -> update category with certain id
  5. DELETE /category/delete/{id} -> delete category with certain id
- Transaction
  1. GET /transaction/all -> retrieve all transactions
  2. POST /transaction/add -> add new transaction
  3. DELETE /transaction/delete/{id} -> delete transaction with certain id

## Deployment
This project is deployed and hosted on Render [Backend Dapur Emmak](https://point-of-sales-latest.onrender.com/)

## Author
Bagus Sajiwo Utomo

LinkedIn: [linkedin.com/in/bagus-utomo]([https://point-of-sales-latest.onrender.com/](https://www.linkedin.com/in/bagus-utomo/))
GitHub: [bagusutom0](https://github.com/bagusutom0)
Email: bagussajiwoutomo12@gmail.com
