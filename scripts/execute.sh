#! /bin/bash

tomcatRepo=/usr/local/tomcat/tomcat9
fixfile=${tomcatRepo}/webapps/myapp-1.0.0-BUILD-SNAPSHOT/WEB-INF/views/main.jsp

#매개변수 받기(배열로저장)
containerIDs=("$@")

#매개 변수 개수
argsNum=$#
#받은 매개 변수 출력(테스트)
echo $@
echo ${containerIDs[0]}
echo ${containerIDs[1]}

# 받은 개수 만큼 for문으로 명령어 처리
for ((i=0;i<argsNum;i++)); do

        # 컨테이너의 웹 스크립트 제목 수정.(이걸로 워커들 판별)
        sudo docker exec ${containerIDs[$i]} /bin/bash -c ${tomcatRepo}/bin/shutdown.sh
        sudo docker exec ${containerID} /bin/bash -c "sudo cat ${fixfile} | sudo sed s/<title>mom"'"s shopping(worker2)</title>/<title>mom"'"s shopping(${i})</title>/" > ${fixfile}
        # 컨테이너의 톰캣 실행하기(systemd 데몬이 없기 때문에 직접 실행해야함)
        sudo docker exec ${containerIDs[$i]} /bin/bash -c ${tomcatRepo}/bin/startup.sh
        sudo docker exec ${containerIDs} /bin/bash -c "echo 'namesever 8.8.8.8' >> /etc/resolve.conf"
        sudo docker exec ${containerIDs} /bin/bash -c "yum -y install net-tools"

done


