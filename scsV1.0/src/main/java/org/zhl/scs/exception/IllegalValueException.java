package org.zhl.scs.exception;

/**
 * 不合理参数异常类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/15
 */
public class IllegalValueException extends Exception{
    /**
     * 不合理参数异常类构造器
     * @param entityVoClazz 实体vo类
     */
    public IllegalValueException(Class<?> entityVoClazz) {
        super(entityVoClazz+"包含不合法参数值");
    }
}
