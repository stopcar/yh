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
                <div class="span12" style="border-style: outset;height: 530px;background-color:#F0F8FF;">
                    <div class="row-fluid" style="height:45px;line-height:45px;">
                        <div class="span12 navbar-inner">
                            <strong>找&nbsp;回&nbsp;密&nbsp;码</strong>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <form action="/park_retrievePasswordTwo.do" method="post" class="form-horizontal">
                                <table style="margin: 35px auto auto 80px;">
                                    <tr>
                                        <td>
                                            <!-- 车位管家Logo -->
                                            <img alt="车位管家Logo"
                                                 style="height: 100px;width: 100px;border:1px solid #000;margin: auto auto 45px 40px; "
                                                 src="static/login/images/logo.jpg" />
                                        </td>
                                        <td style="text-align: center;">
                                            <h3>找回密码，步骤二</h3>
                                            <h5 style="color: #990000">（输入密保问题对应的答案，验证用户身份）</h5>
                                            <hr/>
                                        </td>
                                    </tr>
                                    <!-- 密保问题一 -->
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputuserQuestionone">
                                                <span class="add-on"><strong>密保问题一</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="hidden" name="userName" value="${pd.userName}" >
                                            <input type="text" readonly="true" id="inputuserQuestionone" name="userQuestionone" value="${pd.userQuestionone}" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputuserQuestiononeans">
                                                <span class="add-on"><strong>答案</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="text" id="inputuserQuestiononeans" name="userQuestiononeans" value="${pd.userQuestiononeans}" placeholder="问题一答案">
                                            <span style="color:red;font-size: 20px;">*</span>
                                        </td>
                                    </tr>
                                    <!-- 密保问题二 -->
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputuserQuestiontwo">
                                                <span class="add-on"><strong>密保问题二</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="text" readonly="true" id="inputuserQuestiontwo" name="userQuestiontwo" value="${pd.userQuestiontwo}" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label class="control-label" for="inputuserQuestiontwoans">
                                                <span class="add-on"><strong>答案</strong>&nbsp;&nbsp;&nbsp;</span>
                                            </label>
                                        </td>
                                        <td style="padding-top: 10px;">
                                            <input type="text" id="inputuserQuestiontwoans" name="userQuestiontwoans" value="${pd.userQuestiontwoans}" placeholder="问题二答案">
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
                                            <button type="submit" class="btn btn-block" style="width: 218px;">下一步</button>
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