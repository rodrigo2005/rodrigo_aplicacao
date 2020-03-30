# Cotação


#### será necessário

- Apache Maven 3.6.3
- Docker version 18.09.7
- Java 8

Comandos:
```
- git clone https://github.com/rodrigo2005/rodrigo_aplicacao.git
- cd rodrigo_aplicacao
- ./mvnw package
- docker build -f src/main/docker/Dockerfile.jvm -t cotacao:1.0 .
- cd ambiente
- docker-compose up
```
