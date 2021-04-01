#! /bin/bash

REPOSITORY=/app
WEBREPOSITORY=/usr/local/tomcat/tomcat9/webapps
CONTAINER_NAME=test2

echo "> docker command start"
sudo docker exec ${CONTAINER_NAME} /bin/bash -c "cp /app/*.war /usr/local/tomcat/tomcat9/webapps/ && /app/tomcat.sh"

