package com.fh.controller.park.login;

import com.fh.controller.base.BaseController;
import com.fh.util.Const;
import com.fh.util.PageData;
import com.fh.util.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 身份认证
 * 1、登录(用户和管理员)
 *       session会用，看看例子怎么做的，然后放入用户ID和用户名
 *       然后在头部用个判断，未登录显示未登录和注册，有ID就显示用户名。
 * 2、注册（填密保问题）
 * 3、找回密码（密保）
 * 4、个人信息修改(要用密码验证) 盾Session有没有ID,没有直接让登录
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 访问登录页
     * @return
     */
    @RequestMapping(value="/tologin.do")
    public ModelAndView toLogin(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME));
        mv.setViewName("park/login/login");
        mv.addObject("pd",pd);
        return mv;
    }

}
