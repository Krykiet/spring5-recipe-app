# Spring web application for recipe storage

## Dependencies:
* Spring Boot Starter Data JPA
* Thymeleaf
* Spring Boot Starter Web
* H2

App uses bootstrap data to initialize Hibernate database and displays recipe list on index page. 

To acces full data:

http://localhost:8080/h2-console/
url: jdbc:h2:mem:testdb

Important:
To use data.sql file (default format for Spring Data JPA data initialization) following line:

`spring.jpa.defer-datasource-initialization=true`

 is necessary in `application.properties`.

Simple change to test Circle CI
