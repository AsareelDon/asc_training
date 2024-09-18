# Dockerize Spring Boot project

**SpringBoot CRUD API**: A lightweight and efficient backend service built with Spring Boot, offering seamless Create, Read, Update, and Delete (CRUD) operations.

## What is Spring Boot?
> Spring Boot is a framework built on top of the conventional [spring](https://spring.io/projects/spring-framework) framework. Its purpose is to help minimize configuration concerns when creating Spring-based applications. This framework came into existence when a Jira request was issued by a client, Mike Youngstrom on October 2012, requesting to bootstrap the spring framework.

## What is Docker?
> Docker is a software platform that makes project development, testing, and deployment simple. Docker organizes your software project into standardized units called containers, each of which holds the necessary runtime, libraries, and code for your project to function [Read more](https://www.docker.com/)

#### CLI
```
docker build -t <IMAGE NAME> . // build project

docker ps -a | docker images // show available docker container or image

or

docker-compose up -d // build configuration in your docker compose in detached mode 
```