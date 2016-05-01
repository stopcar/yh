package com.fh.controller.module.factory;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.module.factroy.ModuleService;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.PageData;


@Controller
@RequestMapping(value="/module")
public class ModuleController extends BaseController {
	
	@Resource(name="moduleService")
	private ModuleService moduleService;	
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() {
		
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				moduleService.deleteAll(ArrayDATA_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			pdList.add(pd);
			map.put("list", pdList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);
		}
		return AppUtil.returnObject(pd, map);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		moduleService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd = moduleService.findById(pd);	//根据ID读取
			mv.setViewName("module/widget/widget_edit");
			mv.addObject("msg", "edit");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	
	@RequestMapping(value="/downLoadCode")
	public ModelAndView downLoadCode(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.setViewName("module/table/download_code");
			mv.addObject("tableName",pd.get("tableName"));
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	
	@RequestMapping(value="/makeCode")
	public ModelAndView makeCode(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.setViewName("redirect:/createCode/proCodeByTable.do?packageName="+pd.get("packageName")+"&TABLE_NAME="+pd.get("tableName"));
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out){
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			moduleService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	/**
	 * 新增
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		moduleService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	
	/**
	 * 去组件管理页面
	 */
	@RequestMapping(value="/widgetInfo")
	public ModelAndView widgetInfo(Page page){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData>	varList = moduleService.list(page);	
			mv.setViewName("module/widget/widget_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}

	/**
	 * 表单配置页面
	 */
	@RequestMapping(value="/tableInfo")
	public ModelAndView tableInfo(Page page){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			String MODULE = pd.getString("MODULE");
			
			if(null != MODULE && !"".equals(MODULE)){
				pd.put("MODULE",  MODULE.trim());
			}
			page.setPd(pd);
			List<PageData>	varList = moduleService.tableList(page);	
			mv.setViewName("module/table/table_list");
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}

	/**
	 * 去表单配置页面
	 */
	@RequestMapping(value="/make")
	public ModelAndView make(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> list=new ArrayList<PageData>();
		List<PageData> colList=new ArrayList<PageData>();
		try {
			list = moduleService.widgetList(pd);
			colList = moduleService.colList(pd);
			mv.setViewName("module/table/table_edit");
			mv.addObject("msg", "addColRel");
			mv.addObject("list", list);
			mv.addObject("colList", colList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 新增配置关系
	 */
	@RequestMapping(value="/addColRel")
	public ModelAndView addColRel() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String [] seqIds=pd.get("SEQ_ID").toString().split(",");
		String [] priKeys=pd.get("PRI_KEY").toString().split(",");
		String [] dataTypes=pd.get("DATA_TYPE").toString().split(",");
		String [] tableNames=pd.get("TABLE_NAME").toString().split(",");
		String [] columnNames=pd.get("COLUMN_NAME").toString().split(",");
		String [] columnComments=pd.get("COLUMN_COMMENT").toString().split(",");
		String [] moduleIds=pd.get("MODULE_ID").toString().split(",");
		String [] nullFlags=pd.get("NULL_FLAG").toString().split(",");
		String [] showOrders=pd.get("SHOW_ORDER").toString().split(",");
		String [] isConditions=pd.get("IS_CONDITIONS").toString().split(",");
		String [] conditionType=pd.get("CONDITION_TYPE").toString().split(",");
		for(int i=0;i<seqIds.length;i++){
			if("".equals(pd.get("SEQ_ID").toString())){
				pd.put("PRI_KEY", priKeys[i]);
				pd.put("DATA_TYPE", dataTypes[i]);
				pd.put("TABLE_NAME", tableNames[i]);
				pd.put("COLUMN_NAME", columnNames[i]);
				pd.put("COLUMN_COMMENT", columnComments[i]);
				pd.put("MODULE_ID", moduleIds[i]);
				pd.put("NULL_FLAG", nullFlags[i]);
				pd.put("SHOW_ORDER", showOrders[i]);
				pd.put("IS_CONDITIONS", isConditions[i]);
				pd.put("CONDITION_TYPE", conditionType[i]);
				
				moduleService.insertColRel(pd);
			}else{
				if(!"-1".equals(seqIds[i])){
					pd.put("SEQ_ID", seqIds[i]);
					pd.put("PRI_KEY", priKeys[i]);
					pd.put("DATA_TYPE", dataTypes[i]);
					pd.put("TABLE_NAME", tableNames[i]);
					pd.put("COLUMN_NAME", columnNames[i]);
					pd.put("COLUMN_COMMENT", columnComments[i]);
					pd.put("MODULE_ID", moduleIds[i]);
					pd.put("NULL_FLAG", nullFlags[i]);
					pd.put("SHOW_ORDER", showOrders[i]);
					pd.put("IS_CONDITIONS", isConditions[i]);
					pd.put("CONDITION_TYPE", conditionType[i]);
					moduleService.saveColRel(pd);
				}else{
					if(!"-1".equals(showOrders[i])){
						pd.put("PRI_KEY", priKeys[i]);
						pd.put("DATA_TYPE", dataTypes[i]);
						pd.put("TABLE_NAME", tableNames[i]);
						pd.put("COLUMN_NAME", columnNames[i]);
						pd.put("COLUMN_COMMENT", columnComments[i]);
						pd.put("MODULE_ID", moduleIds[i]);
						pd.put("NULL_FLAG", nullFlags[i]);
						pd.put("SHOW_ORDER", showOrders[i]);
						pd.put("IS_CONDITIONS", isConditions[i]);
						pd.put("CONDITION_TYPE", conditionType[i]);
						moduleService.insertColRel(pd);
					}
					
				}
			}
			
		}
		
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 去新增页面
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.setViewName("module/widget/widget_edit");
			mv.addObject("msg", "save");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	

	/**
	 * 配置信息
	 */
	@RequestMapping(value="/moduleInfo")
	public List<PageData> moduleInfo(Page page){
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> list=new ArrayList<PageData>();
		try{
			 list= moduleService.moduleInfoList(pd);	
			
			
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return list;
	}
	
	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
}
