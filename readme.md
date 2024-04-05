**Elasticsearch Integration with Spring Boot and QueryDSL**

This project demonstrates how to integrate Elasticsearch with Spring Boot using QueryDSL for querying documents.

**Prerequisites**

Before running this project, make sure you have the following installed:

Java Development Kit (JDK) 8 or higher

Maven

Elasticsearch (Download and install from here)

Docker (optional, if you prefer running Elasticsearch in a Docker container)

**Setup**

**Clone the repository:**

https://github.com/NashTech-Labs/springboot-with-elasticsearch.git

**Navigate to the project directory:**

cd your-location

**Start Elasticsearch:**

docker-compose up -d

**Running the Application**

To run the application, execute the following Maven command

mvn spring-boot:run

**Usage:**

Once the application is running, you can access the API endpoints to interact with Elasticsearch. The following endpoints are available:

POST /v1/customer/addCustomers : This endpoint is use to add List of customers.

GET /v1/customer/findAll : This endpoint is use to find all customers.

GET /v1/customer/findByFirstName/{firstName} : This endpoint is use to find customer by its firstname.

DELETE /v1/customer/deleteById/{id} : This endpoint is use to delete customer by its id.

GET /v1/customer/findByFirstName/{firstName} : This endpoint is use to find customer by its firstname.

GET /v1/customer/matchAll : This endpoint is use to find customer from entire collection using QueryDSL.

GET /v1/customer/matchAllCustomer : This endpoint is use to find customer from customer collection only using QueryDSL.

GET /v1/customer/matchAllCustomer/{first} : This endpoint is use to find all matching customer from customer collection only using QueryDSL.

**Querying Elasticsearch with QueryDSL**


This project utilizes QueryDSL to construct complex queries for Elasticsearch.
You can define your query predicates using the QueryDSL API.