package com.retro.vaadin.kit;

import com.retro.web.bean.User;
import com.vaadin.server.VaadinSession;

/**
 * @author Vinayak More
 *
 * @date 18-Apr-2017
 */
public abstract class AbstractDelegate {
    protected Long getUserId() {
        return (Long) VaadinSession.getCurrent().getAttribute(User.class.getName());
    }
}
