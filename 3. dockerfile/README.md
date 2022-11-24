# Dockerfile

## Syntax
Reference: https://docs.docker.com/engine/reference/builder/  

## Build and tag

## From docker-compose
Example: https://github.com/docker/awesome-compose/tree/master/react-express-mysql  

## Production grade
In production you want to run static sources with a webserver (apache, nginx, ...).  
You could first build and then make a dockerfile that serves the build folder with nginx.  
```bash
npm install
npm run build
# ./build folder is created
docker build .
```
```Dockerfile
FROM nginx
# Nginx serves files in this directory
WORKDIR /usr/share/nginx/html
# Remove example files
RUN rm -rf ./*
COPY build .
ENTRYPOINT ["nginx", "-g", "daemon off;"]
```

It would be nice to build an image from source in a single command.  
```Dockerfile
# Stage 1 - Build
FROM node AS builder
WORKDIR /app
COPY package.json ./
RUN npm install 
COPY . ./
RUN npm run build
#######################################
# Stage 2 - Serve
FROM nginx
WORKDIR /usr/share/nginx/html
RUN rm -rf ./*
COPY --from=builder /app/build .
ENTRYPOINT ["nginx", "-g", "daemon off;"]
```
