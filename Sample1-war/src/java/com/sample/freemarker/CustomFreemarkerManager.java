/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.freemarker;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.ServletContext;
import static org.apache.struts2.views.freemarker.FreemarkerManager.DEFAULT_CONTENT_TYPE;

/**
 *
 * @author Dias Nurul Arifin <dias@nsiapay.net>
 */
public class CustomFreemarkerManager extends org.apache.struts2.views.freemarker.FreemarkerManager {

    private static final Logger LOG = LoggerFactory.getLogger(CustomFreemarkerManager.class);

    @Override
    public void init(ServletContext servletContext) throws TemplateException {
        try {
            config = createConfiguration(servletContext);
            
            // Set defaults:
            config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            contentType = DEFAULT_CONTENT_TYPE;

            // Process object_wrapper init-param out of order:
            wrapper = createObjectWrapper(servletContext);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Using object wrapper of class " + wrapper.getClass().getName());
            }
            config.setObjectWrapper(wrapper);
            templatePath = "D:\\apps\\sample\\template\\tools";
            System.out.println("template path >> " + templatePath);
            FileTemplateLoader templateLoader = new FileTemplateLoader(new File(templatePath));
            config.setTemplateLoader(templateLoader);
            loadSettings(servletContext);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CustomFreemarkerManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Configuration createConfiguration(ServletContext servletContext)
            throws TemplateException {
        Configuration configuration = new Configuration();
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        if (mruMaxStrongSize > 0) {
            configuration.setSetting(Configuration.CACHE_STORAGE_KEY, "strong:" + mruMaxStrongSize);
        }
        if (templateUpdateDelay != null) {
            configuration.setSetting(Configuration.TEMPLATE_UPDATE_DELAY_KEY,
                    templateUpdateDelay);
        }
        if (encoding != null) {
            configuration.setDefaultEncoding(encoding);
        }
        configuration.setWhitespaceStripping(true);
        return configuration;
    }
}