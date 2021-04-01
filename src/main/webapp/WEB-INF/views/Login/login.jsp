<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- login Page -->
    <title>Log-in</title>

    <!-- css -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="css/animations.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet">
	<link href="color/default.css" rel="stylesheet">
</head>

<body>
<%
//만약에 세션에 ID가 있다면, 로그인 되어 있는 상태이므로 바로 board로 보내 준다.
if((String)session.getAttribute("sID") != null)
{
	pageContext.forward("main.jsp");	
}
%>
    <section id="login" class="home-section nopadd-bot color-dark bg-gray text-center">

    <div class="container marginbot-50">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
          		<div class="animatedParent">
					<div class="section-heading text-center animated bounceInDown">
						<h2 class="h-bold">Log in</h2>
					<div class="divider-header"></div>
					</div>
				</div>
          </div>
		</div>
	</div>

    <!-- 로그인 입력 form -->
		<div class="container">
			<div class="row marginbot-80">
				<div class="col-md-8 col-md-offset-2">
						<form id="contact-form" action=<c:url value="login_do"/>>
							<div class="row marginbot-20">
								<div class="col-md-12 marginbot-20"> <!-- ID 한줄 차지 / PW와 간격 조정-->
                					<!-- ID -->
									<input type="text" class="form-control input-lg" id="sID" name="sID" placeholder="ID" required="required" />
								</div>
								<div class="col-md-12">  <!-- PASSWORD 한줄 차지 -->
                			<!-- PASSWORD -->
								<input type="password" class="form-control input-lg" id="sPW" name="sPW" placeholder="Password" required="required" />
								</div>
							</div>
            			<!--로그인 버튼-->
						<div class="row">
							<div class="col-md-12">
								<button type="submit" class="btn btn-skin btn-lg btn-block" id="btnContactUs" onclick="<c:url value='/login_do'/>">
									Log in</button>
							</div>
						</div>
            <!-- 가입 버튼 -->
            <div class="row">
            <div class="text-right" style="padding: 10px 30px;">
              <a href="#">가입하기</a>
            </div>
            </div>
						</form>
				</div>
			</div>

		</div>
	</section>

  <!-- Core JavaScript Files -->
  <script src="js/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <script src="js/css3-animate-it.js"></script>

</body>

</html>
