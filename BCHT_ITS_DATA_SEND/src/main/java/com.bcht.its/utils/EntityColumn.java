package com.bcht.its.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.Date;

public class EntityColumn {
	private Method method;
	private Field field;
	private String methodName;
	
	
	public EntityColumn(String methodName) {
		this.methodName = methodName;
	}

	public EntityColumn(Method method, Field field, String methodName) {
		this.method = method;
		this.field = field;
		this.methodName = methodName;
	}
	
	public Object getValue(ResultSet rs){
		try {
			if(field.getType() == String.class){
				return rs.getString(field.getName());
			}else if(field.getType() == Date.class){
				return rs.getTimestamp(field.getName());
			}else if(field.getType() == Integer.class || field.getType() == int.class){
				return rs.getInt(field.getName());
			}else if(field.getType() == Double.class || field.getType() == double.class){
				return rs.getDouble(field.getName());
			}else if(field.getType() == Float.class || field.getType() == float.class){
				return rs.getFloat(field.getName());
			}else if(field.getType() == Short.class || field.getType() == short.class){
				return rs.getShort(field.getName());
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((methodName == null) ? 0 : methodName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityColumn other = (EntityColumn) obj;
		if (methodName == null) {
			if (other.methodName != null)
				return false;
		} else if (!methodName.equals(other.methodName))
			return false;
		return true;
	}

	public static void main(String[] args) {
		
	}
}
