package com.sales.summary.usecase.impl;

import com.sales.summary.io.impl.FileHandlerImpl;
import com.sales.summary.usecase.GetTupleInputAndOutputFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.io.IOException;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
@Log
public class GetTupleInputAndOutputFileImpl implements GetTupleInputAndOutputFile {

    private final FileHandlerImpl fileHandler;

    @Override
    public Mono<Tuple2<Path, Path>> execute(Path input) {
        Path outputFile;
        try {
            outputFile = fileHandler.writeEmptyResultFile(input);
            log.info("Empty output file created.");
        } catch (IOException e) {
            log.info("Empty output file was not created.");
            return Mono.error(e);
        }

        return Mono.just(Tuples.of(input, outputFile));
    }

}
