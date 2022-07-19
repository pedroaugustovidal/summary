package com.sales.summary.usecase.impl;

import com.sales.summary.usecase.GetUUIDFromFileName;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
public class GetUUIDFromFileNameImpl implements GetUUIDFromFileName {

    @Override
    public UUID execute(String input) {
        return UUID.nameUUIDFromBytes(input.getBytes(StandardCharsets.UTF_8));
    }

}
