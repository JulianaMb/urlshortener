# urlshortener
API to create your own URL Shortener

Container docker : localhost:8182. 


- localhost:8182/all (all urls in database)
- using Postman or other, localhost:8182, HTTP Request type PUT. In Request body inform the long url to shorten.
- localhost:8182/331e5b6b 331e5b6b is the shorten url to https://www.google.com, this request will redirect to the url
- localhost:8182/getCountAcesses/331e5b6b how many times this shorten url was acessed

# Docker

Docker container or image names can be changed inside DockerFile or docker-compose.yml

docker-compose is used to create mongodb container before the api container.

The base image to create mongodb container is the official mongo found in Docker Hub
The base image to create urlshortener container is openjdk:8-alpine

If a container for mongo already exists, change the name in the dbsettings string on Dockerfile, some changes may be necessary in docker-compose too.


# Project Next steps 

1. Create tests
2. Build front end
3. More statistics
