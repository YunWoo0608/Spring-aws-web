#! /bin/bash

REPOSITORY=/home/ec2-user/app/test/zip
PROJECT_NAME=Spring-aws-web
WEBREPOSITORY=/usr/local/tomcat/tomcat9/webapps
CONTAINERREPO=/var/lib/docker/volumes/myvolume/_data/

echo "> Build 파일 복사 "

sudo cp $REPOSITORY/*.war $WEBREPOSITORY

echo "> 컨테이너 내부로 재배포 "
sudo cp $REPOSITORY/*.war $CONTAINERREPO
sudo cp $REPOSITORY/tomcat.sh $CONTAINERREPO

echo "> Docker Scripts Start"
sudo REPOSITORY/con_deploy.sh

echo "> 현재 구동중인 애플리케이션 pid 확인 "

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.war)

echo ">현재 구동중인 애플리케이션 pid : $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
	echo ">현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
	echo "> kill -15 $CURRENT_PID"
	kill -15 $CURRENT_PID
	sleep 5
fi
	echo "> 새 애플리케이션 배포"

	JAR_NAME=$(ls -t $WEBREPOSITORY/ | grep war | tail -n 1)

	echo "> JAR NAME : $JAR_NAME"
	
	nohup java -jar \
		-Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-uesr/app/application-real-db.properties \
		-Dspring.profiles.active=real \
		$JAR_NAME > $REPOSITORY/nohup.out 2>1 &


