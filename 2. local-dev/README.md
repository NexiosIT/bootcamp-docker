# Local development
Tejas Kumar @ BeJS: https://youtu.be/liwC7W-uWnY  
## Postgres
I need a database real quick but don't want to install anything!  
https://hub.docker.com/_/postgres

How do I connect to it?
```bash
docker exec -it db bash
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

## Express.js in action
// TODO Write express.js app
