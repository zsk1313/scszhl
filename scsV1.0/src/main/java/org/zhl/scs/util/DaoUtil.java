package org.zhl.scs.util;


import org.springframework.context.ApplicationContext;
import org.zhl.scs.exception.EntityNotFoundException;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * Dao层工具类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/15
 */
public class DaoUtil {
    private final static String SELECT_BY_ID="selectById";
    private ApplicationContext applicationContext;//spring 应用上下文
    public DaoUtil(ApplicationContext applicationContext) {
        this.applicationContext=applicationContext;
    }

    /**
     * 根据id验证Entity实体是否存在
     * @param daoClazz 该Entity实体对应Dao类
     * @param entityClazz 该Entity实体类
     * @param id 该Entity实体id值
     * @param selectByIdMethodName 根据id搜索实体的方法名称
     * @param <T> 该实体类型
     * @return 符合该id的Entity实例
     * @throws EntityNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalClassFormatException
     */
    public  <T> T checkEntityById(Class<?> daoClazz, Class<?> entityClazz
            ,Integer id,String selectByIdMethodName)
            throws EntityNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException,
            IllegalClassFormatException {
        //验证id是否合法
        if (id==null){
            throw new NullPointerException("id为null");
        }
        if (id<0){
            throw new IllegalArgumentException("id小于0");
        }
        Object dao=applicationContext.getBean(daoClazz);
        Object entity;
        Method selectById=daoClazz.getMethod(
                (selectByIdMethodName!=null && !"".equals(selectByIdMethodName)
                )?selectByIdMethodName:SELECT_BY_ID,Integer.class);
        entity=selectById.invoke(dao,id);
        if (entity==null){
            throw new EntityNotFoundException(id,entityClazz);
        }else if(!entityClazz.isInstance(entity)){
            throw new IllegalClassFormatException("类型不匹配："+entityClazz);
        }
        return (T) entityClazz.cast(entity);
    }

    /**
     * 根据id验证Entity实体是否存在
     * @param daoClazz 该Entity实体对应Dao类
     * @param entityClazz 该Entity实体类
     * @param id 该Entity实体id值
     * @param <T> 该实体类型
     * @return 符合该id的Entity实例
     * @throws EntityNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalClassFormatException
     */
    public  <T> T checkEntityById(Class<?> daoClazz, Class<?> entityClazz
            ,Integer id)
            throws EntityNotFoundException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException,
            IllegalClassFormatException {
        return checkEntityById(daoClazz,entityClazz,id,null);
    }
}
