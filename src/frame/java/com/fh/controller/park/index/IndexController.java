package com.fh.controller.park.index;

import com.fh.controller.base.BaseController;
import com.fh.util.Const;
import com.fh.util.PageData;
import com.fh.util.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 */
@Controller
public class IndexController extends BaseController {

    /**
     * 访问首页
     * @return
    */
    @RequestMapping(value="/toindex.do")
    public ModelAndView toIndex(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("SYSNAME",Tools.readTxtFile(Const.SYSNAME));
        mv.setViewName("park/index/index");
        mv.addObject("pd",pd);
        return mv;
    }
}
