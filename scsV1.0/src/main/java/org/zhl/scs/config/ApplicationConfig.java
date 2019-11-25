package org.zhl.scs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhl.scs.util.DaoUtil;
import org.zhl.scs.util.ServiceUtil;

/**
 * 应用配置类
 * @author zsk
 * @version 1.0
 * Create on 2019/11/14
 */
@Configuration
public class ApplicationConfig {
    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public DaoUtil initDaoUtil(){
        return new DaoUtil(applicationContext);
    }

    @Bean
    public ServiceUtil initServiceUtil(){ return new ServiceUtil(applicationContext,initDaoUtil()); }
}
