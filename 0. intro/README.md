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

## Network & Ports
```bash
docker run nginx
```
Notice there is a container running and it declares a port, but http://localhost/ does nothing.
```bash
docker run -p 80:80 nginx
```
Suddenly, nginx is accessible from http://localhost/ because we mapped the port to our host

## Volumes