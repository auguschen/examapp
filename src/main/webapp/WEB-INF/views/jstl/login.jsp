<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>

<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6"><h1>登录页面----${message }</h1></div>
    <div class="col-md-3"></div>
  </div>
	<div class="row">
	  <div class="col-md-3"></div>
	  <div class="col-md-3">用户</div>
	  <div class="col-md-3">密码</div>
	  <div class="col-md-3"></div>
	</div>
	<form action="${pageContext.servletContext.contextPath }/login" method="post">
	<div class="row">
	  <div class="col-md-3"></div>
	  <div class="col-md-3"><input type="text" name="username" placeholder="input nser name here." /></div>
	  <div class="col-md-3"><input type="password" name="password" placeholder="input user password here." /></div>
	  <div class="col-md-3"></div>
	</div>
	<div class="row">
	  <div class="col-md-3"></div>
	  <div class="col-md-3"><input type="submit" value="登陆" /></div>
	  <div class="col-md-3"><input type="reset" value="重置" /></div>
	  <div class="col-md-3"></div>
	</div>
	</form>
</div>    
<script src="//cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>