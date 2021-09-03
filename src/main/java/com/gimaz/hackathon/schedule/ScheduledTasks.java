package com.gimaz.hackathon.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.text.SimpleDateFormat;
import java.util.Date;
@Configuration
@EnableScheduling
@Slf4j
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    Опрос блокчейна на списание и отправка тех, у кого надо списать денег
//    @Scheduled(fixedRate = 1000*60*60*24)
//    public void reportCurrentTime() {
//        log.info("The time is now " + dateFormat.format(new Date()));
//    }
}