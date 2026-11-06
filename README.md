# Amalbek Miras Student API

Spring Boot CRUD REST API for students with PostgreSQL and Docker (documentation branch).

Author: Amalbek Miras

## Run
cp .env.example .env
docker compose up -d --build

URL: http://localhost:8080/amalbek-miras/api/students

## Change by Amalbek Miras
Added UPDATE operation: PUT /amalbek-miras/api/students/{id}.
It updates firstName, lastName, email and groupName and returns 404 if the student does not exist.
