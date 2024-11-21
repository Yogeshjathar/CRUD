# Spring Boot Application: Category and Product Management

## Overview
This Spring Boot application is designed to manage categories and products with CRUD operations, server-side pagination, and a one-to-many relationship between categories and products.

# API Endpoints
# Category APIs

## GET All Categories
URL: http://localhost:8080/api/categories?page=3

## GET Category by ID
URL: http://localhost:8080/api/categories/{id}

## POST Create a New Category
URL: http://localhost:8080/api/categories

## PUT Update Category by ID
URL: http://localhost:8080/api/categories/{id}

## DELETE Category by ID
URL: http://localhost:8080/api/categories/{id}


# Product APIs
## GET All Products
URL: http://localhost:8080/api/products?page=3

## GET Product by ID
URL: http://localhost:8080/api/products/{id}

## POST Create a New Product
URL: http://localhost:8080/api/products

## PUT Update Product by ID
URL: http://localhost:8080/api/products/{id}

## DELETE Product by ID
URL: http://localhost:8080/api/products/{id}

# Steps to Run the Application
## Prerequisites
1. Java 17
2. MySQL
3. Git

## Steps
1. Clone the repository:
```
git clone <your-repo-url>  
cd <repository-folder>
```
 
2. Configure the database in application.properties:
```
#database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/machine_test
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  
```
## Note : 1. make shure to create a schema if it shows error or exception in application 
##        2. create schema as ``` machine_test ```

3. Build the project using Maven:
``` mvn clean install ```

4. Run the application:
``` mvn spring-boot:run ```

5. Access the application at:
URL: http://localhost:8080

# Machine Test Execution
1. Run the application locally following the steps above.
2. Use tools like Postman to test the APIs.
3. Verify functionality and pagination by interacting with the endpoints.

# DB Design
## category Table

| Field Name | Type    | Description    |
| :---:   | :---: | :---: |
| id | Integer   | Unique identifier for category   |
| name | String   | Name of the category   |


## product Table

| Field Name | Type    | Description    |
| :---:   | :---: | :---: |
| id | Integer   | Unique identifier for product   |
| name | String   | Name of the product   |
| price | Double   | price of the product   |
| category_id | Category   | category id of the product   |



