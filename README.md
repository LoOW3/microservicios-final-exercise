# Shopping Cart API using Microservices

This project implements a shopping cart API using Spring Cloud and Docker. It follows a microservices architecture where different services communicate with each other to provide a seamless and scalable shopping experience. The services are containerized using Docker, allowing for easy deployment and management in various environments.

## Features:
- **Microservices-based**: Each component (e.g., cart service, product service, user service) runs as an independent microservice.
- **Spring Cloud**: Leverages Spring Cloud for service discovery, configuration management, and fault tolerance.
- **Dockerized**: All services are packaged in Docker containers, enabling smooth deployment across different platforms.
- **Scalable**: Designed for scalability, allowing easy scaling of individual services based on demand.

To run this project, make sure you clean and build each microservice. 
According to the Dockerfile in each microservice, the executable should be in the subdirectory `target/<exec>.jar`. 

## Basic Postman collection
```
https://www.postman.com/red-crescent-459062/workspace/public-loow3/collection/33468733-816f6c09-23c3-4ae4-b39a-c29cbf54b4f0?action=share&creator=33468733
```
