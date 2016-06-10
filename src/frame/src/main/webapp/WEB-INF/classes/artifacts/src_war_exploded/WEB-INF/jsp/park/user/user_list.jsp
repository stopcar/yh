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
                <div class="span12" style="border-style: outset;height: 800px; width:1075px;background-color:#F0F8FF; ">
                    <!--中部 右边 操作区 -->
                    <div class="span8">
                        <table style="width:100%;">
                            <tr>
                                <td style="vertical-align:top;">
                                    <!-- 查询 -->
                                    <div>
                                        <form action="/park_selectUserInfoby.do" method="post" >
                                            <div style="float:left">
                                                &nbsp;&nbsp;&nbsp;&nbsp;<strong>用户名</strong>
                                                &nbsp;&nbsp;<input type="text" id="inputusername" name="userName" value="${pd.userName}" >
                                                &nbsp;&nbsp;<strong>帐户身份</strong>
                                                &nbsp;&nbsp;<select name="Identity">
                                                <option value="0">管理员</option>
                                                <option value="1">用户</option>
                                            </select>
                                                &nbsp;&nbsp;<button type="submit" style="width: 100px;">查询</button>
                                            </div>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <table id="table_report" class="table table-striped table-bordered table-hover" style="width: 1065px; table-layout: fixed;" align="center" >
                            <thead>
                            <tr>
                                <th style="width: 25px ">用户ID</th>
                                <th style="width: 20px ">用户名</th>
                                <th style="width: 15px ">性别</th>
                                <th style="width: 30px ">注册时间</th>
                                <th style="width: 25px ">qq</th>
                                <th style="width: 30px ">手机</th>
                                <th style="width: 25px ">身份</th>
                                <th style="width: 36px ">帐户状态</th>
                                <th style="width: 60px ">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <!-- 开始循环 -->
                            <c:choose>
                                <c:when test="${not empty userInfoList}">
                                    <c:forEach items="${userInfoList}" var="user" varStatus="vs">
                                        <tr>
                                            <td>${user.userID}</td>
                                            <td>${user.userName}</td>
                                            <td>${user.gender}</td>
                                            <td>${user.registrationTime}</td>
                                            <td>${user.qq}</td>
                                            <td>${user.mobilePhon}</td>
                                            <td>
                                                <c:if test="${user.Identity == 0}">
                                                    管理员
                                                </c:if>
                                                <c:if test="${user.Identity == 1}">
                                                    用户
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${user.accountStatus == 1}">
                                                    正常
                                                </c:if>
                                                <c:if test="${user.accountStatus == 2}">
                                                    黑名单
                                                </c:if>
                                            </td>
                                            <td>
                                                <a href="/park_toeditUserInfo.do?userID=${user.userID}">修改</a>
                                                &nbsp;&nbsp;&nbsp;
                                                <a href="/park_delUserInfo.do?userID=${user.userID}">删除</a>
                                                &nbsp;&nbsp;&nbsp;
                                                <c:if test="${user.accountStatus == 1}">
                                                    <a href="/park_editUserInfostutas.do?userID=${user.userID}&accountStatus=2">加入黑名单</a>
                                                </c:if>
                                                <c:if test="${user.accountStatus == 2}">
                                                    <a href="/park_editUserInfostutas.do?userID=${user.userID}&accountStatus=1">取消黑名单</a>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr class="main_info">
                                        <td colspan="10" class="center"><center>没有相关数据</center></td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
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