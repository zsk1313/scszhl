package org.zhl.scs;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.zhl.scs.dao",annotationClass = Mapper.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}

}
