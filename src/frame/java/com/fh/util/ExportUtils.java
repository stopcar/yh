package com.fh.util;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportUtils {	
	
	private String [] exportHead;
	private List<Map<String, Object>> exportContent;
	private String excelName;
	private String [] colsName;
	public ExportUtils(String [] headers,List<Map<String, Object>> contents,String name,String [] colModel){
		exportHead=headers;
		exportContent=contents;
		excelName=name;
		colsName=colModel;
	}
    
	public HSSFWorkbook export() {  
        HSSFWorkbook wb = new HSSFWorkbook();  
        HSSFSheet sheet = wb.createSheet(excelName);  
        HSSFRow row = sheet.createRow((int) 0); 
        row.setHeightInPoints(12);
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
        style.setWrapText(true);
        style.setLocked(true);
        HSSFCellStyle style2 = wb.createCellStyle();  
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
        style2.setWrapText(true);
        //style.setFillForegroundColor((short) 13);// 设置背景色
       // style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        HSSFFont f  = wb.createFont();         
        f.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//加粗  
        f.setFontHeightInPoints((short)9);//字体大小
        f.setFontName("微软雅黑");
        HSSFFont f2  = wb.createFont();         
        f2.setFontHeightInPoints((short)10);//字体大小
        //f2.setFontName("黑体");
        style2.setFont(f2);
        style.setFont(f);
        //表头写入
        for (int i = 0; i < exportHead.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(exportHead[i]);  
            cell.setCellStyle(style);  
            sheet.autoSizeColumn(i);  
         // sheet.SetColumnWidth(i, 100 * 256);  
        }  
  
        //System.out.print("内容写入开始："+System.currentTimeMillis());
        //内容写入
        for (int i = 0; i < exportContent.size(); i++) {  
            row = sheet.createRow(i + 1);  
            Map<String, Object> map=(Map<String, Object>)exportContent.get(i);
            for(int j=0;j<colsName.length;j++){
            	String cellVal=map.get(colsName[j])==null?"":String.valueOf(map.get(colsName[j]));
            	HSSFCell cell = row.createCell(j);  
            	cell=row.createCell(j);
            	cell.setCellValue(cellVal);  
            	//cell.setCellStyle(style2);  
               // sheet.autoSizeColumn(j);  
            }

            
        }   
        //System.out.print("内容写入结束："+System.currentTimeMillis());
        return wb;  
    }  
}
