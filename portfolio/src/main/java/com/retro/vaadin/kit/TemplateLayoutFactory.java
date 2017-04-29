/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.retro.vaadin.kit;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.vaadin.ui.CustomLayout;

public class TemplateLayoutFactory {

    static Logger logger = LoggerFactory.getLogger(TemplateLayoutFactory.class);

    private TemplateLayoutFactory() {

    }

    public static CustomLayout getCustomLayout(String templateName) {
        String template = "templates/" + templateName + ".html";
        try {
            Resource resource=new ClassPathResource(template);
            InputStream is=resource.getInputStream();
            CustomLayout customLayout = new CustomLayout(is);
            customLayout.setSizeFull();
            return customLayout;
        } catch (IOException e) {
            logger.error("template file not found", e);
            return new CustomLayout();
        }

    }
}
