package com.sales.summary.io.impl;

import com.sales.summary.domain.Summary;
import com.sales.summary.io.*;
import com.sales.summary.io.config.PathsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log
public class FileHandlerImpl implements FileHandler {

    private final PathsConfig pathsConfig;
    private final GetFile getFile;
    private final GetAllFiles getAllFiles;
    private final WriteFile writeFile;
    private final WriteEmptyFile writeEmptyFile;

    @Override
    public List<Path> findFilesToRead() {
        log.info("Finding files to process...");
        return getAllFiles.execute(pathsConfig.getInputDirectory(), "dat");
    }

    @Override
    public Path writeEmptyResultFile(Path fileInput) throws IOException {
        String fileOutputName = getFileOutputName(fileInput);
        return writeEmptyFile.execute(pathsConfig.getOutputDirectory(), fileOutputName);
    }

    @Override
    public void writeResultFile(Path fileOutput, Summary summary) {
        log.info("Writing output file: " + fileOutput);
        writeFile.execute(fileOutput.toString(), summary.toString());
    }

    private String getFileOutputName(Path fileInput) {
        return fileInput.getFileName()
                .toString()
                .replace(".dat", ".done.dat");
    }


}
