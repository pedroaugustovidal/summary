package com.sales.summary.usecase;

import lombok.extern.java.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

import java.util.Objects;

@Log
public class ReaderReactive {

    Many sink;
    Flux fluxOpen;

    public ReaderReactive() {
        this.sink = Sinks.many().unicast().onBackpressureBuffer();
        this.fluxOpen = sink.asFlux().publish().autoConnect();
    }

    public void test(String data) {
        if (Objects.isNull(data))
            sink.tryEmitError(new RuntimeException("Empty data"));

        log.info("Tentando emitir: " + data);
        sink.tryEmitNext(data);
    }

    public void createFluxAction() {

        fluxOpen.doOnNext(e -> System.out.println("Received: " + e))
                .doOnComplete(() -> System.out.println(">>>123 Stream ended"))
                .doOnSubscribe(s -> System.out.println(">>>123 Subscribed to stream"))
                .doOnError(e -> System.out.println("Error: " + e.toString()))
                .subscribe();

    }

    public void done() {
        sink.tryEmitComplete();
    }
}
