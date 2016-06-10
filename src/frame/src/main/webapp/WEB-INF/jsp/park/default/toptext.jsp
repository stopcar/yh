<!--防止乱码-->
<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!--顶部 文件-->
<div class="row-fluid" style="margin: 0px auto auto auto;">
    <div class="span12">
        <div class="navbar" style="margin: 0px auto auto auto;">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></a>
                    <a href="/toindex.do" class="brand">
                        <strong>星星停车管家</strong>
                    </a>
                    <div class="nav-collapse collapse navbar-responsive-collapse">
                        <ul class="nav">
                            <li class="active">
                                <a href="/toindex.do"><strong>首页</strong></a>
                            </li>
                            <li class="dropdown">
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                    <strong>临时车位</strong><strong class="caret"></strong></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">临时免费车位</a>
                                    </li>
                                    <li>
                                        <a href="#">临时付费车位</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                    <strong>车位租赁</strong><strong class="caret"></strong></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">车位出租</a>
                                    </li>
                                    <li>
                                        <a href="#">车位求租</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                    <strong>车位交易</strong><strong class="caret"></strong></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">车位出售</a>
                                    </li>
                                    <li>
                                        <a href="#">车位求购</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="/park_manage.do">
                                    <strong>管理中心</strong>
                                </a>
                            </li>
                        </ul>
                        <ul class="nav pull-right">
                            <li>
                                <a href="/tologin.do">
                                    <strong>
                                        <c:if test="${userName == null}">
                                            会员登录
                                        </c:if>
                                    </strong>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <c:if test="${userName == null}">
                                    <a href="/park_toregister.do">
                                        <strong>注册</strong>
                                    </a>
                                </c:if>
                                <c:if test="${userName != null}">
                                    <!--编辑个人信息功能页-->
                                    <a href="#">
                                        <strong>${userName}</strong>
                                    </a>
                                </c:if>
                            </li>
                            <li class="divider-vertical">
                            </li>
                            <li class="dropdown">
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                    <strong>个人中心</strong><strong class="caret"></strong></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">编辑个人信息</a>
                                    </li>
                                    <li>
                                        <a href="#">修改密码</a>
                                    </li>
                                    <li>
                                        <a href="/quit.do">退出</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <img alt="1000x450" style="height: 80px;width: 100%;"
                 src="static/login/images/indexgavment.png" />
        </div>
    </div>
</div>