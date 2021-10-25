# Simple Microservices Exchange

A simple currency exchange API built with Spring Boot.

[comment]: <> (<img src="crypto_app_screenshot.jpeg" width="40%" height="40%">)

## Instructions

Import all modules in your favorite ide and run. 

## Ports

| Service  | Port |
| ------------- | ------------- |
| Currency Exchange Service  | 8000  |
| Currency Conversion Service  | 8100  |
| Netflix Eureka Naming Server  | 8761  |
| Netflix Zuul API Gateway Server  | 8765  |

## URLs

| Service  | URL Example |
| ------------- | ------------- |
| Currency Exchange Service  | http://localhost:8000/currency-exchange/from/USD/to/BRL  |
| Currency Conversion Service  | http://localhost:8100/currency-conversion/from/USD/to/BRL/quantity/10  |
| Netflix Eureka Naming Server  | http://localhost:8761/  |
| Netflix Zuul API Gateway Server  | http://localhost:8765/currency-conversion/from/USD/to/EUR/quantity/10  |