/**
 * @author Vinayak More
 *
 * @date 20-Nov-2016
 */
package com.example.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.vaadin.ui.CustomLayout;

public class TemplateLayoutFactory {

    static Logger logger = LoggerFactory.getLogger(TemplateLayoutFactory.class);

    private TemplateLayoutFactory() {

    }

    public static CustomLayout getCustomLayput(String templateName) {
        String template = "templates/" + templateName + ".html";
        try {
            Resource resource=new ClassPathResource(template);
            InputStream is=resource.getInputStream();
            return new CustomLayout(is);
        } catch (IOException e) {
            logger.error("template file not found", e);
            return new CustomLayout();
        }

    }
}
