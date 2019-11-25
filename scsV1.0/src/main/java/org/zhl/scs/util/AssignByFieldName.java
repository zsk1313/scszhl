package org.zhl.scs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 赋值属性，assignBean类的属性参数值（不为 null 与 ""）赋值到assignedBean类相同属性参数名中
 * @author zsk
 */
public class AssignByFieldName {
	private final static Logger logger= LoggerFactory.getLogger(AssignByFieldName.class);
	private Object assignBean;
	private Object assignedBean;
	private static AssignByFieldName instance;
	private AssignByFieldName() {}
	public static AssignByFieldName getInstance() {
		if(instance==null) {
			instance=new AssignByFieldName();
		}
		return instance;
	}
	public AssignByFieldName(Object assignBean, Object assignedBean) {
		this.assignBean=assignBean;
		this.assignedBean=assignedBean;
	}
	public void setAssignBean(Object assignBean) {
		this.assignBean=assignBean;
	}
	public Object getAssignBean() {
		return assignBean;
	}
	public void setAssignedBean(Object assignedBean) {
		this.assignedBean=assignedBean;
	}
	public Object getAssignedBean() {
		return assignedBean;
	}
	public void Assign()
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		if(getAssignBean()==null || getAssignedBean()==null) {
			logger.debug("赋值类或被赋值类为null");
			throw new NullPointerException("赋值类或被赋值类为null");
		}
		Class<?> clazz1=getAssignBean().getClass();
		Class<?> clazz2=getAssignedBean().getClass();
		Field[] field1s=clazz1.getDeclaredFields();
		Method[] method2s=clazz2.getDeclaredMethods();
		//第一个类的属性参数（值不为null或空）循环复制给第二个类相同属性参数
		for(int i=0;i<field1s.length;i++) {
			Field field=field1s[i];
		    field.setAccessible(true);
		    Object curVal=null;
		    String fieldName=field.getName();
		    String methodName="set"+fieldName.substring(0, 1).toUpperCase()
		    		+fieldName.substring(1);
		    Method curMethod=null;
		    for(int j=0;j<method2s.length;j++) {
		    	if(method2s[j].getName().equals(methodName)) {
					curMethod=method2s[j];
					 logger.debug("当前方法："+curMethod.getName());
					 curVal = field.get(assignBean);
					 if(curVal!=null && !"".equals(curVal)) {
						curMethod.invoke(assignedBean, curVal);
					}
		    	}
		    }
		}
	}
	public void Assign(Object assignBean,Object assignedBean)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Class<?> clazz1=assignBean.getClass();
		Class<?> clazz2=assignedBean.getClass();
		Field[] field1s=clazz1.getDeclaredFields();
		Method[] method2s=clazz2.getDeclaredMethods();
		Field[] field2s=clazz2.getDeclaredFields();
		//第一个类的属性参数（值不为null或空）循环复制给第二个类相同属性参数
		for(int i=0;i<field1s.length;i++) {
			Field field=field1s[i];
		    field.setAccessible(true);
		    Object curVal=null;
		    String fieldName=field.getName();
		    String methodName="set"+fieldName.substring(0, 1).toUpperCase()
		    		+fieldName.substring(1);
		    Method curMethod=null;
		    for(int j=0;j<method2s.length;j++) {
		    	if(method2s[j].getName().equals(methodName)) {
					curMethod=method2s[j];
					 logger.debug("当前方法："+curMethod.getName());
					 curVal = field.get(assignBean);
					 if(curVal!=null && !"".equals(curVal)) {
						curMethod.invoke(assignedBean, curVal);
					}
		    	}
		    }
		}
		//打印赋值后结果
		for(int k=0;k<field2s.length;k++) {
			Field field1=field2s[k];
			field1.setAccessible(true);
			logger.debug("设值成功："+field1.get(assignedBean));
		}
	}
}