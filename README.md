# Cinema-app(in progress...)

![image](src/main/resources/pictures/cinema01.png)

## Introduction
This is a small web service for buying tickets to the movies!
## Functions Of App
After login in, user can use following possibilities:
- Admin:
  - looking for users by their email;
  - add/delete/update information about movies, cinema halls and movie sessions.
- User:
  - showing him shopping cart;
  - booking/buying tickets;
- Unauthorized  User:
  - registration
  - viewing all available sessions and information about all cinema halls
  - searching session by date

## Architecture Of App
Current application uses in their structure N-tier architecture and SOLID and REST principles:
- DAO layer is responsible for work with DB. It was built with Hibernate ORM framework;
- Service layer is responsible for processing some business logic;
- Controller layer is responsible for work with client (receiving requests and giving responses). It was built with Spring framework.

## Current Technologies
- Spring (MVC, Security, Web)
- Hibernate ORM
- Apache Tomcat - version 9.0.48
- MySQL - version 8.0.22
- Project builder: Apache Maven

## How To Run This Project
1. Clone this project into your local folder and open the project in an IDE.
2. Configure Tomcat Server and set up the MySQL RDBMS on your machine.
3. Insert your own MySQL username and login in dbProperties in the resources' folder.
4. Setup new connection with:
  - user: "your username"
  - password: "your password"
  - url: jdbc:mysql://hhhh:pppp/dddd?useUnicode=true&serverTimezone=UTC, where:
  - hhhh - host name,
  - pppp - port,
  - dddd - database name
5. Run a project
   6.Enjoy working with the application ;)
