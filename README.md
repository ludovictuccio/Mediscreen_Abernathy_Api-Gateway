<img src="https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white"/> * * *  <img src="https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white"/>  * * *  <img src="https://img.shields.io/badge/docker%20-%230db7ed.svg?&style=for-the-badge&logo=docker&logoColor=white"/>

# Mediscreen_Abernathy - Api Gateway

OpenClassrooms - Project 9 <br/>
Mediscreen_Abernathy App - Api Gateway <br/>

---

For deploiement, please refer to Patient microservice readme: https://github.com/ludovictuccio/Mediscreen_Abernathy_Patient/tree/develop

---

## To run microservice:

- **With your IDE**: refer to **application.properties** to set valid proxies url

- **With Docker**: the **application.properties** is written for the Docker deploiement. The Dockerfile will build the microservice and run the jar to run it.

## For Docker deploiement:

1. Install Docker Desktop: <br/>
https://docs.docker.com/docker-for-windows/ or https://docs.docker.com/docker-for-mac/

2. The **Dockerfile** will build the microservice and run the jar to run it. <br/>
To use it, you must run on the package root: 
- `docker build -t mediscreen-apigateway .`
- `docker run -d -p 8080:8080 mediscreen-apigateway`

3. To run all microservices on the same network, with a Docker-Compose deploiement: <br/>
If you want to deploy all Mediscreen microservices, use the **docker-compose.yml** on the package root, after each Dockerfile deployment for the 4 microservices, running:
- `docker network create md-net`
- `docker-compose up -d`