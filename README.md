# Docker bootcamp
## Install Docker
https://docs.docker.com/get-docker/  
https://dockerlabs.collabnix.com/beginners/helloworld/  
```bash
docker run hello-world
docker ps
docker images hello-world
docker run -it ubuntu bash
docker ps
```

## What is Docker
### As a developer
Amazon explains it quite well: https://aws.amazon.com/docker/  
Reproducable, lightweight containers that allows applications to think they're home alone.  
Move from "it works on my machine" to "it works in the container".  

### As a sysadmin
Similar to VMs, but OS layer is shared.  
Deploy applications without any bare metal dependencies.  

## Docker and local development
Tejas Kumar @ BeJS: https://youtu.be/liwC7W-uWnY  
I need a database real quick but don't want to install anything!  
https://hub.docker.com/_/postgres  
```bash
docker run --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword postgres
docker ps
```
How do I connect to it?
```bash
docker exec -it my-postgres bash
psql -d postgres -U postgres
CREATE TABLE IF NOT EXISTS accounts (id serial PRIMARY KEY, username VARCHAR (255) UNIQUE NOT NULL);
INSERT INTO accounts(username) VALUES ('rick'), ('morty') RETURNING *;
```
Where is my data?  
```bash
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -v ./postgres-data:/var/lib/postgresql/data postgres
```
How do we access this from outside container?  
// TODO Write express.js app
