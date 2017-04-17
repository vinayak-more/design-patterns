package com.retro.vaadin.module.login.component;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.retro.vaadin.module.login.bean.LoginSucessEvent;
import com.retro.vaadin.module.login.delegate.LoginDelegate;
import com.retro.web.bean.User;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.server.UserError;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
@VaadinSessionScope
public class LoginForm extends CustomComponent {

    private static final long serialVersionUID = 5442047306502871481L;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginForm.class);
    @Autowired
    LoginDelegate delegate;

    @Autowired
    ApplicationEventPublisher publisher;

    private VerticalLayout layout;
    private TextField username;
    private PasswordField password;
    private BeanFieldGroup<User> beanFieldGroup;

    @PostConstruct
    public void init() {
        layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        layout.setSizeFull();
        initLoginForm();
        beanFieldGroup = new BeanFieldGroup<User>(User.class);
        beanFieldGroup.bindMemberFields(this);
        beanFieldGroup.setItemDataSource(new User());
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
        VerticalLayout content = new VerticalLayout(username, password, loginButton);
        content.setSpacing(true);
        content.setMargin(true);
        content.setComponentAlignment(username, Alignment.MIDDLE_CENTER);
        content.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
        content.setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);
        panel.setWidth(null);
        panel.addStyleName(ValoTheme.PANEL_WELL);
        panel.setContent(content);
        layout.addComponent(panel);
        layout.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
    }

    public void submitForm() {
        try {
            beanFieldGroup.commit();
            User user = delegate.isValidUser(beanFieldGroup.getItemDataSource().getBean());
            isLoginSucess(user);
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
        for (Iterator<Component> i = layout.iterator(); i.hasNext();) {
            Component c = i.next();
            if (c instanceof AbstractField)
                ((AbstractField) c).setValidationVisible(isVisible);
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
