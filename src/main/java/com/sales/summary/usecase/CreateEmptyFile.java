package com.sales.summary.usecase;

import com.sales.summary.domain.exceptions.FileAlreadyCreatedException;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Log
public class CreateEmptyFile {

    public Path execute(String dir, final String fileName) throws IOException {

        if (!(dir.endsWith("/") && dir.endsWith("\\"))) {
            dir = dir + "/";
        }

        String fullPathFileName = dir + fileName;
        System.out.println("Tentando criar o arquivo: " + fullPathFileName);

        File file = new File(fullPathFileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
            return Paths.get(fullPathFileName);
        }

        System.out.println("File não foi criado: " + file.getName());
        throw new FileAlreadyCreatedException();

    }
}
