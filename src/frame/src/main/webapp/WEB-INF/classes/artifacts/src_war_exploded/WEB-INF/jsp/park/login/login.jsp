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
                <div class="span12" style="border-style: outset;height: 530px;background-color:#F0F8FF;">
                    <div class="row-fluid" style="height:45px;line-height:45px;">
                        <div class="span12 navbar-inner">
                            <strong>登&nbsp;&nbsp;录</strong>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <form action="/park_login.do" method="post" class="form-horizontal">
                                <table style="margin: 45px auto auto 80px">
                                    <tr>
                                        <td></td>
                                        <td style="text-align: center;">
                                            <!-- 车位管家Logo -->
                                            <img alt="车位管家Logo" style="height: 150px;width: 150px;border:1px solid #000;"
                                                 src="static/login/images/logo.jpg" />
                                            <hr/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputusername">
                                                <span class="add-on"><strong>帐户</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td>
                                            <input type="text" id="inputusername" name="userName" value="${pd.userName}" placeholder="会员/管理员">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputPassword">
                                                <span class="add-on"><strong>密码</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="password" id="inputPassword" name="password" placeholder="密码">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td style="padding-top: 8px;">
                                            <a href="/park_toregister.do">立即注册</a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="/park_retrievePassword.do">忘记密码？</a>
                                        </td>
                                    </tr>
                                    <!-- 错误信息提示 -->
                                    <c:if test="${pd.error != null}">
                                    <tr>
                                        <td></td>
                                        <td style="padding-top: 5px;">
                                            <div class="span12">
                                                <div class="alert">
                                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                                    <strong>警告!&nbsp;&nbsp;</strong>${pd.error}
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    </c:if>
                                    <tr>
                                        <td></td>
                                        <td style="padding-top: 5px;">
                                            <button type="submit" class="btn btn-block" style="width: 218px;">登录</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
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