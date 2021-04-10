#! /bin/bash

REPOSITORY=/home/ec2-user/app/test/zip
PROJECT_NAME=Spring-aws-web
WEBREPOSITORY=/usr/local/tomcat/tomcat9/webapps/
CONTAINERREPO=/var/lib/docker/volumes/myvolume/_data/
DOCKERIMAGES=oinia2/aws-spring-web:0.94
COMPOSE_FILE=web.yml
MONITOR_FILE=prometheus.yml
APP_NAME=myapp
MONITOR_NAME=pro

echo "> (외장톰캣사용시)Build 파일 복사 "

sudo cp ${REPOSITORY}/*.war ${WEBREPOSITORY}

echo "> 컨테이너 volume 생성 및 volume 으로 배포 "
sudo docker volume create --name myvolume
sudo chmod -R 775 /var/lib/docker/volumes
sudo cp ${REPOSITORY}/*.war ${CONTAINERREPO}

echo "> docker stack start"
sudo docker stack deploy --compose-file=${REPOSITORY}/${COMPOSE_FILE} ${APP_NAME}
sudo docker stack deploy --compose-file=${REPOSITORY}/${MONITOR_FILE} ${MONITOR_NAME}

#echo "> 현재 구동중인 애플리케이션 pid 확인 "

#CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.war)

#echo ">현재 구동중인 애플리케이션 pid : $CURRENT_PID"

#if [ -z "$CURRENT_PID" ]; then
#	echo ">현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
#else
#	echo "> kill -15 $CURRENT_PID"
#	kill -15 $CURRENT_PID
#	sleep 5
#fi
#	echo "> 새 애플리케이션 배포"
#
#	JAR_NAME=$(ls -t $WEBREPOSITORY/ | grep war | tail -n 1)
#
#	echo "> JAR NAME : $JAR_NAME"
#	
#	nohup java -jar \
#		-Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-uesr/app/application-real-db.properties \
#		-Dspring.profiles.active=real \
#		$JAR_NAME > $REPOSITORY/nohup.out 2>1 &


