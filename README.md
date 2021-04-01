# Spring-aws-web

#Travis CI 사용 

[![Build Status](https://travis-ci.com/YunWooCheoi/Spring-aws-web.svg?branch=master)](https://travis-ci.com/YunWooCheoi/Spring-aws-web)

개발 환경 : Window, Linux </br>
개발 툴 : Eclipse, Travis CI/CD, Git </br>
개발 프레임워크 : Spring FrameWork </br>
사용언어 : java, jsp, javaScript, jQuery </br>
DB :  MySQL 

# 상세 설명 

 해당 웹 서비스는 결제 기능이 있는 간단한 사이트입니다. Spring 기반으로 MySQL과 연동하여 사용자의 정보, 상품 정보, 결제 정보를 담고 있습니다. 결제 모듈은 '이니시스' 입니다. 결제 후 오른쪽 상단의 결제 리스트에서 결제 된 항목들을 볼 수 있습니다.
 
 해당 코드들은 AWS에 연동되어 배포됩니다. Travis와 git , AWS codeDploy로 연동해서 배포 및 실행하고 있습니다. 
 
 Spring 프로젝트를 travis에서 maven으로 build 해서 배포하고 외장 톰캣으로 war 파일로 실행됩니다. 해당 과정은 스크립트와 함꼐 git에 push 됨과 동시에 travis에서 build 되어 AWS s3에 배포 되고 s3에서 ec2로 다시 배포되어 ec2의 톰캣에서 실행되게 됩니다. 
 
 # AWS 연동된 EC2 주소(점검중 : 도커로 )
 
http://ec2-3-36-238-141.ap-northeast-2.compute.amazonaws.com:8080/

# 구현 기능

1. 로그인/로그아웃
2. 상품 리스트 나열
3. 결제 기능 구현.

# 로그인 기능 [ 오른쪽 상단의 로그인 선택 ]

![image](https://user-images.githubusercontent.com/56060421/112716315-f366da80-8f28-11eb-8423-f96644149cad.png)

# 로그 아웃 기능

![image](https://user-images.githubusercontent.com/56060421/112716494-1cd43600-8f2a-11eb-8d32-300db3057de4.png)

![image](https://user-images.githubusercontent.com/56060421/112716512-2bbae880-8f2a-11eb-8245-c00d15edd1a9.png)


# 메인 화면 [ 상품 리스트 중에 "테스트" 선택 ]

![image](https://user-images.githubusercontent.com/56060421/112716299-dcc08380-8f28-11eb-8e80-76cc95a2d076.png)


# 상품 상세 페이지 

![image](https://user-images.githubusercontent.com/56060421/112716366-5193bd80-8f29-11eb-9e5f-e0cac8832779.png)

# 상품 결제 기능 

![image](https://user-images.githubusercontent.com/56060421/112716443-dc74b800-8f29-11eb-911e-771b5086c63f.png)

# 결제 리스트 확인

![image](https://user-images.githubusercontent.com/56060421/112716462-f615ff80-8f29-11eb-915f-cf3cfbf9ae29.png)

# 예외 처리 [ 로그인 권한이 있어야 하는 기능들에 접근할 시 eg)결제 버튼 누를시 로그인 화면으로 돌아감.]

![image](https://user-images.githubusercontent.com/56060421/112716544-5c028700-8f2a-11eb-96af-6e25a7fe967f.png)

![image](https://user-images.githubusercontent.com/56060421/112716548-602ea480-8f2a-11eb-8e19-586adb25237f.png)

