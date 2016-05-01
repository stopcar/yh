package com.fh.controller.ceshi.sysAppUserCopy;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.system.Menu;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.Const;
import com.fh.util.PageData;
import com.fh.util.Tools;
import com.fh.service.ceshi.sysAppUserCopy.SysAppUserCopyService2;
import com.fh.service.system.role.RoleService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
 import com.fh.util.DateUtil;
import com.fh.util.DelAllFile;
import com.fh.util.FileUpload;
 import com.fh.util.PathUtil;
/** 
 * 类名称：SysAppUserCopyController
 * 创建人：FH 
 * 创建时间：2015-05-18
 */
@Controller
@RequestMapping(value="/sysAppUserCopy2")
public class SysAppUserCopyController2 extends BaseController {
	
	@Resource(name="sysAppUserCopyService2")
	private SysAppUserCopyService2 sysAppUserCopyService;
	
	@Resource(name="roleService")
	private	RoleService roleService;
	
	/**
	 * 新增
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(@RequestParam("NAME") MultipartFile NAME_FILE,@RequestParam("IP") MultipartFile IP_FILE,
							 MultipartHttpServletRequest request) throws Exception{
		logBefore(logger, "新增SysAppUserCopy");
		ModelAndView mv = this.getModelAndView();
		PageData pd =  new PageData(request);
		
		String  ffile = DateUtil.getDays(), fileName = "";
	 	if (null != NAME_FILE && !NAME_FILE.isEmpty()) {
			String filePath = PathUtil.getClasspath() + Const.FILEPATHFILE + ffile;		//文件上传路径
			fileName = FileUpload.fileUp(NAME_FILE, filePath, this.get32UUID());				//执行上传
			pd.put("NAME", ffile + "/" + fileName);				                //路径
		}
	 	if (null != IP_FILE && !IP_FILE.isEmpty()) {
			String filePath = PathUtil.getClasspath() + Const.FILEPATHFILE + ffile;		//文件上传路径
			fileName = FileUpload.fileUp(IP_FILE, filePath, this.get32UUID());				//执行上传
			pd.put("IP", ffile + "/" + fileName);				                //路径
		}
		pd.put("USER_ID", this.get32UUID());	//主键
		sysAppUserCopyService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out){
		logBefore(logger, "删除SysAppUserCopy");
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			sysAppUserCopyService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	
	/**
	 * 修改
	 */
@RequestMapping(value="/edit")
	public ModelAndView edit(@RequestParam("NAME") MultipartFile NAME_FILE,@RequestParam("IP") MultipartFile IP_FILE,
							 MultipartHttpServletRequest request) throws Exception{
		logBefore(logger, "修改SysAppUserCopy");
		ModelAndView mv = this.getModelAndView();
		PageData pd =  new PageData(request);
		String  ffile = DateUtil.getDays(), fileName = "";
	 	if (null != NAME_FILE && !NAME_FILE.isEmpty()) {
			String filePath = PathUtil.getClasspath() + Const.FILEPATHFILE + ffile;		//文件上传路径
			fileName = FileUpload.fileUp(NAME_FILE, filePath, this.get32UUID());				//执行上传
			pd.put("NAME", ffile + "/" + fileName);				                //路径
		}else{
			pd.put("NAME", pd.get("NAME_HIDDEN"));
		}
	 	if (null != IP_FILE && !IP_FILE.isEmpty()) {
			String filePath = PathUtil.getClasspath() + Const.FILEPATHFILE + ffile;		//文件上传路径
			fileName = FileUpload.fileUp(IP_FILE, filePath, this.get32UUID());				//执行上传
			pd.put("IP", ffile + "/" + fileName);				                //路径
		}else{
			pd.put("IP", pd.get("IP_HIDDEN"));
		}
		int result = sysAppUserCopyService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page){
		logBefore(logger, "列表SysAppUserCopy");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd.put("USERNAME", "");
		try{
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData>	varList = sysAppUserCopyService.list(page);	//列出SysAppUserCopy列表
			mv.setViewName("ceshi/sysAppUserCopy/sysAppUserCopy_list");
			mv.addObject("RIGHTS_list", roleService.listRoleForSelect());
			mv.addObject("varList", varList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 去新增页面
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd(){
		logBefore(logger, "去新增SysAppUserCopy页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.addObject("RIGHTS_list", roleService.listRoleForSelect());
			mv.addObject("ROLE_ID_list", roleService.listRoleForSelect());
			mv.addObject("LAST_LOGIN_list", roleService.listRoleForSelect());
			mv.setViewName("ceshi/sysAppUserCopy/sysAppUserCopy_edit");
			mv.addObject("msg", "save");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(){
		logBefore(logger, "去修改SysAppUserCopy页面");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd = sysAppUserCopyService.findById(pd);	//根据ID读取
			mv.setViewName("ceshi/sysAppUserCopy/sysAppUserCopy_edit");
			mv.addObject("msg", "edit");
			mv.addObject("pd", pd);
			mv.addObject("RIGHTS_list", roleService.listRoleForSelect());
			mv.addObject("ROLE_ID_list", roleService.listRoleForSelect());
			mv.addObject("LAST_LOGIN_list", roleService.listRoleForSelect());
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}	
	
	/**
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() {
		logBefore(logger, "批量删除SysAppUserCopy");
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String DATA_IDS = pd.getString("DATA_IDS");
			if(null != DATA_IDS && !"".equals(DATA_IDS)){
				String ArrayDATA_IDS[] = DATA_IDS.split(",");
				sysAppUserCopyService.deleteAll(ArrayDATA_IDS);
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
	
	
	/*
	*删除文件
	*/
	@RequestMapping(value="/delFile")
	@ResponseBody
	public String delFile() {
		logBefore(logger, "删除文件");
		try{
			PageData pd = this.getPageData();
			String fileColName = pd.getString("fileColName");	
			String fileColValue=pd.getString(fileColName);												 		//图片路径
			DelAllFile.delFolder(PathUtil.getClasspath()+ Const.FILEPATHIMG +  fileColValue); 	//删除图片
			sysAppUserCopyService.delFile(pd);														
		}catch(Exception e){
			logger.error(e.toString(), e);
		}
		return "success";
	}
	
	
	/*
	 * 导出到excel
	 * @return
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(){
		logBefore(logger, "导出SysAppUserCopy到excel");
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
					titles.add("用户ID");	//1
					titles.add("用户名");	//2
					titles.add("密码");	//3
					titles.add("名字");	//4
					titles.add("权限");	//5
					titles.add("角色");	//6
					titles.add("最后登录时间");	//7
					titles.add("ip1");	//8
					titles.add("dsds");	//9
					titles.add("结束时间");	//10
			dataMap.put("titles", titles);
			List<PageData> varOList = sysAppUserCopyService.listAll(pd);
			List<PageData> varList = new ArrayList<PageData>();
			for(int i=0;i<varOList.size();i++){
				PageData vpd = new PageData();
			 	vpd.put("var1", varOList.get(i).getString("USER_ID"));	//1
			 	vpd.put("var2", varOList.get(i).getString("USERNAME"));	//2
			 	vpd.put("var3", varOList.get(i).getString("PASSWORD"));	//3
			 	vpd.put("var4", varOList.get(i).getString("NAME"));	//4
			 	vpd.put("var5", varOList.get(i).getString("RIGHTS"));	//5
			 	vpd.put("var6", varOList.get(i).getString("ROLE_ID"));	//6
			 	vpd.put("var7", varOList.get(i).getString("LAST_LOGIN"));	//7
			 	vpd.put("var8", varOList.get(i).getString("IP"));	//8
			 	vpd.put("var9", varOList.get(i).getString("STATUS"));	//9
			 	vpd.put("var10", varOList.get(i).getString("END_TIME"));	//10
				varList.add(vpd);
			}
			dataMap.put("varList", varList);
			ObjectExcelView erv = new ObjectExcelView();
			mv = new ModelAndView(erv,dataMap);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
