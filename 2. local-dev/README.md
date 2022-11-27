# Local development
Tejas Kumar @ BeJS: https://youtu.be/liwC7W-uWnY  
## Postgres
I need a database real quick but don't want to install anything!  
https://hub.docker.com/_/postgres  
```bash
docker run --name my-postgres --rm -e POSTGRES_PASSWORD=mysecretpassword postgres
docker ps
```

How do I connect to it?
```bash
docker exec -it my-postgres bash
psql -d postgres -U postgres
```
```sql
CREATE TABLE IF NOT EXISTS accounts (
    id serial PRIMARY KEY,
    username VARCHAR (255) UNIQUE NOT NULL
);
INSERT INTO accounts(username)
VALUES ('rick'), ('morty')
RETURNING *;
```

Where is my data?  
```bash
docker run --name my-postgres --rm -e POSTGRES_PASSWORD=mysecretpassword -v /tmp/postgres-data:/var/lib/postgresql/data postgres
```

## Network
How do we access this from outside container?  
FIRST! docker-compose, because these commands are getting too long
```bash
docker run --name my-postgres --rm -e POSTGRES_PASSWORD=mysecretpassword -v ./postgres-data:/var/lib/postgresql/data -p 5432:5432 postgres
```

## Express.js in action
// TODO Write express.js app
