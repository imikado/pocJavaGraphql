#!/bin/bash
# Run the container with source mounted for development
docker run -p 8080:8080 \
  -v "$(pwd)":/app \
  -v poc-java-graphql-m2:/root/.m2 \
  poc-java-graphql
