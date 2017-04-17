/**
 * @author Vinayak More
 * @date 17-Apr-2017
 */
package com.retro.vaadin.module.investment.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
public class RefreshInvestmentData extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    public RefreshInvestmentData(Object source) {
        super(source);
    }

}
