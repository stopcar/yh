package com.fh.controller.park.login;

import com.fh.controller.base.BaseController;
import com.fh.entity.park.UserInfo;
import com.fh.service.park.LoginService;
import com.fh.util.Const;
import com.fh.util.PageData;
import com.fh.util.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 身份认证
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
        PageData pd = new PageData();
        pd = this.getPageData();
        String userName = pd.getString("userName");
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
     *    密码不能为空 (可加密保存)
     *    四种联系方式至少有一种
     *    注册时间（为当前系统时间）  DateUtil.getTime().toString();
     *    注册的都是用户 身份标识 Identity 为 1
     *    帐户状态标识  AccountStatus 为 1 正常使用
     *    两个密保问题和答案都必填(可加密保存)(提示：请记好答案，方便您找回密码！)
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



}
