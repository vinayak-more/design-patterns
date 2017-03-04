/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.shop.uikit.common.uihelper.validator;

import org.springframework.util.StringUtils;

import com.vaadin.data.Validator;

public class EmptyFieldValidator implements Validator {

    private static final long serialVersionUID = 2366744773192771574L;
    private String fieldCaption;
    public EmptyFieldValidator(String caption) {
        this.fieldCaption=caption;
    }

    @Override
    public void validate(Object value) throws InvalidValueException {
        if(value instanceof String && StringUtils.isEmpty(value)){
           throw new InvalidValueException(fieldCaption + "cannot be black");
        }

    }

}
