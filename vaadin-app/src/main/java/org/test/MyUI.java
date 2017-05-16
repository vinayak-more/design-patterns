package org.test;

import java.util.Iterator;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window (or tab) or some part of a html
 * page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be overridden to add component
 * to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    private static final long serialVersionUID = -8908616934031237847L;
    private CustomLayout layout;
    private VerticalLayout mainLayout;
    private TextField username;
    private PasswordField password;
    private Button login, forgotPassword,register;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        layout = new CustomLayout("login");
        initUI();
        setContent(mainLayout);
    }

    private void initUI() {
        username = new TextField();
        username.setInputPrompt("Username");
        username.setIcon(FontAwesome.USER);
        username.setRequired(true);
        username.setRequiredError("Username is required");
        
        password = new PasswordField();
        password.setIcon(FontAwesome.KEY);
        password.setInputPrompt("Password");
        password.setRequired(true);
        password.setRequiredError("Password is required");
        login = new Button("Login", new ClickListener() {

            private static final long serialVersionUID = -6603460433878083191L;

            @Override
            public void buttonClick(ClickEvent event) {
                if(validateInputs()){
                    showValidationVisible(false);
                    layout.addComponent(new Label("Thanks for login in " + username.getValue()),"a");
                }else{
                    showValidationVisible(true);
                }
            }
        });
        forgotPassword = new Button("Forgot Password", new ClickListener() {

            private static final long serialVersionUID = 520217252908888656L;

            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Sooo you forgot password Mr. " + username.getValue()),"a");
            }
        });
        BrowserWindowOpener opener=new BrowserWindowOpener(RegisterUI.class);
        opener.setFeatures("height=200,width=300,resizable");
        register =new Button("Register");
        opener.extend(register);
        layout.addComponent(username, "username");
        layout.addComponent(password, "password");
        layout.addComponent(login, "login");
        layout.addComponent(forgotPassword, "forgot-password");
        layout.addComponent(register,"a");
        layout.setSizeFull();
        showValidationVisible(false);
        BrowserFrame browser = new BrowserFrame("Browser",
                new ExternalResource("http://demo.vaadin.com/sampler/"));
            browser.setWidth("600px");
            browser.setHeight("400px");
            layout.addComponent(browser);
        mainLayout=new VerticalLayout(layout);
        mainLayout.addComponent(browser);
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);
    }

    protected boolean validateInputs() {
        if(username.isEmpty()){
            return false;
        }
        if(password.isEmpty()){
            return false;
        }
        return true;
    }

    @SuppressWarnings("rawtypes")
    protected void showValidationVisible(boolean isVisible) {
        for (Iterator<Component> i = layout.iterator(); i.hasNext();) {
            Component c = i.next();
            if (c instanceof AbstractField)
                ((AbstractField) c).setValidationVisible(isVisible);
        }
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

        private static final long serialVersionUID = 4761276553072766217L;
    }
}
