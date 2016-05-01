package com.fh.service.system.createCodeByTable;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.entity.system.User;
import com.fh.util.PageData;


@Service("codeByTableService")
public class CodeByTableService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	@SuppressWarnings("unchecked") 
	public List<PageData> findTableBySchema(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TableMapper.findTableBySchema", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> findColsByTable(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TableMapper.findColsByTable", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> findSchema(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TableMapper.findSchema", pd);
	}
	
}
