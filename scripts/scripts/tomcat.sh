#! /bin/bash

echo "> enable, restart tomcat.service "

systemctl daemon-reload
systemctl enable tomcat.service
systemctl restart tomcat.service

