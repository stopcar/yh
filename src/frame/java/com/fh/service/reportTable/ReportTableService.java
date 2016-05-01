package com.fh.service.reportTable;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;


@Service("reportTableService")
public class ReportTableService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	
	public List<Map<String, String>> queryReport(Map<String, Object> param)throws Exception{
		return (List<Map<String, String>>)dao.findForList("ReportTableMapper.queryReport", param);
	}
	
	public Object  reportCount(Map<String, Object> param)throws Exception{
		return dao.findForObject("ReportTableMapper.reportCount", param);
	}
}

