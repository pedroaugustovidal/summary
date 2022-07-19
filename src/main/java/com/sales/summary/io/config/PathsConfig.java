package com.sales.summary.io.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class PathsConfig {

    private String inputDirectory;
    private String outputDirectory;

    public PathsConfig() {
        this.inputDirectory = System.getenv("HOMEPATH") + "/data/in/";
        this.outputDirectory = System.getenv("HOMEPATH") + "/data/out/";
    }


}
