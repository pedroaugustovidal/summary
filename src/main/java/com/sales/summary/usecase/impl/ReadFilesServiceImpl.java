package com.sales.summary.usecase.impl;

import com.sales.summary.io.impl.FileHandlerImpl;
import com.sales.summary.usecase.GetSummaryAndSave;
import com.sales.summary.usecase.GetTupleInputAndOutputFile;
import com.sales.summary.usecase.ReadAndProcessFile;
import com.sales.summary.usecase.ReadFilesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Log
public class ReadFilesServiceImpl implements ReadFilesService {

    private final FileHandlerImpl fileHandler;
    private final GetTupleInputAndOutputFile getTupleInputAndOutputFile;
    private final ReadAndProcessFile readAndProcessFile;
    private final GetSummaryAndSave getSummaryAndSave;

    @Override
    public void execute() {

        Mono.just(fileHandler.findFilesToRead())
                .flatMapMany(Flux::fromIterable)
                .flatMap(getTupleInputAndOutputFile::execute)
                .doOnNext(readAndProcessFile::execute)
                .map(getSummaryAndSave::execute)
                .subscribe();

    }

}
