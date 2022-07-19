package com.sales.summary.usecase.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Path;
import java.util.UUID;

import static com.sales.summary.fixtures.PathFixture.gimmeInputPath;

@ExtendWith(MockitoExtension.class)
class GetUUIDFromFileNameTest {

    @InjectMocks
    private GetUUIDFromFileNameImpl getUUIDFromFileName;

    @Test
    void shouldReturnUuid_WhenExecute() {

        Path inputPath = gimmeInputPath();

        UUID result = getUUIDFromFileName.execute(String.valueOf(inputPath));

        Assertions.assertEquals("0c1c6fc3-244a-3c6b-9456-6e5e04598ba4", result.toString());

    }
}