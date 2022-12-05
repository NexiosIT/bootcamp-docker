# docker-compose
Complex docker setup can turn into multiple very long commands.  
```bash
docker network create my-network
docker volume create nginx-data
docker volume create postgres-data
docker run --name nginx -v nginx-data:/usr/share/nginx/html -p 80:80 --network my-network -d nginx
docker run --name db -e POSTGRES_PASSWORD=mysecretpassword -v postgres-data:/var/lib/postgresql/data -p 5432:5432 --network my-network -d postgres
```
```yaml
version: '3.8'
services:
  webserver:
    image: nginx
    container_name: nginx
    volumes:
        - "nginx-data:/usr/share/nginx/html"
    ports:
      - "80:80"
    networks:
      - "my-network"

  database:
    image: postgres
    container_name: db
    environment:
      POSTGRES_PASSWORD: mysecretpassword
    volumes:
      - "postgres-data:/var/lib/postgresql/data"
    ports:
      - "5432:5432"
    networks:
      - "my-network"

volumes:
  nginx-data:
  postgres-data:

networks:
  my-network:
```
```bash
docker-compose up
```
