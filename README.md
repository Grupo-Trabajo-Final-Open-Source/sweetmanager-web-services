# Sweet Manager Platform
## Summary

Sweet Manager Platform, illustrating development with Java, Spring Boot Framework and Spring Data MongoDB. 
It also illustrates open-api documentation configuration and integration with Swagger UI.

### Reference Documentation
For further reference, please consider the following sections:

- Official Apache Maven documentation
- Spring Boot Maven Plugin Reference Guide
- Create an OCI image
- Spring Data MongoDB
- Spring Boot DevTools
- Spring Web

### Guides

The following guides illustrate how to use some features concretely:

- Accessing Data with Spring Data MongoDB
- Building a RESTful Web Service
- Serving Web Content with Spring MVC
- Building REST services with Spring

## Features
- RESTful API
- OpenAPI Documentation
- Swagger UI
- Apache Maven in Java
- Audit Creation and Update Date
- Custom Route Naming Conventions
- Custom Object-Relational Mapping Naming Conventions
- Mongo Database
- Domain-Driven Design

## Bounded Context
This proyect of SweetManager is divided in the following bounded contexts:
- Monitoring 
- Supplies
- Communication
- Payment
- Identity Access Management (IAM)
- Dashboard and Analytics
- Messages

### Monitoring Context
The Monitoring Context is responsible for managing the rooms of the hotel. It includes the following features:
- Create a new Room.
- Update a Room.
- List all the rooms in real time.

### Supplies Context
The Supplies Context is responsible for managing the supplies of the hotel. It includes the following features:
- Create a new Supply
- Update the information of the Supply.
- List all the supplies in real time.

### Communication Context
The Communication Context is responsible for managing the notifications of the users. It includes the following features:
- List all the notifications in real time.
- Create Notifications in real time.
- Get Notification By Id.

### Payment Context
The Payment Context is responsable for managing the subscriptions and payments of the users. It includes the following features:
- List all the subscriptions to the service.
- Validate information when the user subscribes.

### Identity and Access Management Context
The Identity and Access Management is responsable for managing the access of the users to the application. It includes the following features:
- Verify and Validate the information of the user.
- Create a user to the application.

### Dashboard and Analytics Context
The Dashboard and Analytics Context is responsable for managing the information in real time about the income and expenses. It includes the following features:
- List the income for every month at year.
- List the expenses for every month at year.

### Messages Context
The Messages Context is responsable for managing the messages between the users in the application. It includes the following features:
- Send message to the respective user in real time using socket.

