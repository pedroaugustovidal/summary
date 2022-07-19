package com.sales.summary.io.impl;

import com.sales.summary.io.WriteFile;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
@Log
public class WriteFileImpl implements WriteFile {

    @Override
    public void execute(String fullPathFile, String result) {
        try {
            log.info("Starting to write: " + fullPathFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathFile, true));
            writer.write(result);
            writer.close();
            log.info("Finished to write: " + fullPathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
