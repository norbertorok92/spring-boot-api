# spring-boot-api


This project is a simple API in spring-boot

## Run locally

Run `mvn spring-boot:run` for a development. Navigate to `http://localhost:8080/` in postman.

## Code scaffolding

Existing endpoints:

GET - http://localhost:8080/api/user/  `Gets all the users`
GET - http://localhost:8080/api/user/1  `Gets one user by ID`
POST - http://localhost:8080/api/user/  `Creates a user`
PUT - http://localhost:8080/api/user/2  `Updates a user`
DELETE - http://localhost:8080/api/user/2  `Deletes a user`

## NOTE

There is no database for this simple API, all the data is saved in memory. 
Once the web service is restarted all the modified data will be lost, and it starts with a brand new set of data on each and every run.