package com.fh.util;


public class PageUtils {	
	private int startNum = 0;
	private int endNum = 0;
	public void analyzePage(GridDataInfo page){
		//总页数
		page.setTotal((int)Math.ceil((double)page.getRecords()/page.getPageRows()));
		if(page.getTotal()<page.getPage()){
			page.setPage(1);
			startNum = 0;
			endNum = page.getPageRows();
		}else{
			startNum=(page.getPage()-1)*page.getPageRows();
			endNum=page.getPage()*page.getPageRows();
		}	 
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
    
}
