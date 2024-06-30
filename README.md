# JA_USER_INFO_HTTP

## Description
This project is a Spring Boot application that exposes a web service with basic HTTP authentication. The service accepts a username as a query parameter, checks if the user exists in a property file, and posts the user's details to another web service.

## Technologies Used
- Spring Boot
- Spring MVC
- Spring Integration
- Spring Security
- Maven
- Java 8 or above

## How to Build
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project and generate a WAR file.

## How to Run
1. Deploy the generated WAR file to a Glassfish/Tomcat server.
2. Ensure the server is running.
3. Use an HTTP client (e.g., Postman) to make a GET request to `http://localhost:8080/JA_USER_INFO_HTTP/appName/userDetail?user=admin` with basic authentication.

## Basic Authentication
The application uses basic HTTP authentication. The default username and password are specified in the `application.properties` file:
- Username: `${spring.security.user.name}`
- Password: `${spring.security.user.password}`

## Unit Tests
The project includes unit tests for the service layer using Mockito. To run the tests, use the command `mvn test`.