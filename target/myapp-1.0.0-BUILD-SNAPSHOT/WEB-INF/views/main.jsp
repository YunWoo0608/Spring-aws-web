<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <!-- IE������ �ֽ� �������� ó���ϴ� �κ� -->
    <meta http-equiv="X-UA_Compatible" content="IE=edge">
    <!-- ������ �������� ó��-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>mom's shopping</title>
	<!-- ������ -->
	<link rel="shortcut icon" href="#">
	
	<!-- jQuery ȣ��(necessay for Bootstrap's JavaScript Plugins)-->
	<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
    <script src="http://code.jquery.com/jquery-3.5.1.js"></script>
    
	<!--[if it IE 9] IE9������ ���������� HTML5 �±�(+�̵�� ����)�� �����Ű���� ���ִ� �κ� -->
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    
    <!--bootstrap���� ����ϴ� �ڹ� ��ũ��Ʈ ȣ��-->
    <script src="/js/bootstrap.min.js"></script>
    <!-- ����� ���� ��ũ��Ʈ -->
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/kfonts2.css" rel="stylesheet">

    <!-- �������� �ּ�ȭ�� �ֽ� CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- ����� ���� ��Ÿ�� ��Ʈ-->
    <link rel="stylesheet" type="text/css"  href="css/main.css" />
  </head>
  <body>
    <div id="root">
      <div id ="header">
        <div role="banner" id="top-banner">
          <img class="img-responsive" src="https://placehold.it/2048x100" alt="top-banner">
        </div><!--top-banner -->
        <div id = "login_pannel" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
 			<!--<h4>�α���/ȸ������/�������� �α����� -> ����������/�α׾ƿ�/�������� , ������ �α��� �� -> ������������/�α׾ƿ�</h4>  -->
 			<div id="login_text" class="pull-right" >
 				<% if(session.getAttribute("sID") == null){ %>
 				<a href="<c:url value='login'/>">�α���</a>/<a href="<c:url value='sign_up'/>">ȸ������</a>/<a href='#'>��������</a>
 				<%}else{ %>
 				<a href="<c:url value='logout'/>">�α׾ƿ�</a>/<a href="<c:url value='pay_list'/>">������������</a>/<a href='#'>��������</a>
 				<%}%>
 			</div>
        </div><!-- login-pannel -->
        <div id ="left_logo" class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
          <a href="<c:url value="/"/>"><img class="img-responsive" src="https://placehold.it/200x100" alt="left-logo"></a>
        </div><!-- left-logo -->
        <div id ="main_search" class="form-inline col-xs-6 col-sm-6 col-md-6 col-lg-6">
          <form role="form" name="main_search" action="" method="get">
            <input type="text" class="form-control" placeholder="�˻�">
            <input id ="search" type="button" class="btn btn-primary" value="�˻�" placeholder="�˻�">
          </form>
        </div><!-- search -->
        <div id="notice" class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
          <h4>��������</h4>
        </div><!-- notice -->
        <div id="navigation" class="col-xs-12 col-sm-8 col-md-8 col-lg-12 col-push-2">
          <nav style="width:100%">
            <ul class="nav nav-tabs nav-justified">
              <li class="active dropdown">
                <a href="#" data-toggle="dropdown">Ŀ��(����)</a>
                <ul role="menu" class="dropdown-menu nav nav-tabs nav-justified">
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">�� ���� ����</a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">�帳 ����</a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">��ī���� ����</a></li>
                  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ĸ�� Ŀ��</a></li>
                </ul>
                <li class="active dropdown">
                  <a href="#" data-toggle="dropdown">�ҽ�</a>
                  <ul role="menu" class="dropdown-menu nav nav-tabs nav-justified">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">�� ���� ����</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">�帳 ����</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">��ī���� ����</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ĸ�� Ŀ��</a></li>
                  </ul>
                </li>
                <li class="active dropdown">
                  <a href="#" data-toggle="dropdown">�Ŀ��</a>
                  <ul role="menu" class="dropdown-menu nav nav-tabs nav-justified">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">�� ���� ����</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">�帳 ����</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">��ī���� ����</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ĸ�� Ŀ��</a></li>
                  </ul>
                </li>
            </ul>
          </nav><!-- navigation -->
        </div><!-- navigation -->
      </div><!-- header -->

      <div id="main" class="container-fluid">
      	  <div id="main_banner" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
          <div><a href="#"><img class="img-responsive"src="https://placehold.it/2048x400" alt=""></a></div>
        </div>
        <!-- �󿵿� (col-push-2�� �ȸ���) -->
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
        <div id="main_page" class="col-xs-8 col-sm-8 col-md-8 col-lg-8 col-push-2">
          <!-- ����Ʈ ��ǰ ĭ -->
          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <h4 class="main_sell">����Ʈ ��ǰ</h4>
            <hr>
            <div class="sell_sector">
            <c:forEach var="product" items="${prolist}">
              <div class="col-xs-4 col-sm-4 col-md-2 col-lg-2">
              <a href="<c:url value="/product_detail?pr_no=${product.pr_no}"/>"><img class="img-responsive" src="https://placehold.it/150x150"></a>
              <span>${product.pr_name}</span></div>
             </c:forEach>
              <div class="col-xs-4 col-sm-4 col-md-2 col-lg-2"><img class="img-responsive" src="https://placehold.it/150x150">
              <span>����</span></div>
            </div>
          </div>
          <!-- ���� ��ǰ ĭ -->
          <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <h4 class="main_sell">���� ��ǰ</h4>
            <hr>
            <div class="sell_sector">
              <div class="col-xs-4 col-sm-4 col-md-2 col-lg-2"><img class="img-responsive" src="https://placehold.it/150x150">
              <span>����</span></div>
              <div class="col-xs-4 col-sm-4 col-md-2 col-lg-2"><img class="img-responsive" src="https://placehold.it/150x150">
              <span>����</span></div>
            </div> <!-- sell_sector : ��ǰ �Ǹ� ĭ -->
          </div> <!-- ��ǰ �Ǹ�ĭ ��ü ���� div -->
        </div> <!--main_page end -->
      </div> <!--main end -->
    </div><!-- root -->

  </body>
</html>