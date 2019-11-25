package org.zhl.scs.exception;

/**
 * 实体不存在异常类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/14
 */
public class EntityNotFoundException extends Exception{

    /**
     * 实体不存在异常类构造器
     * @param id 该实体id
     * @param entityClazz 该实体Class类
     */
    public EntityNotFoundException(Integer id, Class<?> entityClazz) {
        super("id为："+id+"的"+entityClazz.getName()+"不存在");
    }
}
