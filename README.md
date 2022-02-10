# Spring Boot 2 Essentials

Repository created to keep track of every code developed as I watch the videos on the [DevDojo Spring Boot 2 playlist](https://www.youtube.com/playlist?list=PL62G310vn6nFBIxp6ZwGnm8xMcGE3VA5H), with each video covering specific topics on Spring and Spring Boot application development.

## What it covers

Creation of a simple project using Spring Boot, implementing a REST Controller and CRUD operations, using Spring Data, on a simple entity.

The entity is mapped using JPA along side [Lombok](https://projectlombok.org/). It uses a MySQL database as a docker image.

The REST Controller defines GET, PUT, POST and DELETE operations, and also handles exceptions that might be thrown during the execution of these operations.

[Mapstruct](https://mapstruct.org/) is also used to convert POST and PUT request data to/fromt entities instead of directly using entities in the implementation.

Both the Repository and Cotroller layers have unit test coverage.
