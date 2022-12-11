# Dockerfile

## Syntax
Reference: https://docs.docker.com/engine/reference/builder/  

## Build and tag

## From docker-compose
Example: https://github.com/docker/awesome-compose/tree/master/react-express-mysql  

## Production grade
In production, you want to run static sources with a webserver (apache, nginx, ...).  
You could first build and then make a dockerfile that serves the build folder with nginx.  
```bash
npm install
npm run build
# ./build folder is created
docker build --tag bootcamp-chat:serve .
docker run -p 80:80 bootcamp-chat:serve
```

It would be nice to build an image from source in a single command.
```bash
docker build --tag milansan/nexios-demo:chat .
docker push milansan/nexios-demo:chat
docker image rm milansan/nexios-demo:chat
docker run -p 80:80 milansan/nexios-demo:chat
```
