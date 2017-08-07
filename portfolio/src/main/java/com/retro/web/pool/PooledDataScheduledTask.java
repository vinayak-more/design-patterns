package com.retro.web.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Vinayak More
 *
 * @date 07-Aug-2017
 */
@Component
public class PooledDataScheduledTask {

    @Autowired
    private PooledLauncher launcher;

    @Autowired
    Environment env;

    @Value("${schedular.initial.delay}")
    int initialDelay;

    @Value("${schedular.period}")
    int period;

    ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

    @PostConstruct
    public void init() {
        service.scheduleAtFixedRate(launcher.launch(), initialDelay, period, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void destroy() {
        service.shutdown();
    }

}
