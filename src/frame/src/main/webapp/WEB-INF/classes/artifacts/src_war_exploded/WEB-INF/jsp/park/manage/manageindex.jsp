<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- 引入框架文件  头文件  -->
    <%@ include file="../default/headtext.jsp"%>
</head>
<body class="well">
<!--主框架-->
<div class="container-fluid" style="background-color: #ffffff">

    <!-- 引入框架文件  顶部文件  -->
    <%@ include file="../default/toptext.jsp"%>

    <!--中部-->
    <div class="container-fluid">
        <div class="row-fluid">
             <div class="span12" style="border-style: outset; height: 620px; width:350px; background-color:#F0F8FF;
                  margin: 5px auto auto 10px;">
                    <div class="row-fluid" style="height:45px;line-height:45px;">
                       <div class="span12 navbar-inner">
                          <strong>功能导航</strong>
                       </div>
                    </div>
                    <div class="row-fluid">
                       <!--中部 左边 导航区 -->
                       <%@ include file="../manage/manageIndexNavi.jsp"%>
                    </div>
            </div>

            <div class="span6" style="margin: 5px auto auto 5px;">
                <div class="span12" style="border-style: outset;height: 620px; width:1075px;background-color:#F0F8FF; ">
                   <!--中部 右边 操作区 -->
                   <div class="span8">
                      <br><br><br>
                      <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;管理中心，欢迎您！</h1>
                      <h3>
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          星星停车管家，让您的出行一步到位！
                      </h3>
                   </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 引入框架文件  底部文件  -->
    <%@ include file="../default/banner.jsp"%>

</div>
<script src="static/js/jquery-1.7.2.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>