package com.fh.controller.park.manage;

import com.fh.controller.base.BaseController;
import com.fh.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理中心 park_manage
 * 功能转发中心 park_console
 */
@Controller
public class ManageController extends BaseController {



    /**
     * 访问管理中心(首页)
     */
    @RequestMapping(value="/park_manage.do")
    public ModelAndView toManage(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        mv.addObject("pd",pd);
        mv.setViewName("park/manage/manageindex");
        return mv;
    }

    /**
     * 功能转发中心
     * 传入 功能权限ID
     *     根据ID链接, 内部转发, 页面数据也传过去
     * 如无ID或功能ID池无对应ID
     *     无权限访问页面 (如有问题，联系管理员)
     */

}
