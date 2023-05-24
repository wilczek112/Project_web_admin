package com.wilk.group.Project_web_admin;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableAsync
@ConditionalOnProperty(name="schedulre.enebled", matchIfMissing = true)
public class SchedulerConfig{

}