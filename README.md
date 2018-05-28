# urlshortener
API to create your own URL Shortener

Container docker : localhost:8182. 


- localhost:8182/all (all urls in database)
- using Postman or other, localhost:8182, HTTP Request type PUT, body the long url to shorten.
- localhost:8182/331e5b6b 331e5b6b is the shorten url to https://www.google.com, this request will redirect to the url
- localhost:8182/getCountAcesses/331e5b6b how many times this shorten url was acessed

# Docker

Docker container or image names can be changed inside DockerFile or docker-compose.yml

Docker compose is used to create mongodb container before the api container.


Next steps 

1 - create tests
2 - build front-end
3 - more statistics
