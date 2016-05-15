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

    <!--中部 百度地图 最新车位-->
    <div class="container-fluid " style="margin: 0.5em auto 0.5em auto;">
        <div class="row-fluid">
            <div class="span12" style="height: 450px;width: 1000px;border-style: outset;">
                <!--百度地图 start-->
                <img alt="1000x450" style="height: 450px;width: 1000px;"
                     src="static/login/images/indextop.png" />
                <!--百度地图 end -->
            </div>
            <div class="span12" style="height: 450px;width: 430px;border-style: outset;background-color:#F0F8FF;">
                <div class="row-fluid" style="height:45px;line-height:45px;">
                    <div class="span12 navbar-inner">
                        <strong>最新发布车位</strong>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>产品</th>
                            <th>交付时间</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td><a href="/tologin.do">TB - Monthly</a></td>
                            <td>01/04/2012</td>
                            <td>Default</td>
                        </tr>
                        <tr class="success">
                            <td>1</td>
                            <td><a href="/tologin.do">TB - Monthly</a></td>
                            <td>01/04/2012</td>
                            <td>Approved</td>
                        </tr>
                        <tr class="error">
                            <td>2</td>
                            <td><a href="/tologin.do">TB - Monthly</a></td>
                            <td>02/04/2012</td>
                            <td>Declined</td>
                        </tr>
                        <tr class="warning">
                            <td>3</td>
                            <td><a href="/tologin.do">TB - Monthly</a></td>
                            <td>03/04/2012</td>
                            <td>Pending</td>
                        </tr>
                        <tr class="info">
                            <td>4</td>
                            <td><a href="/tologin.do">TB - Monthly</a></td>
                            <td>04/04/2012</td>
                            <td>Call in to confirm</td>
                        </tr>
                        <tr class="info">
                            <td>4</td>
                            <td><a href="/tologin.do">TB - Monthly</a></td>
                            <td>04/04/2012</td>
                            <td>Call in to confirm</td>
                        </tr>
                        </tbody>
                    </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--中部 最新预约 和 车位分类列表 和 最新评价区-->
    <div class="container-fluid">
        <div class="row-fluid">
            <!--最新预约-->
            <div class="span2">
              <div class="span12" style="border-style: outset; height: 500px;background-color:#F0F8FF;">
                <div class="row-fluid" style="height:45px;line-height:45px;">
                    <div class="span12 navbar-inner">
                        <strong>最新预约</strong>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span12">

                    </div>
                </div>
              </div>
            </div>
            <!--车位信息列表  可以查询、结果直接返回去功能列表页面-->
            <div class="span6">
                <div class="span12" style="border-style: outset;height: 500px;background-color:#F0F8FF;">
                    <div class="row-fluid" style="height:45px;line-height:45px;">
                        <div class="span12 navbar-inner">
                            <strong>车位信息列表</strong>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">

                        </div>
                    </div>
                </div>
            </div>
            <!--最新评价区-->
            <div class="span4">
                <div class="span12" style="border-style: outset;height: 500px;background-color:#F0F8FF;">
                    <div class="row-fluid" style="height:45px;line-height:45px;">
                        <div class="span12 navbar-inner">
                            <strong>最新评价区</strong>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">

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