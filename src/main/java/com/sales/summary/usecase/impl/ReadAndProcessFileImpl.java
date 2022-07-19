package com.sales.summary.usecase.impl;

import com.sales.summary.domain.exceptions.ErrorLineProcessingException;
import com.sales.summary.usecase.GetUUIDFromFileName;
import com.sales.summary.usecase.ProcessLine;
import com.sales.summary.usecase.ReadAndProcessFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import reactor.util.function.Tuple2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log
public class ReadAndProcessFileImpl implements ReadAndProcessFile {

    private final GetUUIDFromFileName getUUIDFromFileName;
    private final ProcessLine processLine;

    @Override
    public void execute(Tuple2<Path, Path> inputOutputTuple) {
        String input = inputOutputTuple.getT1().getFileName().toString();
        UUID uuid = getUUIDFromFileName.execute(input);

        this.execute(inputOutputTuple.getT1(), uuid);
    }

    @Override
    public void execute(Path path, UUID uuid) {
        try {
            log.info("Preparing to read the file...");
            BufferedReader reader = Files.newBufferedReader(path);

            log.info("Start scanning lines from the file...");
            String line;
            while ((line = reader.readLine()) != null) {
                processLine.execute(uuid, line);
            }
            log.info("Lines scanning finished...");

            reader.close();
        } catch (IOException e) {
            throw new ErrorLineProcessingException();
        }

    }


}
