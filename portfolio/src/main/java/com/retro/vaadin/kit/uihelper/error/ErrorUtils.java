/**
 * @author Vinayak More
 *
 * @date 05-Mar-2017
 */
package com.retro.vaadin.kit.uihelper.error;

import java.util.Collection;

import org.springframework.util.CollectionUtils;

import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Field;

public class ErrorUtils {

    public static void showValidationVisible(Collection<Field<?>> collection, boolean visible) {
        if (CollectionUtils.isEmpty(collection)) {
            return;
        }
        for (Field<?> abstractField : collection) {
            ((AbstractField<?>)abstractField).setValidationVisible(visible);
        }
    }

}
