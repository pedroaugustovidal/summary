package com.sales.summary.usecase;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.nio.file.Path;

public interface GetTupleInputAndOutputFile {

    Mono<Tuple2<Path, Path>> execute(Path input);

}
