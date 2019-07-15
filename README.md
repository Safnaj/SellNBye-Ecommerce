# SellNBye E-commerce System

### Tools and Technologies:
* **Technology** : Bootstrap, Java, Spring Boot, MVC, Hibernate, JSP, Maven.
* **Application Servicer**: Apache Tomcat Server
* **Database** : MySQL.

### Installation:
1. Development Platform - Eclipse
   * [Download Eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars2)
2. Server - Apache Tomcat Server
   * [Download Apache Server](https://tomcat.apache.org/download-70.cgi)
3. Build Tool - Maven
   * [Download Maven](https://maven.apache.org/download.cgi)
4. Database - MySQL Database
   * Go to application.properties file and get the database name & create databases in your MySQL
5. Configuring tomcat with Eclipse (windows) -(https://javatutorial.net/run-tomcat-from-eclipse)
6. Installation of maven in eclipse - (https://stackoverflow.com/questions/8620127/maven-in-eclipse-step-by-step-installation)
7. Clone the repository and import it to eclipse
8. Install Spring Tools in Eclipse IDE Marketplace.
9. Run your MySQL Database/Wamp Server.
10. Run Maven Build
11. Run as Spring Boot Application

###### Use Postman to Check RESTful URLs, [Download Postman](https://www.getpostman.com/)


Micro-Service URLs
--------------
#### Items
* localhost:8080/items  GET
* localhost:8080/items/{id}  GET
* localhost:8080/items  POST
* localhost:8080/items/{id}  PUT
* localhost:8080/items/{id}  DELETE

#### Customers
* localhost:8080/customers  GET
* localhost:8080/customers/{id}  GET
* localhost:8080/customers  POST
* localhost:8080/customers/{id}  PUT
* localhost:8080/customers/{id}  DELETE

#### Sellers
* localhost:8080/sellers  GET
* localhost:8080/sellers/{id}  GET
* localhost:8080/sellers  POST
* localhost:8080/sellers/{id}  PUT
* localhost:8080/sellers/{id}  DELETE

#### Orders
* localhost:8080/shopping/orders  GET
* localhost:8080/shopping/orders/{id}  GET
* localhost:8080/shopping/orders  POST
* localhost:8080/shopping/orders/{id}  PUT
* localhost:8080/shopping/orders/{id}  DELETE

JSON Example :
```
{
	"id": 1,
	"noOfItems": 5,
	"total": 5000,
	"orderCreatedAt": "2017-06-11",
	"payementStatus": "success"
}
```

#### Payements
* localhost:8080/payments  GET
* localhost:8080/payments/{id}  GET
* localhost:8080/payments  POST
* localhost:8080/payments/{id}  PUT
* localhost:8080/payments/{id}  DELETE

#### simple payment handler
* localhost:8080/accounts  GET
* localhost:8080/accounts/{id}  GET
* localhost:8080/accounts  POST
* localhost:8080/accounts/{id}  PUT
* localhost:8080/accounts/{id}  DELETE

* localhost:8080/transactions  GET
* localhost:8080/transactions/{id}  GET
* localhost:8080/transactions  POST
* localhost:8080/transactions/{id}  PUT
* localhost:8080/transactions/{id}  DELETE


