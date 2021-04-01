#! /bin/bash

REPOSITORY=/app
WEBREPOSITORY=/usr/local/tomcat/tomcat9/webapps

echo "> docker command start"
sudo docker exec -it test2 /bin/bash -c "mv /app/*.war /usr/local/tomcat/tomcat9/webapps/ && /app/tomcat.sh"

