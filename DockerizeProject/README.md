# Dockerize Spring Boot project

A lightweight and efficient backend service built with Spring Boot, offering seamless Create, Read, Update, and Delete (CRUD) operations.


#### What is Spring Boot?

> Spring Boot is a framework built on top of the conventional [spring](https://spring.io/projects/spring-framework) framework. Its purpose is to help minimize configuration concerns when creating Spring-based applications. This framework came into existence when a Jira request was issued by a client, Mike Youngstrom on October 2012, requesting to bootstrap the spring framework.



#### What is Docker?

> Docker is a software platform that makes project development, testing, and deployment simple. Docker organizes your software project into standardized units called containers, each of which holds the necessary runtime, libraries, and code for your project to function [Read more](https://www.docker.com/)



## Tech Stacks
1. Spring Boot

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white) ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)


## Road Map
- [ ] Spring Boot API
    - [x] Basics
        - [x] Setup Database Connection
        - [x] Entity Relationship
        - [x] Create Basic API endpoints (CRUD)
        - [x] Implement DTO pattern (Request & Response)
    - [x] Docker
        - [x] Dockerfile
        - [x] docker-compose
    - [ ] Spring Security
        - [ ] Encrypton (Bcrypt)
        - [ ] Authentication & Authorization 
            - [ ] JWT
                - [ ] Access Token
                - [ ] Refresh Token



#### CLI
```sh
# (build project)

docker build -t <IMAGE NAME> .

# show available docker container or image

docker ps -a | docker images

or

# build configuration in your docker compose in detached mode

docker-compose up -d
```

<!-- Proudly created with GPRM ( https://gprm.itsvg.in ) -->