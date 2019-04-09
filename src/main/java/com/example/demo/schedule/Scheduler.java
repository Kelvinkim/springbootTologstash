package com.example.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

//https://www.callicoder.com/spring-boot-task-scheduling-with-scheduled-annotation/
@Slf4j
@Service
public class Scheduler {

    DateTimeFormatter dateTimeFormatter;

    @PostConstruct
    public void init(){
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    }
    @Scheduled(fixedDelay = 2000)
    public void scheduleTaskWithFixedDelay() {
        log.info("Fixed Delay Task :: Execution Time - {}, {}",Thread.currentThread().getName() ,dateTimeFormatter.format(LocalDateTime.now()));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            log.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }
    }
}
