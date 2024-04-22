package com.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class AppContextServletListeners implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(AppContextServletListeners.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Initialized APP");
    }
}
