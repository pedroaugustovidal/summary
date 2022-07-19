package com.sales.summary.io;

import com.sales.summary.domain.Summary;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileHandler {

    List<Path> findFilesToRead();

    Path writeEmptyResultFile(Path fileInput) throws IOException;

    void writeResultFile(Path fileInput, Summary summary);

}
