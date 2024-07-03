# Installing and Setting Up Keycloak with Spring Boot

## Endpoints
Admin:
[GET] http://localhost:8081/api/admin
Authorization - Bearer Token with admin privileges

User:
[GET] http://localhost:8081/api/user
Authorization - Bearer Token with user privileges

## Download and Installation

1. **Download Keycloak:**
   - Visit [Keycloak Downloads](https://www.keycloak.org/downloads).
   - Choose the appropriate distribution (e.g., ZIP).
   - Download and extract the ZIP file to a directory.

2. **Navigate to Keycloak Bin Directory:**
   - Open a terminal or command prompt.
   - Change directory to `bin` inside your extracted Keycloak directory:
     ```bash
     cd path_to_your_keycloak/keycloak-25.0.1/bin
     ```

## Starting Keycloak Server

3. **Start Keycloak in Development Mode:**
   - Run the following command to start Keycloak:
     ```bash
     kc.bat start-dev
     ```
   - This command starts Keycloak in development mode, suitable for local testing.

## Accessing Keycloak Admin Console

4. **Access Keycloak Admin Console:**
   - Open a web browser and go to:
     ```
     http://localhost:8080
     ```
   - If it's your first time, click "Register" to create an admin account.
   - Log in using your newly created admin credentials.

## Setting Up Keycloak

5. **Create a Realm, Clients, Roles, and Users:**
   - Inside the Keycloak admin console:
      - Create a new realm (e.g., `SpringBootDemoKeyCloak`).
      - Create a client (e.g., `springboot-demo-keycloak-client`).
      - Configure roles (`admin` and `user`).
      - Add users and assign roles to them.
## Keycloak Setting Images

![logo](https://github.com/ajaykumar070014/Spring-Boot-Keycloak-Integration/blob/Main/images/1a.png)
![logo](https://github.com/ajaykumar070014/Spring-Boot-Keycloak-Integration/blob/Main/images/1.png)
![logo](https://github.com/ajaykumar070014/Spring-Boot-Keycloak-Integration/blob/Main/images/2.png)
![logo](https://github.com/ajaykumar070014/Spring-Boot-Keycloak-Integration/blob/Main/images/3.png)
## Configuring Your Spring Boot Application

6. **Configure Your Spring Boot Application:**
   - Update your Spring Boot `application.yml` (or `application.properties`) with Keycloak configuration for OAuth 2.0 integration.
   - Ensure your application's security configuration (`SecurityConfig`) aligns with the roles and endpoints configured in Keycloak.

   Example `application.yml` configuration:
   ```yaml
   spring:
     security:
       oauth2:
         resourceserver:
           jwt:
             issuer-uri: http://localhost:8080/auth/realms/SpringBootDemoKeyCloak
             jwk-set-uri: ${spring.security.oauth2.resourceserver.jwt.issuer-uri}/protocol/openid-connect/certs

   server:
     port: 8081
