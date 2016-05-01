package com.fh.service.ceshi.sysAppUserCopy;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("sysAppUserCopyService1")
public class SysAppUserCopyService1 {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/*
	* 新增
	*/
	public int save(PageData pd)throws Exception{
		return dao.save("SysAppUserCopyMapper.save", pd);
	}
	
	/*
	* 删除
	*/
	public int delete(PageData pd)throws Exception{
		return dao.delete("SysAppUserCopyMapper.delete", pd);
	}
	
	/*
	* 修改
	*/
	public int edit(PageData pd)throws Exception{
		return dao.update("SysAppUserCopyMapper.edit", pd);
	}
	
	/*
	*列表
	*/
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("SysAppUserCopyMapper.datalistPage", page);
	}
	
	/*
	*列表(全部)
	*/
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("SysAppUserCopyMapper.listAll", pd);
	}
	
	/*
	* 通过id获取数据
	*/
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("SysAppUserCopyMapper.findById", pd);
	}
	
	/*
	* 批量删除
	*/
	public Object deleteAll(String[] ArrayDATA_IDS)throws Exception{
		return dao.delete("SysAppUserCopyMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

