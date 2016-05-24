package com.fh.entity.park;

import com.fh.entity.Page;

import java.util.Date;

/**
 * 用户信息
 */
public class UserInfo {
    // 数据库对应
    private int    userID;	            //用户ID
    private String userName;	        //用户名
    private String password;	        //密码
    private String gender;	            //性别
    private Date   registrationTime;    //注册时间         后台里写
    private String qq;	                //qq
    private String weiXin;	            //微信号
    private String mobilePhon;	        //手机
    private String emailBox;	        //邮箱
    private String Identity;	        //身份标识  0管理员  1用户                                 后台里写  1 用户
    private String accountStatus;	    //帐户状态标识  0待审核(不合理暂不用) 1正常使用 2黑名单        后台里写  1 正常使用
    private String userQuestionone;	    //密保问题一
    private String userQuestiononeans;	//密保问题一答案
    private String userQuestiontwo;	    //密保问题二
    private String userQuestiontwoans;	//密保问题二答案

    // 临时补充
    private String enterpassword;       //确认密码
    private String IP;			        //用户登录ip地址
    // 分页
    private Page page;			        //分页对象

    public String getEnterpassword() {
        return enterpassword;
    }

    public void setEnterpassword(String enterpassword) {
        this.enterpassword = enterpassword;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin;
    }

    public String getMobilePhon() {
        return mobilePhon;
    }

    public void setMobilePhon(String mobilePhon) {
        this.mobilePhon = mobilePhon;
    }

    public String getEmailBox() {
        return emailBox;
    }

    public void setEmailBox(String emailBox) {
        this.emailBox = emailBox;
    }

    public String getIdentity() {
        return Identity;
    }

    public void setIdentity(String identity) {
        Identity = identity;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUserQuestionone() {
        return userQuestionone;
    }

    public void setUserQuestionone(String userQuestionone) {
        this.userQuestionone = userQuestionone;
    }

    public String getUserQuestiononeans() {
        return userQuestiononeans;
    }

    public void setUserQuestiononeans(String userQuestiononeans) {
        this.userQuestiononeans = userQuestiononeans;
    }

    public String getUserQuestiontwo() {
        return userQuestiontwo;
    }

    public void setUserQuestiontwo(String userQuestiontwo) {
        this.userQuestiontwo = userQuestiontwo;
    }

    public String getUserQuestiontwoans() {
        return userQuestiontwoans;
    }

    public void setUserQuestiontwoans(String userQuestiontwoans) {
        this.userQuestiontwoans = userQuestiontwoans;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Page getPage() {
        if(page==null)
            page = new Page();
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
