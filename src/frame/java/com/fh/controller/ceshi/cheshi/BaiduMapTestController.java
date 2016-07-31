package com.fh.controller.ceshi.cheshi;

import com.fh.controller.base.BaseController;
import com.fh.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yinhaiping on 2016/6/10.
 */
@Controller
public class BaiduMapTestController extends BaseController {

    /**
     * 百度帐户API_AK
     */
    public final static String GAODE_KEY = "5927762ed0ff6673a357924baf45c5ec";

    /**
     * 查看第一个地图
     */
    @RequestMapping(value="/baiDuMapTest_xx1.do")
    public ModelAndView show_xx1(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("title","高德地图示例");
        mv.addObject("key",GAODE_KEY);
        mv.addObject("pd",pd);
        mv.setViewName("ceshi/ceshi/baiduMap_xx1");
        return mv;
    }

}
