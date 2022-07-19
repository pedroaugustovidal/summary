package com.sales.summary.usecase;

import com.sales.summary.domain.Summary;
import reactor.util.function.Tuple2;

import java.nio.file.Path;

public interface GetSummaryAndSave {

    Summary execute(Tuple2<Path, Path> inputOutputTuple);

}
