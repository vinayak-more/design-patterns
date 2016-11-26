/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.example.common.uihelper.components;
import static org.springframework.util.StringUtils.capitalize;
import com.example.common.uihelper.validator.EmptyFieldValidator;
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
    }
}
