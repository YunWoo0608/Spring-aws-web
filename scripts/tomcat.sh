#! /bin/bash

echo "> enable, restart tomcat.service "

systemctl daemon-reload
systemctl enable tomcat.service

cp /app/*.war /usr/local/tomcat/tomcat9/webapps

perl -p -i -e '$.==155 and print "<Context path='"''"' docBase='"'/usr/local/tomcat/tomcat9/webapps/myapp-1.0.0-BUILD-SNAPSHOT'"' reloadable='"'true'"'/>\n"' /usr/local/tomcat/tomcat9/conf/server.xml

systemctl restart tomcat.service
