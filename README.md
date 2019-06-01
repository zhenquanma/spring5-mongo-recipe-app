[![CircleCI](https://circleci.com/gh/zhenquanma/spring5-mongo-recipe-app.svg?style=svg)](https://circleci.com/gh/zhenquanma/spring5-mongo-recipe-app)
[![codecov](https://codecov.io/gh/zhenquanma/spring5-mongo-recipe-app/branch/master/graph/badge.svg)](https://codecov.io/gh/zhenquanma/spring5-mongo-recipe-app)

# Spring5 Mongo Recipe App 


The Recipe App(MongoDB ver.) is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). Users can upload, view recipes with this web application. The project was developed originated from an online course named [Spring Framework 5 - Beginner to Guru](https://go.springframework.guru/spring-framework-5-online-course)

## Getting Started
Recipe Application in this repository is using embedded MongoDB as its database.
See instructions below to get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
The following items should be installed in your system:
* Java 8 or newer.
* Intellij IDE(Optional but recommended)


## Running Recipe locally:
1. To download the code, you can use your command line (Recommended):
```
git clone https://github.com/zhenquanma/spring5-mongo-recipe-app.git
```
2. Build a jar file and run it from the command line
```
cd spring5-mongo-recipe-app
gradle bootRun
```

You can then access Recipe here: http://localhost:8080/

## Database configuration:
In its default configuration, Recipe uses an embedded Mongo which gets populated at startup with data. 
