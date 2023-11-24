package com.WebServices.BOSWeb;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;


@Component
public class MyBean {
  private static final Logger log=Logger.getLogger(MyBean.class.getName());
  public void doSomething() {
	  log.info("---------Info----------");
  }
}
