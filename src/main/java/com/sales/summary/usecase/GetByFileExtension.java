package com.sales.summary.usecase;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log
public class GetByFileExtension {

    public List<Path> execute(String dir, final String fileExtension) {

        Path path = Paths.get(dir);

        try {
            return getFilesListInPath(fileExtension, path);
        } catch (IOException e) {
            throw new RuntimeException("Ocorreu um erro ao acessar o diretório ou os arquivos.");
        }
    }

    private List<Path> getFilesListInPath(String fileExtension, Path path) throws IOException {
        return Files.walk(path)
                .filter(Files::isRegularFile)
                .filter(p -> p.getFileName()
                        .toString()
                        .endsWith(fileExtension))
                .collect(Collectors.toList());
    }

}
