package org.zhl.scs.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;

/**
 * 返回json映射类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/24
 */
@Configuration
public class ReturnJsonMapper extends ObjectMapper {
    public ReturnJsonMapper(){
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);//返回为null的值则去除，
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);//解决延迟加载的对象
    }
}
