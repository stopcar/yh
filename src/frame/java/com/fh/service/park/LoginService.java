package com.fh.service.park;

import java.util.Date;
import java.util.List;
import com.fh.dao.DaoSupport;
import com.fh.entity.park.UserInfo;
import com.fh.util.DateUtil;
import com.fh.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 身份认证相关Service
 */
@Service("loginService")
public class LoginService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    // 删除用户
    public void delUserInfo(PageData pd)throws Exception{
        dao.update("UserInfoMapper.deleteUserInfo",pd);
    }

    // 查看用户列表
    public List<PageData> getUserInfolistAll(PageData pd)throws Exception{
        return (List<PageData>) dao.findForList("UserInfoMapper.selectlistAllUserInfo", pd);
    }

    // 保存用户信息
    public void saveUserInfo(PageData pd)throws Exception{
        dao.save("UserInfoMapper.addUserInfo", pd);
    }

    // 加入黑名单
    public void editUserInfaccountStatus(PageData pd) throws Exception {
        dao.update("UserInfoMapper.editUserInfaccountStatus", pd);
    }

    // 更新用户信息 （pd,put()需要更新的数据, 直接SQL中传入更新）
    public void editUserInfPassword(PageData pd) throws Exception {
        dao.update("UserInfoMapper.editUserInfPassword", pd);
    }

    // 更新用户信息
    public void updateUserInfo(PageData pd) throws Exception {
        dao.update("UserInfoMapper.updateUserInfo", pd);
    }

    // 通过用户ID取用户信息表的数据 pd
    public PageData getUserInfoById(PageData pd)throws Exception{
        return (PageData) dao.findForObject("UserInfoMapper.getUserInfoById",pd);
    }

    // 通过用户名取用户信息表的数据 list
    public List<UserInfo> getUserInfolistById(String userName)throws Exception{
        return (List<UserInfo>) dao.findForList("UserInfoMapper.getUserInfolistById", userName);
    }

    // 通过ID取用户信息表的数据 list
    public List<UserInfo> getUserInfolistByuserId(String userID)throws Exception{
        return (List<UserInfo>) dao.findForList("UserInfoMapper.getUserInfolistByuserId",userID);
    }

    // 注册后端校验
    public boolean registercheck(PageData pd) throws Exception {
        if(pd.getString("userName").isEmpty()){
            pd.put("error","输入用户为空！");
            return false;
        }
        List<UserInfo> userinfoNum = this.getUserInfolistById(pd.getString("userName"));
        if(0 != userinfoNum.size()){
            pd.put("error","输入用户名已被注册！");
            return false;
        }
        if(pd.getString("password").isEmpty()){
            pd.put("error","输入密码为空！");
            return false;
        }
        if(pd.getString("enterpassword").isEmpty()){
            pd.put("error","输入确认密码为空！");
            return false;
        }
        if(!pd.getString("password").equals(pd.getString("enterpassword"))){
            pd.put("error","两次输入密码不一致！");
            return false;
        }
        if(pd.getString("qq").isEmpty()){
            pd.put("error","输入qq号为空！");
            return false;
        }
        if(pd.getString("mobilePhon").isEmpty()){
            pd.put("error","输入手机号为空！");
            return false;
        }
        if(pd.getString("userQuestionone").isEmpty()){
            pd.put("error","输入密保问题一为空！");
            return false;
        }
        if(pd.getString("userQuestiononeans").isEmpty()){
            pd.put("error","输入密保问题一答案为空！");
            return false;
        }
        if(pd.getString("userQuestiontwo").isEmpty()){
            pd.put("error","输入密保问题二为空！");
            return false;
        }
        if(pd.getString("userQuestiontwoans").isEmpty()){
            pd.put("error","输入密保问题二答案为空！");
            return false;
        }
        return true;
    }

    // 取添加用户页面数据
    public void geteditUserDate(PageData pd){
        String userID = pd.getString("userID");              //用户Id
        pd.put("userID", userID);
        String userName = pd.getString("userName");              //用户名
        pd.put("userName", userName);
        String password = pd.getString("password");              //密码
        pd.put("password", password);
        String enterpassword = pd.getString("enterpassword");    //确认密码
        pd.put("enterpassword", enterpassword);
        String gender = pd.getString("gender");             //性别
        pd.put("gender", gender);
        Date   registrationTime = new Date();               //注册时间
        pd.put("registrationTime", registrationTime);
        String qq = pd.getString("qq");                     //qq
        pd.put("qq", qq);
        String weiXin = pd.getString("weiXin");             //微信号
        pd.put("weiXin", weiXin);
        String mobilePhon = pd.getString("mobilePhon");     //手机
        pd.put("mobilePhon", mobilePhon);
        String emailBox = pd.getString("emailBox");         //邮箱
        pd.put("emailBox", emailBox);
        String Identity = pd.getString("Identity");        //身份标识
        pd.put("Identity", Identity);
        String accountStatus = "1";                         //帐户状态标识 1 正常使用
        pd.put("accountStatus", accountStatus);
        String userQuestionone = pd.getString("userQuestionone");  //密保问题一
        pd.put("userQuestionone", userQuestionone);
        String userQuestiononeans = pd.getString("userQuestiononeans");  //密保问题一答案
        pd.put("userQuestiononeans", userQuestiononeans);
        String userQuestiontwo = pd.getString("userQuestiontwo");  //密保问题二
        pd.put("userQuestiontwo", userQuestiontwo);
        String userQuestiontwoans = pd.getString("userQuestiontwoans");  //密保问题二答案
        pd.put("userQuestiontwoans", userQuestiontwoans);
    }

    // 取添加用户页面数据
    public void getaddUserDate(PageData pd){
        String userName = pd.getString("userName");              //用户名
        pd.put("userName", userName);
        String password = pd.getString("password");              //密码
        pd.put("password", password);
        String enterpassword = pd.getString("enterpassword");    //确认密码
        pd.put("enterpassword", enterpassword);
        String gender = pd.getString("gender");             //性别
        pd.put("gender", gender);
        Date   registrationTime = new Date();               //注册时间
        pd.put("registrationTime", registrationTime);
        String qq = pd.getString("qq");                     //qq
        pd.put("qq", qq);
        String weiXin = pd.getString("weiXin");             //微信号
        pd.put("weiXin", weiXin);
        String mobilePhon = pd.getString("mobilePhon");     //手机
        pd.put("mobilePhon", mobilePhon);
        String emailBox = pd.getString("emailBox");         //邮箱
        pd.put("emailBox", emailBox);
        String Identity = pd.getString("Identity");        //身份标识
        pd.put("Identity", Identity);
        String accountStatus = "1";                         //帐户状态标识 1 正常使用
        pd.put("accountStatus", accountStatus);
        String userQuestionone = pd.getString("userQuestionone");  //密保问题一
        pd.put("userQuestionone", userQuestionone);
        String userQuestiononeans = pd.getString("userQuestiononeans");  //密保问题一答案
        pd.put("userQuestiononeans", userQuestiononeans);
        String userQuestiontwo = pd.getString("userQuestiontwo");  //密保问题二
        pd.put("userQuestiontwo", userQuestiontwo);
        String userQuestiontwoans = pd.getString("userQuestiontwoans");  //密保问题二答案
        pd.put("userQuestiontwoans", userQuestiontwoans);
    }

    // 取注册页面数据
    public void getregisterDate(PageData pd){
        String userName = pd.getString("userName");              //用户名
        pd.put("userName", userName);
        String password = pd.getString("password");              //密码
        pd.put("password", password);
        String enterpassword = pd.getString("enterpassword");    //确认密码
        pd.put("enterpassword", enterpassword);
        String gender = pd.getString("gender");             //性别
        pd.put("gender", gender);
        Date   registrationTime = new Date();               //注册时间
        pd.put("registrationTime", registrationTime);
        String qq = pd.getString("qq");                     //qq
        pd.put("qq", qq);
        String weiXin = pd.getString("weiXin");             //微信号
        pd.put("weiXin", weiXin);
        String mobilePhon = pd.getString("mobilePhon");     //手机
        pd.put("mobilePhon", mobilePhon);
        String emailBox = pd.getString("emailBox");         //邮箱
        pd.put("emailBox", emailBox);
        String Identity = "1";                              //身份标识 1 用户
        pd.put("Identity", Identity);
        String accountStatus = "1";                         //帐户状态标识 1 正常使用
        pd.put("accountStatus", accountStatus);
        String userQuestionone = pd.getString("userQuestionone");  //密保问题一
        pd.put("userQuestionone", userQuestionone);
        String userQuestiononeans = pd.getString("userQuestiononeans");  //密保问题一答案
        pd.put("userQuestiononeans", userQuestiononeans);
        String userQuestiontwo = pd.getString("userQuestiontwo");  //密保问题二
        pd.put("userQuestiontwo", userQuestiontwo);
        String userQuestiontwoans = pd.getString("userQuestiontwoans");  //密保问题二答案
        pd.put("userQuestiontwoans", userQuestiontwoans);
    }

}