package com.sales.summary.usecase;

import reactor.util.function.Tuple2;

import java.nio.file.Path;
import java.util.UUID;

public interface ReadAndProcessFile {

    void execute(Tuple2<Path, Path> inputOutputTuple);

    void execute(Path path, UUID uuid);

}
