/**
 * @author Vinayak More
 *
 * @date 14-Jan-2017
 */
package com.example.ui.module.login;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.common.uihelper.view.AbstactView;
import com.example.ui.LoginUI;
import com.vaadin.addon.responsive.Responsive;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.UserError;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@VaadinSessionScope
@SpringView(name = LoginView.VIEW_NAME)
public class LoginView extends AbstactView<LoginController> {
	private static final long serialVersionUID = -896245143682017108L;
	public static final String VIEW_NAME = "login";
	private VerticalLayout layout;
	private TextField username;
	private PasswordField password;
	private BeanFieldGroup<LoginBean> beanFieldGroup;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginView.class);

	@PostConstruct
	public void init() {
		layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		layout.setSizeFull();
		initLoginForm();
		beanFieldGroup = new BeanFieldGroup<LoginBean>(LoginBean.class);
		beanFieldGroup.bindMemberFields(this);
		beanFieldGroup.setItemDataSource(new LoginBean());
//		makeResponsive();
		new Responsive(layout);
		setCompositionRoot(layout);
	}

	private void initLoginForm() {
		Panel panel = new Panel();
		username = new TextField();
		username.focus();
		password = new PasswordField();
		username.setInputPrompt("Username");
		password.setInputPrompt("Password");
		Button loginButton = new Button("Login", e -> {
			submitForm();
		});
		loginButton.addShortcutListener(new EnterListener());
		loginButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
		VerticalLayout content = new VerticalLayout(username, password,
				loginButton);
		content.setSpacing(true);
		content.setMargin(true);
		content.setComponentAlignment(username, Alignment.MIDDLE_CENTER);
		content.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
		content.setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);
		panel.setWidth(null);
		panel.addStyleName(ValoTheme.PANEL_WELL);
		panel.setContent(content);
		new Responsive(panel);
		layout.addComponent(panel);
		layout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
	}

	public void submitForm() {
		try {
			beanFieldGroup.commit();
			boolean onLoginEvent = getController()
					.onLoginEvent(
							new LoginEvent(beanFieldGroup.getItemDataSource()
									.getBean()));
			isLoginSucess(onLoginEvent);
		} catch (Exception e1) {
			LOGGER.error("Exception while login in", e1);
			e1.printStackTrace();
		}
	}

	public void isLoginSucess(boolean success) {
		if (success) {
			password.setComponentError(null);
			showValidationVisible(false);
			Notification.show("Sucess");
			((LoginUI) getParent()).loginSucess();
		} else {
			showValidationVisible(true);
			password.setComponentError(new UserError(
					"Invalid Username/Password"));
			username.focus();
		}
	}

	@SuppressWarnings("rawtypes")
	protected void showValidationVisible(boolean isVisible) {
		for (Iterator<Component> i = layout.iterator(); i.hasNext();) {
			Component c = i.next();
			if (c instanceof AbstractField)
				((AbstractField) c).setValidationVisible(isVisible);
		}

	}

	/*protected void makeResponsive() {
		for (Iterator<Component> i = layout.iterator(); i.hasNext();) {
			Component c = i.next();
			Responsive.makeResponsive(c);
		}

	}*/

	private class EnterListener extends ShortcutListener {

		private static final long serialVersionUID = 1265855409596360813L;

		public EnterListener() {
			super("", ShortcutAction.KeyCode.ENTER, null);

		}

		@Override
		public void handleAction(Object sender, Object target) {
			submitForm();
		}

	}
}
