package com.sales.summary.queue;

import com.sales.summary.usecase.impl.ReadFilesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Log
@RequiredArgsConstructor
public class QueueScheduler {

    private final ReadFilesServiceImpl readFiles;

    @Scheduled(fixedRate = 2000)
    public void doSchedule() {
        log.info("STARTING SCHEDULE AT " + LocalDateTime.now());
        readFiles.execute();
    }

}
