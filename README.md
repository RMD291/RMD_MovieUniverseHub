# RMD_MovieUniverseHub
Exercise in creating a full stack app, with integration with "themoviedb.org"

Note:
Update the following parameters in src/main/resources/application.properties:
```
spring.datasource.username=
spring.datasource.password=

(...)
tmdb.access-token=${TMDB_ACCESS_TOKEN}
```
The first 2 are the database credentials, the last one is the themoviedb.org API key.

## Database
Local database created in PostgreSQL

Prerequisite:
PostgreSQL

To create database:
- Enter ```CREATE DATABASE MovieUniverseHubDB```

## Backend
Java code
Uses Service-Controller architecture (with DTOs)

Prerequisite:
Java

## Frontend
Vite-based React (Node.js)

Prerequisite:
Node.js

- Run command ``` npm install -D vite ``` to ensure vite is available
- Run ```npm create vite@latest MovieUniverseHubFront -- --template react``` to create local instance
The above will create a new folder, so when needing to run it later, enter the new folder and run:
```npm run dev```

## API
Uses API provided by themoviedb.org site for movie information

## AI usage
Mostly guidance in tools where I have low experience with, such as connection between API and backend
