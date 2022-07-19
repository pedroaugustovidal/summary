package com.sales.summary.io;

import java.io.IOException;
import java.nio.file.Path;

public interface WriteEmptyFile {
    Path execute(String dir, String fileName) throws IOException;
}
