package com.fh.util;
/**
 * 字符串相关方法
 *
 */
public class StringUtil {

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr){
	    int i = 0;
	    String TempStr = valStr;
	    String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
	    valStr = valStr + ",";
	    while (valStr.indexOf(',') > 0)
	    {
	        returnStr[i] = valStr.substring(0, valStr.indexOf(','));
	        valStr = valStr.substring(valStr.indexOf(',')+1 , valStr.length());
	        
	        i++;
	    }
	    return returnStr;
	}
	
	public static String concatStr(String [] str){
		StringBuffer strBuf=new StringBuffer();
	    for(int i=0;i<str.length;i++){
	    	strBuf.append(",").append(str[i]);
	    }
	    if(strBuf.indexOf(",")==0){
	    	return strBuf.substring(1);
	    }else{
		    return "";
	    }
	    
	}
	
	/*
	 * user_tab  to UserTab
	 */
	public static String transUpperStr(String str){ 
		if(str.indexOf("_")==-1){
			return str;
		}
		String [] str_ = str.split("_");
		StringBuffer returnStr = new StringBuffer();
		for(String var: str_){
			returnStr.append(var.substring(0, 1).toUpperCase()).append(var.substring(1).toLowerCase());
		}
		return returnStr.toString();
	}
	
	public static String transUpperStrWithOutFrist(String str){
		String upperStr=transUpperStr(str);
		StringBuffer returnStr = new StringBuffer();
		returnStr.append(upperStr.substring(0, 1).toLowerCase()).append(upperStr.substring(1));
		return returnStr.toString();
	}
 
}
