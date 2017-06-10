package com.retro.vaadin.module.login.component;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.retro.vaadin.kit.TemplateLayoutFactory;
import com.retro.vaadin.module.login.delegate.LoginDelegate;
import com.retro.vaadin.module.login.event.LoginSucessEvent;
import com.retro.vaadin.module.login.event.RegistrationEvent;
import com.retro.web.bean.User;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.UserError;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;


/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
@UIScope
public class LoginForm extends CustomComponent {

    private static final long serialVersionUID = 5442047306502871481L;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginForm.class);
    @Autowired
    LoginDelegate delegate;

    @Autowired
    ApplicationEventPublisher publisher;

    // private VerticalLayout layout;
    private TextField username;
    private PasswordField password;
    private Binder<User> beanFieldGroup;
    private CustomLayout customLayout;

    private Button loginButton;
    private Button registerButton;

    @PostConstruct
    public void init() {
        customLayout = TemplateLayoutFactory.getCustomLayout("login");
        initLoginForm();
        beanFieldGroup = new Binder<User>(User.class);
        beanFieldGroup.bindInstanceFields(this);
        beanFieldGroup.setBean(new User());
        addComponent();
        setCompositionRoot(customLayout);

    }

    private void addComponent() {
        customLayout.addComponent(username, "username");
        customLayout.addComponent(password, "password");
        customLayout.addComponent(loginButton, "login");
        customLayout.addComponent(registerButton,"register");
    }

    private void initLoginForm() {
        username = new TextField();
        username.addStyleName("form-control");
        username.focus();
        username.setSizeFull();
        password = new PasswordField();
        password.addStyleName("form-control");
        username.setPlaceholder("Username");
        password.setPlaceholder("Password");
        password.setSizeFull();
        loginButton = new Button("Login", e -> {
            submitForm();
        });
        loginButton.addShortcutListener(new EnterListener());
        loginButton.setSizeFull();
        loginButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        registerButton=new Button("Register", e->{
        	publisher.publishEvent(new RegistrationEvent());
        });
        registerButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        registerButton.setSizeFull();
    }

    public void submitForm() {
        try {
            if (beanFieldGroup.isValid()) {
                User user = delegate.isValidUser(beanFieldGroup.getBean());
                isLoginSucess(user);
            }
        } catch (Exception e1) {
            LOGGER.error("Exception while login in", e1);
            e1.printStackTrace();
        }
    }

    private void isLoginSucess(User user) {
        if (user != null && user.getUserId() > 0) {
            getSession().setAttribute(User.class.getName(), user.getUserId());
            publisher.publishEvent(new LoginSucessEvent());
        } else {
            showValidationVisible(true);
            password.setComponentError(new UserError("Invalid Username/Password"));
            username.focus();
        }
    }

    @SuppressWarnings("rawtypes")
    protected void showValidationVisible(boolean isVisible) {
        for (Iterator<Component> i = customLayout.iterator(); i.hasNext();) {
            Component c = i.next();
            if (c instanceof AbstractField)
                ((AbstractField) c).setRequiredIndicatorVisible(isVisible);
        }

    }

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
