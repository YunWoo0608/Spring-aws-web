FROM centos:7

ENV container docker

RUN yum -y update; yum clean all
RUN yum -y install systemd; yum clean all; \
(cd /lib/systemd/system/sysinit.target.wants/; for i in *; do [ $i == systemd-tmpfiles-setup.service ] || rm -f $i; done); \
rm -f /lib/systemd/system/multi-user.target.wants/*;\
rm -f /etc/systemd/system/*.wants/*;\
rm -f /lib/systemd/system/local-fs.target.wants/*; \
rm -f /lib/systemd/system/sockets.target.wants/*udev*; \
rm -f /lib/systemd/system/sockets.target.wants/*initctl*; \
rm -f /lib/systemd/system/basic.target.wants/*;\
rm -f /lib/systemd/system/anaconda.target.wants/*;

VOLUME ["/sys/fs/cgroup"]
CMD ["/usr/sbin/init"]
VOLUME ["/var/lib/docker/volumes/myvolume/_data/"]
RUN mkdir -p /sys/fs/cgroup
# =========================cgroup setting end================================

#app dir create
RUN mkdir -p /app

WORKDIR /app

RUN yum -y install perl wget java-1.8.0-openjdk java-1.8.0-openjdk-devel
RUN cd /root
RUN wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.44/bin/apache-tomcat-9.0.44.tar.gz
RUN tar -xzvf apache-tomcat-9.0.44.tar.gz
RUN mkdir /usr/local/tomcat
RUN mv apache-tomcat-9.0.44 /usr/local/tomcat/tomcat9
RUN echo "export CTALINA_HOME=/usr/local/tomcat/tomcat9/" >> /root/.bash_profile
RUN echo -e "PATH=$PATH:$JAVA_HOME/bin \n CLASSPATH=$JAVA_HOME/jre/lib:$JAVA_HOME/lib/tools.jar \n export PATH CLASSPATH" >> /root/.bash_profile
RUN source /root/.bash_profile


RUN echo -e "[Unit] \n Description=tomcat9 \n After=network.target syslog.target \n [Service] \n Type=forking \n Environment=JAVA_HOME= /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.282.b08-1.amzn2.0.1.x86_64/jre \n User=root \n Group=root \n ExecStart=/usr/local/tomcat/tomcat9/bin/startup.sh ExecStp=/usr/local/tomcat/tomcat9/bin/shutdown.sh \n UMask=007 \n RestartSec=10 \n Restart=always \n SuccessExitStatus=143 \n [Install]\n WantedBy=multi-user.target" >> /usr/lib/systemd/system/tomcat.service

RUN perl -p -i -e '$.==155 and print "<Context path='"''"' docBase='"'/usr/local/tomcat/tomcat9/webapps/myapp-1.0.0-BUILD-SNAPSHOT'"' reloadable='"'true'"'/>\n"' /usr/local/tomcat/tomcat9/conf/server.xml

RUN systemctl enable  tomcat.service


#EXPOSE 8080
