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

    <!--中部 登录表单-->
    <div class="container-fluid" style="margin: auto auto auto 370px;width: 1400px; ">
        <div class="row-fluid">
            <!--登录表单-->
            <div class="span6"  >
                <div class="span12" style="border-style: outset;height: 500px;background-color:#F0F8FF;">
                    <div class="row-fluid" style="height:45px;line-height:45px;">
                        <div class="span12 navbar-inner">
                            <strong>找&nbsp;回&nbsp;密&nbsp;码</strong>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <table style="margin: 45px auto auto 130px">
                                <tr>
                                    <td>
                                        <!-- 找回密码成功图片 -->
                                        <center>
                                            <img alt="车位管家Logo" style="height: 124px;width: 350px;border:1px;solid:#00B83F;"
                                                 src="static/login/images/retrievePasswordSuccess.PNG" />
                                        </center>
                                        <hr/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <center>
                                            <p class="alert"><strong style="color:#990000;">${pd.userName}</strong>，您找回密码成功，欢迎回到星星停车管家！</p>
                                        </center>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding-top: 35px;">
                                        <center>
                                            <a href="/tologin.do">
                                                <button type="button" class="btn btn-block" style="width:218px;">立即登录</button>
                                            </a>
                                        </center>
                                    </td>
                                </tr>
                            </table>
                        </div>
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