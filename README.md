# cart-mvp

This project is the source code for [this](https://dev.to/sergiogh14/construyendo-un-mvp-sin-base-de-datos-1i4k) article.

## Use case

> We have an application that has a fixed amount of monthly users, so the possibility of adding a shopping cart to purchase merchandising of the brand is raised. With this little experiment we will analyze how well a small shopping section can fit inside the application.

The code tries to illustrate how we can build a first MVP without any database. The goal of this implementation is to
advance the moment of data collection and build the MVP independently of any kind of framework. Once we have the
necessary data to understand the storage needs of the project we can implement it keeping the current independence to
remain flexible.

## Build

```shell
/gradlew build
```

## Run

```shell
/gradlew bootRun
```

## Test

```shell
/gradlew test
```

### Swagger
There is a swagger interface available in [localhost:8080/](http://localhost:8080/)
