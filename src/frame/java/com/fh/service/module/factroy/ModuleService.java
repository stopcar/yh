package com.fh.service.module.factroy;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("moduleService")
public class ModuleService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public void save(PageData pd)throws Exception{
		dao.save("ModuleMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public void delete(PageData pd)throws Exception{
		dao.delete("ModuleMapper.delete", pd);
	}
	public List<PageData> moduleInfoList(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ModuleMapper.moduleInfo", pd);
	}
	public List<PageData> widgetList(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ModuleMapper.widgetList", pd);
	}
	public List<PageData> colList(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("ModuleMapper.colList", pd);
	}
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("ModuleMapper.datalistPage", page);
	}
	public List<PageData> tableList(Page page)throws Exception{
		return (List<PageData>)dao.findForList("TableModuleMapper.datalistPage", page);
	}
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("ModuleMapper.findById", pd);
	}
	/*
	* 修改
	*/
	public void edit(PageData pd)throws Exception{
		dao.update("ModuleMapper.edit", pd);
	}
	/*
	* 批量删除
	*/
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("ModuleMapper.deleteAll", ArrayDATA_IDS);
	}
	
	public PageData tableInfoByName(PageData pd)throws Exception{
		return (PageData)dao.findForObject("TableModuleMapper.tableInfoByName", pd);
	}
	public void insertColRel(PageData pd)throws Exception{
		dao.update("TableModuleMapper.addColRel", pd);
	}
	
	public void saveColRel(PageData pd)throws Exception{
		dao.update("TableModuleMapper.editColRel", pd);
	}
}

