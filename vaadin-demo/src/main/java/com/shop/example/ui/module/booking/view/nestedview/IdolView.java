/**
 * @author Vinayak More
 *
 * @date 25-Nov-2016
 */
package com.shop.example.ui.module.booking.view.nestedview;

import javax.annotation.PostConstruct;

import com.shop.uikit.common.uihelper.components.ButtonHelper;
import com.shop.uikit.common.uihelper.components.TextAreaHelper;
import com.shop.uikit.common.uihelper.components.TextFieldHelper;
import com.shop.uikit.common.uihelper.layout.HorizontalLayoutHelper;
import com.shop.uikit.common.uihelper.layout.VerticalLayoutHelper;
import com.vaadin.server.ExternalResource;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

@VaadinSessionScope
@SpringComponent
public class IdolView extends CustomComponent {

    private static final long serialVersionUID = 3415498625835402163L;
    private HorizontalLayout layout;
    private TextField idolNo;
    private TextField name;
    private TextArea description, customerRequirements;
    private TextField height, width, length;
    private Image idolImage;
    private Upload uploadImage;
    private Button  submit, clear;


    @PostConstruct
    public void init() {
        layout = new HorizontalLayout();
        initComponents();
        addComponents();
        setCompositionRoot(layout);
    }

    private void initComponents() {
        idolNo = TextFieldHelper.helper("Idol No.").required().getField();
        name = TextFieldHelper.helper("Name").required().getField();
        description = TextAreaHelper.helper("Description").required().getField();
        description.setSizeFull();
        customerRequirements = TextAreaHelper.helper("Custumer requirements").required().getField();
        height = TextFieldHelper.helper("Height").required().getField();
        width = TextFieldHelper.helper("Width").getField();
        length = TextFieldHelper.helper("Length").getField();
        submit = ButtonHelper.helper("Submit").addStylePrimary().getField();
        clear = ButtonHelper.helper("Clear").addStyleSecondary().getField();
        idolImage = new Image("");
        uploadImage=new Upload(); 
        idolImage.setSource(new ExternalResource("https://s-media-cache-ak0.pinimg.com/originals/3d/74/87/3d7487b6f1d0efbca1dd5ff0bacbcfe1.jpg"));
    }


    private void addComponents() {
        layout.setSpacing(true);
        layout.addComponent(VerticalLayoutHelper.helper(idolImage,new HorizontalLayout(uploadImage)).setSpacing(true).getLayout());
        VerticalLayout hLayout = new VerticalLayout();
        hLayout.setSpacing(true);
        hLayout.setMargin(true);
        hLayout.addComponent(HorizontalLayoutHelper.helper(idolNo, name).setSpacing(true).getLayout());
        hLayout.addComponent(HorizontalLayoutHelper.helper(description).setSizeFull().getLayout());
        hLayout.addComponent(HorizontalLayoutHelper.helper(height, width, length).setSpacing(true).getLayout());
        hLayout.addComponent(new HorizontalLayout(customerRequirements));
        hLayout.addComponent(HorizontalLayoutHelper.helper(submit,clear).setSpacing(true).getLayout());
        layout.addComponent(hLayout);
        

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((clear == null) ? 0 : clear.hashCode());
        result = prime * result + ((customerRequirements == null) ? 0 : customerRequirements.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((height == null) ? 0 : height.hashCode());
        result = prime * result + ((idolImage == null) ? 0 : idolImage.hashCode());
        result = prime * result + ((idolNo == null) ? 0 : idolNo.hashCode());
        result = prime * result + ((layout == null) ? 0 : layout.hashCode());
        result = prime * result + ((length == null) ? 0 : length.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((submit == null) ? 0 : submit.hashCode());
        result = prime * result + ((uploadImage == null) ? 0 : uploadImage.hashCode());
        result = prime * result + ((width == null) ? 0 : width.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        IdolView other = (IdolView) obj;
        if (clear == null) {
            if (other.clear != null)
                return false;
        } else if (!clear.equals(other.clear))
            return false;
        if (customerRequirements == null) {
            if (other.customerRequirements != null)
                return false;
        } else if (!customerRequirements.equals(other.customerRequirements))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (height == null) {
            if (other.height != null)
                return false;
        } else if (!height.equals(other.height))
            return false;
        if (idolImage == null) {
            if (other.idolImage != null)
                return false;
        } else if (!idolImage.equals(other.idolImage))
            return false;
        if (idolNo == null) {
            if (other.idolNo != null)
                return false;
        } else if (!idolNo.equals(other.idolNo))
            return false;
        if (layout == null) {
            if (other.layout != null)
                return false;
        } else if (!layout.equals(other.layout))
            return false;
        if (length == null) {
            if (other.length != null)
                return false;
        } else if (!length.equals(other.length))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (submit == null) {
            if (other.submit != null)
                return false;
        } else if (!submit.equals(other.submit))
            return false;
        if (uploadImage == null) {
            if (other.uploadImage != null)
                return false;
        } else if (!uploadImage.equals(other.uploadImage))
            return false;
        if (width == null) {
            if (other.width != null)
                return false;
        } else if (!width.equals(other.width))
            return false;
        return true;
    }
}
