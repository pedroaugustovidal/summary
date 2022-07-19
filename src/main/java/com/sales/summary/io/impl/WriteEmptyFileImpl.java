package com.sales.summary.io.impl;

import com.sales.summary.domain.exceptions.FileAlreadyCreatedException;
import com.sales.summary.io.WriteEmptyFile;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Log
public class WriteEmptyFileImpl implements WriteEmptyFile {

    @Override
    public Path execute(String dir, final String fileName) throws IOException {


        String fullPathFileName = dir + fileName;

        File file = new File(fullPathFileName);
        if (file.createNewFile()) {
            return Paths.get(fullPathFileName);
        }
        throw new FileAlreadyCreatedException();

    }
}
