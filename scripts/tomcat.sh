#! /bin/bash

echo "> enable, restart tomcat.service "

systemctl daemon-reload
systemctl enable tomcat.service

cp /app/*.war /usr/local/tomcat/tomcat9/webapps/myapp


systemctl restart tomcat.service
