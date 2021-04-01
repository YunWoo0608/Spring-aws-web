#! /bin/bash

REPOSITORY=/app
WEBREPOSITORY=/usr/local/tomcat/tomcat9/webapps

echo "> Build 파일 복사 "

sudo cp $REPOSITORY/*.war $WEBREPOSITORY

