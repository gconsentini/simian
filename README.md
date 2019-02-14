# Simian

[![Build Status](https://travis-ci.com/gconsentini/simian.svg?token=KZDxfvLBJjXWnE7PFgoy&branch=master)](https://travis-ci.com/gconsentini/simian)

[![codecov](https://codecov.io/gh/gconsentini/simian/branch/master/graph/badge.svg?token=rHjjgFRv0k)](https://codecov.io/gh/gconsentini/simian)

## Api rodando no ECS com orquestração de containers
http://ec2-18-231-83-217.sa-east-1.compute.amazonaws.com/swagger-ui.html

**`GET -> http://ec2-18-231-83-217.sa-east-1.compute.amazonaws.com/simian`**

**`POST -> http://ec2-18-231-83-217.sa-east-1.compute.amazonaws.com/stats`**


Api para verificar se um DNA é Simio ou Humano.

## Tecnologias utilizadas

- Java 8
- Springboot
- H2
- Lombok
- Swagger
- Junit
- Jacoco
- Docker, Docker-compose
- TravisCI
- Codecov

## O que é necesário para rodar a API

- [Docker](https://www.docker.com/)
- [Docker-compose](https://docs.docker.com/compose/)

## Instruções
```
$ ./mvnw clean install
$ docker-compose up
```

A partir disso a mesma estará disponivel em:

http://localhost:8080/simian

http://localhost:8080/stats

### Swagger
http://localhost:8080/swagger-ui.html

No swagger tem a documentação da api, como rodar e ui para testar a api.

## API

**`POST -> /simian`**

Para verificar se um dna é simio ou humano enviar uma mensagem json da seguinte forma:

*Simio*
```json
{
    "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
```

*Humano*
```json
{ 
    "dna": ["ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"] 
}
```

**`GET -> /stats`**

Basicamente verifica a proporção de quantos dnas validos foram verificados, tanto quanto simios e humanos, além da proporção do mesmo.

```json
{
  "count_human_dna": 1,
  "count_simian_dna": 1,
  "ratio": 1
}
```