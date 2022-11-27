# docker-compose
Complex docker setup can turn into multiple very long commands.  
```yaml
version: '3.1'
services:
  my-postgres:
    image: postgres
    environment:
      POSTGRES_PASSWORD: mysecretpassword
    volumes:
        - "./postgres-data:/var/lib/postgresql/data"
```
```bash
docker-compose up
```
