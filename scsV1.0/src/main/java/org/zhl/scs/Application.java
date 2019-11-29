package org.zhl.scs;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.zhl.scs.service.device.monitor.MonitorServer;

@SpringBootApplication
@MapperScan(basePackages = {"org.zhl.scs.dao"}
	,annotationClass = Mapper.class)
public class Application {

	private final static Logger logger= LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		//启动监控服务器
		try {
			MonitorServer monitorServer = applicationContext.getBean(MonitorServer.class);
			monitorServer.run();
			logger.info("启动监控服务器");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
