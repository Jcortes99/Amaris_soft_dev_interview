# Amaris Software Interview Project  

## Overview  
This project is a Spring Boot application designed to manage user information and calculate employee annual salaries. It provides RESTful APIs for user management.  

## Technologies Used  
- **Java** (Spring Boot, Spring Data JPA, Spring Web)  
- **WildFly** (for production deployment)  
- **JUnit 5** (for testing)  

## Features  
- Create operations for users.  
- Automatic calculation of annual salary based on the employee's monthly salary.  
- REST API endpoints for user management.  
- Deployed on a Linux server using WildFly.  

## Setup and Installation  

### Prerequisites  
- JDK 17+  
- Maven  
- WildFly (for deployment)  

### Steps to Run Locally  
1. Clone the repository:  
   ```bash
   git clone https://github.com/Jcortes99/Amaris_soft_dev_interview.git
   cd your-repository
   ```  
2. Build and run the application:  
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```  
3. Access the API at `http://localhost:8080/Users`.  

## Deployment to WildFly  

1. Generate the WAR file:  
   ```bash
   mvn clean package
   ```  
   Or use the one in the GitHub repository:  
   **SoftwareInterview.war**  

2. Copy the WAR file to WildFly's deployment folder:  
   ```bash
   cp target/your-app.war /path/to/wildfly/standalone/deployments/
   ```  
3. Start WildFly:  
   ```bash
   /path/to/wildfly/bin/standalone.sh
   ```  

### NOTE  
The front-end was developed to communicate with the WildFly server. The code fetches data from:  
```bash
http://localhost:8080/SoftwareInterview/Users/get-all-users
```  
If you are deploying the solution with Maven, you have to change the endpoint to:  
```bash
http://localhost:8080/Users/get-all-users
```  

## Running Tests  
To execute unit tests:  
```bash
mvn test
```  

## API Endpoints  

| Method | Endpoint                  | Description                               | Status           |
|--------|---------------------------|-------------------------------------------|------------------|
| GET    | `/get-user/{id}`          | Get user data from the API                | Not used by Front |
| GET    | `/get-user`               | Get all users' information from the API   | Not used by Front |
| GET    | `/get-anual-salary/{id}`  | Get user data with the annual salary      | Used by Front     |
| GET    | `/get-all-users`          | Get all users' data with the annual salary | Used by Front     |

## License  
This project is licensed under the MIT License.  

## Contact  
For any questions or support, please contact: **jcortesro99@gmail.com**  

## Additional Comments  
The application follows a standard REST API pattern, dividing the folders into **models, services (business logic), controllers, and config**.  

For this interview, I attempted to test the controllers (business layer), but I wasn't able to finish those tests. There is only one test for the `UserService`.  

