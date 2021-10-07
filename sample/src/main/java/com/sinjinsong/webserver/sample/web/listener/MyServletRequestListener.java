package com.sinjinsong.webserver.sample.web.listener;

import com.sinjinsong.webserver.core.listener.ServletRequestListener;
import com.sinjinsong.webserver.core.listener.event.ServletRequestEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sinjinsong
 * @date 2018/5/3
 */
public class MyServletRequestListener implements ServletRequestListener {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MyServletRequestListener.class);
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("request destroy...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("request init...");
    }
}
