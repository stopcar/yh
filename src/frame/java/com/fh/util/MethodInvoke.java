package com.fh.util;

import java.lang.reflect.Method;
import java.util.Map;


public class MethodInvoke {	
	
	private String methodName;
	private String className;
	private Map<String,Object> param;
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	public Map<String, Object> getParam() {
		return param;
	}
	public void setParam(Map<String, Object> param) {
		this.param = param;
	}
	public   Object excuteMethod(Object object) throws Exception{
		Class<?> c=Class.forName(this.getClassName());
		Method m=c.getMethod(this.getMethodName(),Map.class);
		return m.invoke(object,this.getParam());
	}
}
