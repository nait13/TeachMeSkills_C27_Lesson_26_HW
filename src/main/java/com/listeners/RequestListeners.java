package com.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class RequestListeners implements ServletRequestListener {
    private static final Logger logger = LogManager.getLogger(RequestListeners.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("REQUEST ");
    }
}
