package com.wilk.group.Project_web_admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Async
    @Scheduled(fixedDelay = 10000)
    public void reportCurrentTime() throws InterruptedException {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Async
    @Scheduled(fixedDelay = 10000)
    public void reportStatusFtp() throws InterruptedException, IOException {
        log.info(RouterPanel.getStatus("http://192.168.0.1"));
    }
}

