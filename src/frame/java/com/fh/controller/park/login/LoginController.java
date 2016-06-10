package com.fh.controller.park.login;

import com.fh.controller.base.BaseController;
import com.fh.entity.park.UserInfo;
import com.fh.service.park.LoginService;
import com.fh.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 身份认证(+个人中心管理)
 * 1、登录(用户和管理员) session放入用户ID和用户名 黑名单判断
 * 2、注册（填密保问题）
 * 3、找回密码（密保）
 * 4、个人信息修改(要用密码验证) 盾Session有没有ID,没有直接让登录
 */
@Controller
public class LoginController extends BaseController {

    @Resource(name="loginService")
    private LoginService loginService;

    /**
     * 访问登录页
     * @return
     */
    @RequestMapping(value="/tologin.do")
    public ModelAndView toLogin(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        mv.setViewName("park/login/login");
        mv.addObject("pd",pd);
        return mv;
    }

    /**
     * 登录
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/park_login.do")
    public ModelAndView login() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        String userName = pd.getString("userName");
        pd.put("userName",userName);
        String password = pd.getString("password");
        //  根据用户名取对应用户信息
        List<UserInfo> userinfoList = loginService.getUserInfolistById(userName);
        if( ! userinfoList.isEmpty()){
            UserInfo userinfo = userinfoList.get(0);
            //黑名单检查 帐户状态标识 2 黑名单
            if("2".equals(userinfo.getAccountStatus())){
                pd.put("error","帐户已加入黑名单，如有疑问找管理员！");
                mv.setViewName("park/login/login");
                mv.addObject("pd",pd);
                return mv;
            }
            if (password.equals(userinfo.getPassword())) {
                //将用户ID、用户名放入session
                HttpSession session = this.getRequest().getSession();
                session.setAttribute("userID",userinfo.getUserID());
                session.setAttribute("userName",userinfo.getUserName());
                mv.setViewName("park/index/index");
            }
            else {
                pd.put("error","输入密码错误！");
                mv.setViewName("park/login/login");
            }
        }
        else {
            pd.put("error","用户名不存在！");
            mv.setViewName("park/login/login");
        }
        mv.addObject("pd",pd);
        return mv;
    }

    /**
     * 退出
     */
    @RequestMapping(value="/quit.do")
    public ModelAndView quit(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        HttpSession session = this.getRequest().getSession();
        session.invalidate();
        mv.setViewName("park/login/login");
        mv.addObject("pd",pd);
        return mv;
    }

    /**
     * 注册
     * 注意：用户ID自动生成
     * 注册审核
     *    用户名不允许重复
     *    密码确认  (可加密保存)
     *    //四种联系方式至少有一种
     *    注册时间（为当前系统时间）  DateUtil.getTime().toString();
     *    注册的都是用户 身份标识 Identity 为 1
     *    帐户状态标识  AccountStatus 为 1 正常使用
     *    //两个密保问题和答案都必填(可加密保存)(提示：请记好答案，方便您找回密码！)
     * （1）去注册
     * （2）注册 注册成功后跳向注册成功页
     * （3）注册成功页指向登录页面，登录
     */

    /**
     * 访问注册页
     * @return
     */
    @RequestMapping(value="/park_toregister.do")
    public ModelAndView toregister(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        mv.setViewName("park/login/register");
        mv.addObject("pd",pd);
        return mv;
    }

    /**
     * 注册
     */
    @RequestMapping(value="/park_register.do")
    public ModelAndView register() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        //数据后端校验
        boolean flag = loginService.registercheck(pd);
        loginService.getregisterDate(pd);
        if(flag){
            //存注册数据
            loginService.saveUserInfo(pd);
            //返回到注册成功页面
            pd.put("userName",pd.getString("userName"));
            mv.setViewName("park/login/loginsuccess");
            mv.addObject("pd",pd);
            return mv;
        }
        else{
            // 有错误，返回注册页，提示错误
            mv.setViewName("park/login/register");
            mv.addObject("pd",pd);
        }
        return mv;
    }

    /**
     * 访问找回密码页
     */
    @RequestMapping(value="/park_retrievePassword.do")
    public ModelAndView retrievePassword(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        mv.setViewName("park/login/retrievePasswordOne");
        mv.addObject("pd",pd);
        return mv;
    }

    /**
     * 访问找回密码页（第一步 校验用户名） 校验用户名 （找到对应用户后，将用户名传到JSP 并传到后台）
     */
    @RequestMapping(value="/park_retrievePasswordOne.do")
    public ModelAndView retrievePasswordOne() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        // 取对应用户信息
        List<UserInfo> userInfoList = loginService.getUserInfolistById(pd.getString("userName"));
        if(1 == userInfoList.size()){ // 找到对应用户
            pd.put("userName",userInfoList.get(0).getUserName());
            pd.put("userQuestionone",userInfoList.get(0).getUserQuestionone());
            //答案不显示 pd.put("userQuestiononeans",userInfoList.get(0).getUserQuestiononeans());
            pd.put("userQuestiontwo",userInfoList.get(0).getUserQuestiontwo());
            //答案不显示 pd.put("userQuestiontwoans",userInfoList.get(0).getUserQuestiontwoans());
            mv.setViewName("park/login/retrievePasswordTwo");
        }
        else { // 没有找到对应用户
            pd.put("userName", pd.getString("userName"));
            pd.put("error","输入用户名不存在！");
            mv.setViewName("park/login/retrievePasswordOne");
        }
        mv.addObject("pd",pd);
        return mv;
    }

    /**
     * 访问找回密码页（第二步 校验密保答案） 校验用户名  将用户名传到JSP 并传到后台
     */
    @RequestMapping(value="/park_retrievePasswordTwo.do")
    public ModelAndView retrievePasswordTwo() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        // 校验操作完整性，用户是否存在
        if(pd.getString("userName").isEmpty()){
            pd.put("error","操作错误，严重警告！");
            mv.setViewName("park/login/retrievePasswordOne");
        }
        else {
            // 取对应用户信息
            List<UserInfo> userInfoList = loginService.getUserInfolistById(pd.getString("userName"));
            // 判断答案
            if(userInfoList.get(0).getUserQuestiononeans().equals(pd.getString("userQuestiononeans"))
                    && userInfoList.get(0).getUserQuestiontwoans().equals(pd.getString("userQuestiontwoans"))){
                pd.put("userName",userInfoList.get(0).getUserName());
                mv.setViewName("park/login/retrievePasswordThree");
            }
            else { // 答案错误
                pd.put("userName", pd.getString("userName"));
                pd.put("error","输入答案错误，请重新操作！");
                mv.setViewName("park/login/retrievePasswordOne");
            }
        }
        mv.addObject("pd",pd);
        return mv;
    }

    /**
     * 访问找回密码页（第三步 校验输入新的密码 并保存） 校验用户名  跳转到成功页  将用户名传到JSP  成功页指向登录页
     */
    @RequestMapping(value="/park_retrievePasswordThree.do")
    public ModelAndView retrievePasswordThree() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        // 校验操作完整性，用户是否存在
        if(pd.getString("userName").isEmpty()){
            pd.put("error","操作错误，严重警告！");
            mv.setViewName("park/login/retrievePasswordOne");
        }
        else {
            // 取对应用户信息
            List<UserInfo> userInfoList = loginService.getUserInfolistById(pd.getString("userName"));
            // 判断密码是否一致
            if(pd.getString("password").equals(userInfoList.get(0).getPassword())){
                pd.put("userName", pd.getString("userName"));
                pd.put("error","新密码和旧密码冲突，请重新操作！");
                mv.addObject("pd",pd);
                mv.setViewName("park/login/retrievePasswordOne");
                return mv;
            }
            if((!pd.getString("enterpassword").isEmpty()) && pd.getString("enterpassword").equals(pd.getString("password"))){
                // 保存新密码
                pd.put("password",pd.getString("password"));
                pd.put("userName",userInfoList.get(0).getUserName());
                loginService.editUserInfPassword(pd);
                mv.setViewName("park/login/retrievePasswordSuccess");
            }
            else { // 答案错误
                pd.put("userName", pd.getString("userName"));
                pd.put("error","输入新密码错误，请重新操作！");
                mv.setViewName("park/login/retrievePasswordOne");
            }
        }
        mv.addObject("pd",pd);
        return mv;
    }
}
