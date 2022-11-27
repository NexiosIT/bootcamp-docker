# Docker bootcamp
## Install Docker
https://docs.docker.com/get-docker/  
Make sure everyone can run `docker run hello-world`

## What is Docker
Amazon: https://aws.amazon.com/docker/  
### As a developer
Reproducable, lightweight containers that allows applications to think they're home alone.  
Move from "it works on my machine" to "it works in the container".  
### As a sysadmin
Similar to VMs, but OS layer is shared.  
Deploy applications without any bare metal dependencies.  

## Images and containers
https://dockerlabs.collabnix.com/beginners/helloworld/  
```bash
docker run hello-world
docker run -it --name my-ubuntu ubuntu bash
docker ps
docker images hello-world
```
Make sure everyone can run docker commands without sudo.  
Then explain difference between images and containers.  
Containers can have state, the container that just ran hello-world still exists but isn't running.  
Using man, explain the -i and -t options, along with running containers and passing commands.  
Notice containers persist after shutdown and using the same name prevents a second run command.  
--rm deletes after close and allows for easy retry, but loses container persistence.  

## Ports
```bash
docker run nginx -d
```
Notice there is a container running and it declares a port, but http://localhost/ does nothing.  
We're running in detached mode, since we don't need a constant feed on logs.  
And even then, you can use `docker logs`.  
```bash
docker run -p 80:80 nginx
```
Suddenly, nginx is accessible from http://localhost/ because we mapped the port to our host.  
We can choose a different port, e.g. `-p 1234:80`.  

## Networks
Mapping ports to the host is not very secure.  
Containers can talk to each other if they're on the same network.  
```bash
docker network create my-network
docker run --rm --name my-nginx --network my-network -d nginx
docker network inspect my-network
docker run --network my-network alpine/curl http://my-nginx/
```
Similar to `hello-world` some containers have entrypoints that just run a command and exit.  
Note that name resolution only works with explicitly named containers.  

## Volumes
That's all fine, but how do I change the content?  
```bash
mkdir nginx-content
nano nginx-content/index.html
docker run -p 80:80 -v $(pwd)/nginx-content:/usr/share/nginx/html -d nginx
```
```html
<html>
<body>
  <h1>Hello World!</h1>
</body>
</html>
```
You can also work with volumes. Like folders, but managed by docker.  
```bash
docker volume create my-volume
docker run -it -v my-volume:/my-volume ubuntu bash
echo "<html><body><h1>Hello from my-volume</h1></body></html>" > /my-volume/index.html
docker run -p 80:80 -v my-volume:/usr/share/nginx/html -d nginx
```
A bit harder to work with manually but very good for sharing data between containers.  
