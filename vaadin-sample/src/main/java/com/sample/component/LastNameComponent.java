package com.sample.component;

import javax.annotation.PostConstruct;

import com.sample.bean.Person;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Vinayak More
 *
 * @date 28-Mar-2017
 */
@SpringComponent
@VaadinSessionScope
public class LastNameComponent extends CustomComponent {

    private static final long serialVersionUID = 5906578655891820915L;

    private TextField lastName;
    private VerticalLayout layout;
    @PostConstruct
    public void init() {
        lastName = new TextField("Last Name");
        layout=new VerticalLayout();
        layout.addComponent(lastName);
        setCompositionRoot(layout);
    }
    public void setBeanField(BeanFieldGroup<Person> beanFieldGroup) {
        beanFieldGroup.bindMemberFields(this);
    }
}
