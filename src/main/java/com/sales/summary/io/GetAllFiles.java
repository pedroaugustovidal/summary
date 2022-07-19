package com.sales.summary.io;

import java.nio.file.Path;
import java.util.List;

public interface GetAllFiles {
    List<Path> execute(String dir, String fileExtension);
}
