package com.study.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduleTasks.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private int subscriber = 0;

    @Scheduled(fixedRate = 1000, initialDelay = 1)
    public void scheduleExecuteType() {
        subscriber += 1;
        log.info("구독자가 추가 됐습니다.");
    }

    @Scheduled(fixedRate = 5000, initialDelay = 2)
    public void scheduleCurrentTime() {
        log.info("현재 구독자 : " + subscriber + " [현재시간(" + DATE_FORMAT.format(new Date()) + ")]" );
    }

    // @Scheduled(fixedDelay = 1000) // 이전 작업이 종료된 후 설정 시간 이후에 다시 시작.
    // @Scheduled(fixedRate = 1000) //  설정된 시간마다 시작한다. 즉, 이전 작업이 종료되지 않아도 시작한다.
    // @Scheduled(fixedRate = 1000, initialDelay = 1000) // 프로그램이 시작하자마자 작업하는게 아닌, 설정된 시간만큼 지연하여 작동을 시작한다.
    // @Scheduled(cron="* * * * *")
}
