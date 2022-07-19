package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Summary;
import com.sales.summary.io.impl.FileHandlerImpl;
import com.sales.summary.usecase.GetSummaryAndSave;
import com.sales.summary.usecase.GetUUIDFromFileName;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import reactor.util.function.Tuple2;

import java.nio.file.Path;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log
public class GetSummaryAndSaveImpl implements GetSummaryAndSave {

    private final GetOutputResultImpl getOutputResult;
    private final GetUUIDFromFileName getUUIDFromFileName;
    private final FileHandlerImpl fileHandler;

    @Override
    public Summary execute(Tuple2<Path, Path> inputOutputTuple) {
        String input = inputOutputTuple.getT1().getFileName().toString();
        UUID uuid = getUUIDFromFileName.execute(input);

        log.info(uuid + ": Finding the summary result.");
        Summary summary = getOutputResult.execute(uuid);

        fileHandler.writeResultFile(inputOutputTuple.getT2(), summary);
        return summary;
    }

}
