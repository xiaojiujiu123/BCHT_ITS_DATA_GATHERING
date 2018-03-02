package com.bcht.its.utils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 实体映射工具类，根据原生SQL查询的ResultSet，动态组装对应的ORM实体
 *
 */
public class EntityTools<T> {
	private List<EntityColumn> entityColumn = null;
	private List<String> columnsNames = null;
	/**
	 * 从ResultSet接口中获取当前的ColumnsNames集合
	 * @param rs ResultSet
	 * @return 返回当前的ResultSet当中所包含的所有列名集合
	 * @throws SQLException
	 */
	public List<String> findColumnsNamesByResultSet(ResultSet rs) throws SQLException{
		ResultSetMetaData rsd = rs.getMetaData();
		int columnsLength =rsd .getColumnCount();
		List<String> columnNames = new ArrayList<String>();
		for(int i=1;i<=columnsLength;i++){
			columnNames.add(rsd.getColumnName(i));
		}
		return columnNames;
	}
	
	/**
	 * 通过反射ORM Result与entity间的映射值
	 * @param rs
	 * @param entity
	 */
	@SuppressWarnings("hiding")
	public <T> T setColumnsValueByResultSet(ResultSet rs,T entity){
		if(entityColumn == null){
			entityColumn= getAllSetMothodNames(entity.getClass());
		}
		try {
			if(null == columnsNames){
				columnsNames= findColumnsNamesByResultSet(rs);
			}
			if(null == columnsNames || columnsNames.size() <= 0 ) return null;
			for (String columnsnames : columnsNames) {
				EntityColumn e = new EntityColumn("set"+columnsnames.toLowerCase());
				int index = entityColumn.indexOf(e);
				if(index != -1 ) {
					EntityColumn ec = entityColumn.get(index);
					ec.getMethod().invoke(entity, new Object[]{ec.getValue(rs)});
				}
			}
			return entity;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取指定类的所有set方法
	 * @param clazz
	 * @return
	 */
	public List<EntityColumn> getAllSetMothodNames(Class<?> clazz){
		Method[] methods = clazz.getDeclaredMethods();
		List<EntityColumn> methodMap  = new ArrayList<EntityColumn>();
		for (Method method : methods) {
			String name = method.getName();
			if(name.startsWith("set")){
				String fieldName = StringUtils.uncapitalize(StringUtils.removeStart(name, "set"));
				Field field;
				try {
					//field = clazz.getField(fieldName);
					field = clazz.getDeclaredField(fieldName);
					EntityColumn ec = new EntityColumn(method, field, name.toLowerCase());
					methodMap.add(ec);
				} catch (NoSuchFieldException e) {
					//e.printStackTrace();
				} catch (SecurityException e) {
					//e.printStackTrace();
				}
			}
		}
		return methodMap;
	}
}
