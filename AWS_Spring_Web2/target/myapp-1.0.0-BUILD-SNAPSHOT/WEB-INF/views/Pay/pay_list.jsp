<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <!-- IE버전을 최신 버전으로 처리하는 부분 -->
    <meta http-equiv="X-UA_Compatible" content="IE=edge">
    <!-- 반응형 웹페이지 처리-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>mom's shopping</title>
	<!-- 아이콘 -->
	<link rel="shortcut icon" href="#">
	
	<!-- jQuery 호출(necessay for Bootstrap's JavaScript Plugins)-->
	<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
    <script src="http://code.jquery.com/jquery-3.5.1.js"></script>
    
	<!--[if it IE 9] IE9이하의 브라우저에서 HTML5 태그(+미디어 쿼리)를 적용시키도록 해주는 부분 -->
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    
    <!--bootstrap에서 사용하는 자바 스크립트 호출-->
    <script src="/js/bootstrap.min.js"></script>
    <!-- 사용자 정의 스크립트 -->
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/kfonts2.css" rel="stylesheet">

    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 사용자 정의 스타일 시트-->
    <link rel="stylesheet" type="text/css"  href="css/main.css" />
  </head>
  <body>
    <div id="root">
      <div id ="header">
        <div role="banner" id="top-banner">
          <img class="img-responsive" src="https://placehold.it/2048x100" alt="top-banner">
        </div><!--top-banner -->
        <div id = "login_pannel" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
 			<!--<h4>로그인/회원가입/고객센터 로그인후 -> 마이페이지/로그아웃/고객센터 , 관리자 로그인 후 -> 관리자페이지/로그아웃</h4>  -->
 			<div id="login_text" class="pull-right" >
 				<% if(session.getAttribute("sID") == null){ %>
 				<a href="<c:url value='login'/>">로그인</a>/<a href="<c:url value='sign_up'/>">회원가입</a>/<a href='#'>고객센터</a>
 				<%}else{ %>
 				<a href="<c:url value='logout'/>">로그아웃</a>/<a href="<c:url value='sign_up?'/>">결제내역보기</a>/<a href='#'>고객센터</a>
 				<%}%>
 			</div>
        </div><!-- login-pannel -->
        <div id ="left_logo" class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
           <a href="<c:url value="/"/>"><img class="img-responsive" src="https://placehold.it/200x100" alt="left-logo"></a>
        </div><!-- left-logo -->
        <div id ="main_search" class="form-inline col-xs-6 col-sm-6 col-md-6 col-lg-6">
          <form role="form" name="main_search" action="" method="get">
            <input type="text" class="form-control" placeholder="검색">
            <input id ="search" type="button" class="btn btn-primary" value="검색" placeholder="검색">
          </form>
        </div><!-- search -->
        <div id="notice" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
          <h4>공지사항</h4>
        </div><!-- notice -->
        <div id="navigation" class="col-xs-8 col-sm-8 col-md-8 col-lg-12 col-push-2">
          <nav style="width:100%">
            <ul class="nav nav-tabs nav-justified">
              <li class="active dropdown">
                <a href="#" data-toggle="dropdown">커피(원두)</a>
                <ul role="menu" class="dropdown-menu nav nav-tabs nav-justified">
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">갓 볶은 원두</a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">드립 원두</a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">디카페인 원두</a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">캡슐 커피</a></li>
                </ul>
                <li class="active dropdown">
                  <a href="#" data-toggle="dropdown">소스</a>
                  <ul role="menu" class="dropdown-menu nav nav-tabs nav-justified">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">갓 볶은 원두</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">드립 원두</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">디카페인 원두</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">캡슐 커피</a></li>
                  </ul>
                </li>
                <li class="active dropdown">
                  <a href="#" data-toggle="dropdown">파우더</a>
                  <ul role="menu" class="dropdown-menu nav nav-tabs nav-justified">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">갓 볶은 원두</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">드립 원두</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">디카페인 원두</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">캡슐 커피</a></li>
                  </ul>
                </li>
            </ul>
          </nav><!-- navigation -->
        </div><!-- navigation -->
      </div><!-- header -->

      <div id="main" class="container-fluid">
      <div id="list" class="col-xs-8 col-sm-8 col-md-8 col-lg-12" align="center" style="padding-top: 50px;">
		<table border="1">
			<tr align="center">
				<th>결제 번호</th>
				<th>결제 상품 번호</th>
				<th>결제 고객 번호</th>
				<th>결제 일자</th>
				<th>결제 금액</th>
				<th>결제 impuid</th>
				<th>결제 merchant</th>
				<th>결제 된 금액</th>
				<th>결제 일련번호</th>
			</tr>
			<c:forEach var="pay" items="${payList}">
				<tr align="center">
					<td>${pay.pay_no}</td>
					<td>${pay.pr_no}</td>
					<td>${pay.c_no}</td>
					<td>${pay.pay_date}</td>
					<td>${pay.pay_price}</td>
					<td>${pay.pay_impuid}</td>
					<td>${pay.pay_merchant}</td>
					<td>${pay.pay_paidamount}</td>
					<td>${pay.pay_applynum}</td>
				</tr>
			</c:forEach>
			</div>
		</table>
      </div> <!--main end -->
    </div><!-- root -->

  </body>
</html>
