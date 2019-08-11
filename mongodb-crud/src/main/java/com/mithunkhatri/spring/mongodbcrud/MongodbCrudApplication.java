package com.mithunkhatri.spring.mongodbcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MongodbCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbCrudApplication.class, args);
	}

}
