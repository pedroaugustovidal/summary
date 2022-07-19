package com.sales.summary.usecase;

import java.util.UUID;

public interface ProcessLine {

    void execute(UUID uuid, String line);

}
