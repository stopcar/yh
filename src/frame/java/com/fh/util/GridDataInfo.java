package com.fh.util;

import java.util.List;
public class GridDataInfo {
	//总页数
	private int total;
	/*当前页数*/
	private int page;
	/*总记录数*/
	private int records;
	/*每页行数*/
	private int pageRows; 
	
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}

	private int rowNum;
	
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	/*返回记录数*/
	private List rows;
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	 
//	public String toString(){
//		return JSONObject.toJSONString(this);
//	} 
//	
	
}
