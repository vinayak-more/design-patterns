/**
 * @author Vinayak More
 *
 * @date 25-Nov-2016
 */
package com.example.ui.module.booking.view.nestedview;

import javax.annotation.PostConstruct;

import com.example.common.TemplateLayoutFactory;
import com.example.common.uihelper.components.ButtonHelper;
import com.example.common.uihelper.components.TextAreaHelper;
import com.example.common.uihelper.components.TextFieldHelper;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

@VaadinSessionScope
@SpringComponent
public class IdolView extends CustomComponent {

    private static final long serialVersionUID = 3415498625835402163L;
    private CustomLayout layout;
    private TextField idolNo;
    private TextField name;
    private TextArea description;
    private TextField height, width, length;
    private Image idolImage;
    private Button upload, submit, clear;


    @PostConstruct
    public void init() {
        layout = TemplateLayoutFactory.getCustomLayput("idol-view");
        initComponents();
        addComponents();
        setCompositionRoot(layout);
    }

    private void initComponents() {
        idolNo = TextFieldHelper.helper("Idol No.").required().getField();
        name = TextFieldHelper.helper("Name").required().getField();
        description = TextAreaHelper.helper("Description").required().getField();
        height = TextFieldHelper.helper("Height").required().getField();
        width = TextFieldHelper.helper("Width").getField();
        length = TextFieldHelper.helper("Length").getField();
        upload = ButtonHelper.helper("Upload").addStylePrimary().getField();
        submit = ButtonHelper.helper("Submit").addStylePrimary().getField();
        clear = ButtonHelper.helper("Clear").addStyleSecondary().getField();
        idolImage = new Image();
    }


    private void addComponents() {
        layout.addComponent(idolImage, "idol-image");
        layout.addComponent(idolNo, "idon-no");
        layout.addComponent(name, "name");
        layout.addComponent(description, "description");
        layout.addComponent(height, "height");
        layout.addComponent(width, "width");
        layout.addComponent(length, "length");
        layout.addComponent(upload, "upload");
        layout.addComponent(submit, "submit");
        layout.addComponent(clear, "clear");
    }

}
