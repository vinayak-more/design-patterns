package com.retro.vaadin.module.login.event;

import com.retro.vaadin.module.login.bean.UserRegistrationBean;

public class RegistrationSuccess {

	private UserRegistrationBean bean;

	public RegistrationSuccess(UserRegistrationBean bean) {
		this.bean = bean;
	}

	public UserRegistrationBean getBean() {
		return bean;
	}

	public void setBean(UserRegistrationBean bean) {
		this.bean = bean;
	}
	
	

}
