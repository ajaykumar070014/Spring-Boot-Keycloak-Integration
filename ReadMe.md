# Installing and Setting Up Keycloak with Spring Boot

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

## Postman cURL

  ```cURL
curl --location 'http://localhost:8081/api/user' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJoaGNRR1ZpTWo0ZlJyLXp1VXpFdHRCb2U4UzZ1c3NMYkVEcUJvRWVpaUxvIn0.eyJleHAiOjE3MjAwOTU3OTIsImlhdCI6MTcyMDA5NTQ5MiwianRpIjoiMTgxZjQ4ZjAtMWZkMi00YmVmLTg1YjgtYjlhM2E1MDgxOWZiIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9TcHJpbmdCb290RGVtb0tleUNsb2FrIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjM0MTI4MzNjLTVjNmMtNGU2MC04NjM3LTBhMzNiNGNlYjcxZCIsInR5cCI6IkJlYXJlciIsImF6cCI6InNwcmluZ2Jvb3QtZGVtby1rZXljbG9hay1jbGllbnQiLCJzaWQiOiJmZDZhYTUzNS05MWVlLTQ1MDktYThhMS1kYjdkNWU2ZDI2NjQiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbInJlYWxtX3VzZXIiLCJkZWZhdWx0LXJvbGVzLXNwcmluZ2Jvb3RkZW1va2V5Y2xvYWsiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19LCJzcHJpbmdib290LWRlbW8ta2V5Y2xvYWstY2xpZW50Ijp7InJvbGVzIjpbInVzZXIiXX19LCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5hbWUiOiJhIGEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhcHBfdXNlciIsImdpdmVuX25hbWUiOiJhIiwiZmFtaWx5X25hbWUiOiJhIiwiZW1haWwiOiJhcHBfdXNlckBhYmMuY29tIn0.jmKblQGSiPd2VCv7afbBWhztqba2NTzDAXl9VNpj9gJUyj-wCGLJ3ZNrE5jd60oBNcQ0DuATFjPzNXgX7oFobxo4IWO5K7KPhp_Igwws6_orBMS6tZO5k0170ard_unhLSsq8GNxgGOd76Cqt6P6lSmpyTcfSbM63E54zV3Eov3NEqvtFOWlC0Idhv6ZytLNr2c1asgV28j4OhR-ZvVHcOGTj6umY3RlBcufPbXxOzu-XKEN0Lt54gds0O0vu0QOpGxF55GispktBM2sXQpZRYk71CcjOGlrL4lO4DOCyGNUkFpVl_ctY-jYmsmZjpDYFu-1Vk1zpvCNFmCo8fR2DA'
```

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
