package com.fh.controller.park.user;

import com.fh.controller.base.BaseController;
import com.fh.entity.park.UserInfo;
import com.fh.service.park.LoginService;
import com.fh.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理
 */
@Controller
public class UserInfoController extends BaseController {

    @Resource(name="loginService")
    private LoginService loginService;

    /**
     * 查看用户列表
     */
    @RequestMapping(value="/park_selectUserInfoList.do")
    public ModelAndView selectUserInfoList() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        // 查看用户列表
        List<PageData> userInfoList = loginService.getUserInfolistAll(pd);
        mv.addObject("userInfoList",userInfoList);
        mv.addObject("pd",pd);
        mv.setViewName("park/user/user_list");
        return mv;
    }

    /**
     * 根据条件查询用户信息
     */
    @RequestMapping(value="/park_selectUserInfoby.do")
    public ModelAndView selectUserInfoby() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        String userNmae = pd.getString("userName");
        String identity = pd.getString("Identity");
        pd.put("userNmae",userNmae);
        pd.put("identity",identity);
        List<PageData> userInfoList = loginService.getUserInfolistAll(pd);
        mv.addObject("userInfoList",userInfoList);
        mv.addObject("pd",pd);
        mv.setViewName("park/user/user_list");
        return mv;
    }

    /**
     * 加入黑名单
     */
    @RequestMapping(value="/park_editUserInfostutas.do")
    public ModelAndView editUserInfostutas() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        // 删除用户
        pd.put("userID",pd.getString("userID"));
        pd.put("accountStatus",pd.getString("accountStatus"));
        loginService.editUserInfaccountStatus(pd);
        //返回到添加用户成功页面
        List<PageData> userInfoList = loginService.getUserInfolistAll(pd);
        mv.addObject("userInfoList",userInfoList);
        mv.addObject("pd",pd);
        mv.setViewName("park/user/user_list");
        return mv;
    }

    /**
     * 删除用户
     */
    @RequestMapping(value="/park_delUserInfo.do")
    public ModelAndView delUserInfo() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        // 删除用户
        pd.put("userID",pd.getString("userID"));
        loginService.delUserInfo(pd);
        //返回到添加用户成功页面
        List<PageData> userInfoList = loginService.getUserInfolistAll(pd);
        mv.addObject("userInfoList",userInfoList);
        mv.addObject("pd",pd);
        mv.setViewName("park/user/user_list");
        return mv;
    }

    /**
     * 访问添加用户页
     */
    @RequestMapping(value="/park_adduserInfo.do")
    public ModelAndView adduserInfo() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        mv.addObject("pd",pd);
        mv.setViewName("park/user/user_add");
        return mv;
    }

    /**
     * 查看修改用户
     */
    @RequestMapping(value="/park_toeditUserInfo.do")
    public ModelAndView toeditUserInfo() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        // 取对应用户信息
        List<UserInfo> userInfoList = loginService.getUserInfolistByuserId(pd.getString("userID"));
        mv.addObject("userInfo",userInfoList.get(0));
        mv.addObject("pd",pd);
        mv.setViewName("park/user/user_edit");
        return mv;
    }

    /**
     * 修改用户
     */
    @RequestMapping(value="/park_editUserInfo.do")
    public ModelAndView editUserInfo() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        // 取对应用户信息
        loginService.geteditUserDate(pd);
        loginService.updateUserInfo(pd);
        List<PageData> userInfoList = loginService.getUserInfolistAll(pd);
        mv.addObject("userInfoList",userInfoList);
        mv.addObject("pd",pd);
        mv.setViewName("park/user/user_list");
        return mv;
    }

    /**
     * 添加用户
     */
    @RequestMapping(value="/park_addUserInfo.do")
    public ModelAndView addUserInfo() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        //数据后端校验
        boolean flag = loginService.registercheck(pd);
        loginService.getaddUserDate(pd);
        if(flag){
            //存注册数据
            loginService.saveUserInfo(pd);
            //返回到添加用户成功页面
            List<PageData> userInfoList = loginService.getUserInfolistAll(pd);
            mv.addObject("userInfoList",userInfoList);
            mv.addObject("pd",pd);
            mv.setViewName("park/user/user_list");
            return mv;
        }
        else{
            // 有错误，返回添加用户页，提示错误
            mv.setViewName("park/user/user_add");
            mv.addObject("pd",pd);
        }
        return mv;
    }



}
