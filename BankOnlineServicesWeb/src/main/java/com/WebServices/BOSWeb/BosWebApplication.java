package com.WebServices.BOSWeb;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BosWebApplication {

	public static void main(String[] args) {
		final Logger logger=Logger.getLogger(BosWebApplication.class.getName());
		logger.info(" :: Running Main ::");
		SpringApplication.run(BosWebApplication.class, args);
		/*
		 * ConfigurableApplicationContext run =
		 * SpringApplication.run(BosWebApplication.class, args); MyBean
		 * bean=run.getBean(MyBean.class); bean.doSomething();
		 */
	}

}
