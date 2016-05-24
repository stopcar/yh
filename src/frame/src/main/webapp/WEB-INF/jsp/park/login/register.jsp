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
    <div class="container-fluid" style="margin: auto auto auto 370px;width: 1400px;">
        <div class="row-fluid">
            <!--登录表单-->
            <div class="span6"  >
                <div class="span12" style="border-style: outset;height: 950px;background-color:#F0F8FF;">
                    <div class="row-fluid" style="height:45px;line-height:45px;">
                        <div class="span12 navbar-inner">
                            <strong>注&nbsp;&nbsp;册</strong>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <form action="/park_register.do" method="post" class="form-horizontal">
                                <table style="margin: 45px auto auto 80px;">
                                    <tr>
                                        <td>
                                            <!-- 车位管家Logo -->
                                            <img alt="车位管家Logo"
                                                 style="height: 100px;width: 100px;border:1px solid #000;margin: auto auto 45px 40px; "
                                                 src="static/login/images/logo.jpg" />
                                        </td>
                                        <td style="text-align: center;">
                                            <h3>欢迎注册星星停车管家！</h3>
                                            <h5 style="color: #990000">（为了更好的为您服务，请认真填写相关信息）</h5>
                                            <hr/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputusername">
                                                <span class="add-on"><strong>用户名</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td>
                                            <input type="text" id="inputusername" name="userName" value="${pd.userName}" placeholder="亲、好记才是重点">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputPassword">
                                                <span class="add-on"><strong>密码</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="password" id="inputPassword" name="password" value="${pd.password}" placeholder="密码">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputenterpassword">
                                                <span class="add-on"><strong>确认密码</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="password" id="inputenterpassword" name="enterpassword" value="${pd.enterpassword}" placeholder="确认密码">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputgender">
                                                <span class="add-on"><strong>性别</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="text" id="inputgender" name="gender" value="${pd.gender}" placeholder="男/女">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputqqnum">
                                                <span class="add-on"><strong>QQ</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="number" id="inputqqnum" name="qq" value="${pd.qq}" placeholder="QQ号">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputweiXin">
                                                <span class="add-on"><strong>微信</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="text" id="inputweiXin" name="weiXin" value="${pd.weiXin}" placeholder="微信号">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputmobilePhon">
                                                <span class="add-on"><strong>手机</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="number" id="inputmobilePhon" name="mobilePhon" value="${pd.mobilePhon}" placeholder="手机号">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputemailBox">
                                                <span class="add-on"><strong>邮箱</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="email" id="inputemailBox" name="emailBox" value="${pd.emailBox}" placeholder="常用邮箱">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <hr/>
                                            <h4 style="color:#00B83F">请记好答案，方便您找回密码！</h4>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputuserQuestionone">
                                                <span class="add-on"><strong>密保问题一</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 15px;">
                                            <input type="text" id="inputuserQuestionone" name="userQuestionone" value="${pd.userQuestionone}" placeholder="问题">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputuserQuestiononeans">
                                                <span class="add-on"><strong>答案</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="text" id="inputuserQuestiononeans" name="userQuestiononeans" value="${pd.userQuestiononeans}" placeholder="答案">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputuserQuestiontwo">
                                                <span class="add-on"><strong>密保问题二</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="text" id="inputuserQuestiontwo" name="userQuestiontwo" value="${pd.userQuestiontwo}" placeholder="问题">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputuserQuestiontwoans">
                                                <span class="add-on"><strong>答案</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="text" id="inputuserQuestiontwoans" name="userQuestiontwoans" value="${pd.userQuestiontwoans}" placeholder="答案">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>

                                    <!-- 错误信息提示 -->
                                    <c:if test="${pd.error != null}">
                                    <tr>
                                        <td></td>
                                        <td>
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
                                        <td style="padding-top: 20px;">
                                            <button type="submit" class="btn btn-block" style="width: 218px;">立即注册</button>
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