package com.sales.summary.service;

import com.sales.summary.usecase.Countador;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@RequiredArgsConstructor
@Log
public class QueueHandler {

    private final ReadFiles readFiles;
    private final Countador countador;


    @Async
    public void exec() throws InterruptedException {
//        ReaderReactive readerReactive = new ReaderReactive();

        readFiles.execute(countador.getAndAdd());

//        log.info("Starting thread...");
//        readerReactive.createFluxAction();
//
//        for (int i = 0; i < 2; i++) {
//            Thread.sleep(500);
//            readerReactive.test(String.valueOf(i));
//        }
//        readerReactive.test(null);
//
//        readerReactive.done();
    }

}