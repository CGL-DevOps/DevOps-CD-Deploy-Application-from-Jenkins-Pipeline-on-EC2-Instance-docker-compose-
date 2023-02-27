#! /bin/bash

export IMAGE=$1

echo "Start running containers!"
docker-compose up -d
echo "Successfully!"