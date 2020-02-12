# Project Skeleton for Spring Boot Web Sevice

## Getting Started

This is a project skeleton for a [Spring Boot](http://projects.spring.io/spring-boot/) RESTful web services application.

### Features

#### RESTful Web Service Family
The project contains examples of **C** reate, **R** ead, **U** pdate, and **D** elete web services.  The project illustrates the use of `@ExceptionHandler` methods and `@ControllerAdvice` classes to manage web service responses when common exceptional conditions arise.

#### Business Services
The project demonstrates the encapsulation of business behaviors into domain-specific, Spring-managed services annotated with `@Service`.

#### H2 In-Memory Database
This project shows how to use the H2 in-memory database, which can be useful in development environments.

#### MySQL Database
In addition to H2 support, the project also supports integration with MySQL.

## Languages

This project is authored in Java.

## Installation
### Fork the Repository
Fork the [springboot-skeleton project](https://github.com/myhgs/springboot-skeleton) on GitHub.  Clone the project to the host machine.

### Dependencies

The project requires the following dependencies be installed on the host machine:

* Java Development Kit 8 or later

and, optionally, install:
* MySQL \*

\* By default, the project uses the bundled, in-memory H2 database. However, MySQL may be used by activating the *"mysql"* Spring profile.