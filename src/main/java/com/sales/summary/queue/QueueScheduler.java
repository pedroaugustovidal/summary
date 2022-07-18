package com.sales.summary.queue;

import com.sales.summary.service.QueueHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log
@Component
@RequiredArgsConstructor
public class QueueScheduler {

    private final QueueHandler queueHandler;

    @Scheduled(fixedDelay = 5000)
    public void doSchedule() throws InterruptedException {
        log.info("START ####");
        queueHandler.exec();
    }

}
