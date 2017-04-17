/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.retro.vaadin.kit.uihelper.components;
import static org.springframework.util.StringUtils.capitalize;

import com.retro.vaadin.kit.uihelper.validator.EmptyFieldValidator;
import com.vaadin.data.util.converter.StringToDoubleConverter;
import com.vaadin.data.validator.DoubleRangeValidator;
import com.vaadin.ui.TextField;

public class TextFieldHelper {

    public static Helper helper(String caption){
        return new Helper(caption);
    }
    public static class Helper{
        TextField textField;
        
        public Helper(String caption) {
            textField=new TextField(capitalize(caption)); 
            textField.setNullRepresentation("");
        }

        public TextField getField() {
            return textField;
        }

        public Helper required() {
            textField.setRequired(true);
            textField.setRequiredError(textField.getCaption() + " is required");
            textField.addValidator(new EmptyFieldValidator(textField.getCaption()));
            textField.setValidationVisible(false);
            return this;
        }

        public Helper styleName(String styleName) {
            textField.setStyleName(styleName);
            return this;
        }
        public Helper checkDouble() {
            textField.setConverter(new StringToDoubleConverter());
            textField.addValidator(new DoubleRangeValidator("Enter a valid " + textField.getCaption(), null, null));
            return this;
        }
    }
}
