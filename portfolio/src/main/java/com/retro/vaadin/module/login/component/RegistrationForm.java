package com.retro.vaadin.module.login.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.util.StringUtils;

import com.retro.vaadin.kit.TemplateLayoutFactory;
import com.retro.vaadin.module.login.bean.UserRegistrationBean;
import com.retro.vaadin.module.login.delegate.LoginDelegate;
import com.retro.vaadin.module.login.event.BackToLoginEvent;
import com.retro.vaadin.module.login.event.RegistrationSuccess;
import com.retro.web.bean.User;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class RegistrationForm extends CustomComponent {

	private static final long serialVersionUID = -3627156938061101244L;

	private TextField username = new TextField();
	private PasswordField password = new PasswordField();
	private PasswordField confirmPassword = new PasswordField();
	private TextField recoveryPin = new TextField();
	private Button register = new Button("Register");
	private Button backToLogin = new Button("Back To Login");
	private Binder<UserRegistrationBean> binder = new Binder<UserRegistrationBean>(
			UserRegistrationBean.class);
	private UserRegistrationBean bean = new UserRegistrationBean();

	private CustomLayout layout;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private LoginDelegate delegate;

	private boolean isAvailable;

	@PostConstruct
	public void init() {
		layout = TemplateLayoutFactory.getCustomLayout("register");
		initFields();
		binder.forField(recoveryPin)
				.withConverter(
						new StringToIntegerConverter("Please Enter Number"))
				.bind("recoveryPin");
		binder.bindInstanceFields(this);
		addComponentsToLayout();
		setCompositionRoot(layout);
	}

	private void initFields() {
		register.setSizeFull();
		register.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		register.addClickListener(e -> {
			register();
		});
		backToLogin.setSizeFull();
		backToLogin.setStyleName(ValoTheme.BUTTON_PRIMARY);
		backToLogin.addClickListener(e -> {
			publisher.publishEvent(new BackToLoginEvent());
		});
		username.setSizeFull();
		username.addBlurListener(e -> {
			checkForUsernameAvailability();
		});
		password.setSizeFull();
		confirmPassword.setSizeFull();
		recoveryPin.setSizeFull();
	}

	private void checkForUsernameAvailability() {
		if(StringUtils.isEmpty(username.getValue())){
			return;
		}
		String usernameValue=username.getValue();
		isAvailable = delegate.isUsernameAvailable(usernameValue);
		if(!isAvailable){
			Notification.show(
					"This username is not available, Please try another one",
					Type.WARNING_MESSAGE);
		}
		
	}

	private void register() {
		try {
			binder.writeBean(bean);
			System.out.println(bean);
			if (!bean.getPassword().equals(bean.getConfirmPassword())) {
				Notification.show(
						"Password does not matches with Confirm Password",
						Type.WARNING_MESSAGE);
				password.focus();
				return;
			}
			if(!isAvailable){
				Notification.show(
						"This username is not available, Please try another one",
						Type.WARNING_MESSAGE);
				username.focus();
				return;
			}
			boolean success = delegate.register(bean);
			if(success){
				Notification.show(
						"Registration successfull",
						Type.WARNING_MESSAGE);
				getSession().setAttribute(User.class.getName(), bean.getUserId());
				publisher.publishEvent(new RegistrationSuccess(bean));
			}
		} catch (ValidationException e) {
			e.printStackTrace();
		}

	}

	private void addComponentsToLayout() {
		layout.addComponent(username, "username");
		layout.addComponent(password, "password");
		layout.addComponent(confirmPassword, "confirm-password");
		layout.addComponent(recoveryPin, "recovery-pin");
		layout.addComponent(register, "register");
		layout.addComponent(backToLogin, "back");

	}

}
