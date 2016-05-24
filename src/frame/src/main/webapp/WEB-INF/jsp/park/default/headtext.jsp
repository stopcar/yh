<!--防止乱码-->
<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!--session 存入 用户Id 和 用户名-->
<% String userName = (String) session.getAttribute("userName"); %>

<!-- 头部 文件 -->
<title>星星停车管家</title>
<link rel="shortcut icon" href="static/login/images/logo.ico" type="image/x-icon">
<meta name="keywords" content="停车位、车位、停车、分享" />
<meta name="description" content="停车位，为停车车主提供车位分享、车位出租、车位出售" />
<meta name="Copyright" content="徐州工程学院">
<link rel="stylesheet" href="static/login/css/css.css">
<link rel="stylesheet" href="static/login/bootstrap.min.css" />
<script type="text/javascript" src="static/js/jquery-1.5.1.min.js"></script>