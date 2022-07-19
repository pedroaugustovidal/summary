package com.sales.summary.io.impl;

import com.sales.summary.io.GetFile;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class GetFileImpl implements GetFile {

    @Override
    public Path execute(String fullPathFile) {

        return Paths.get(fullPathFile);

    }
}
