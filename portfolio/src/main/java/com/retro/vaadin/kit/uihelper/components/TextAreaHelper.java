/**
 * @author Vinayak More
 *
 * @date 26-Nov-2016
 */
package com.retro.vaadin.kit.uihelper.components;

import static org.springframework.util.StringUtils.capitalize;

import com.retro.vaadin.kit.uihelper.validator.EmptyFieldValidator;
import com.vaadin.ui.TextArea;


public class TextAreaHelper {
    public static Helper helper(String caption){
        return new Helper(caption);
    }
    public static class Helper{
        TextArea textArea;
        
        public Helper(String caption) {
            textArea=new TextArea(capitalize(caption)); 
            textArea.setNullRepresentation("");
        }

        public TextArea getField() {
            return textArea;
        }

        public Helper required() {
            textArea.setRequired(true);
            textArea.setRequiredError(textArea.getCaption() + " is required");
            textArea.addValidator(new EmptyFieldValidator(textArea.getCaption()));
            textArea.setValidationVisible(false);
            return this;
        }

        public Helper styleName(String styleName) {
            textArea.setStyleName(styleName);
            return this;
        }
    }
}
