package com.sales.summary.usecase.impl;

import com.sales.summary.usecase.GetUUIDFromFileName;
import com.sales.summary.usecase.ProcessLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.nio.file.Path;
import java.util.UUID;

import static com.sales.summary.fixtures.PathFixture.gimmeInputPath;
import static com.sales.summary.fixtures.PathFixture.gimmeOutputPath;
import static com.sales.summary.fixtures.UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class ReadAndProcessFileTest {

    @InjectMocks
    private ReadAndProcessFileImpl readAndProcessFile;

    @Mock
    private GetUUIDFromFileName getUUIDFromFileName;

    @Mock
    private ProcessLine processLine;

    @Test
    void shouldReturnSuccessfully_WhenExecuteTuple2Paths() {
        Path inputPath = gimmeInputPath();
        Path outputPath = gimmeOutputPath();
        Tuple2<Path, Path> filesTuple = Tuples.of(inputPath, outputPath);
        UUID uuid = gimmeUUID_62500db838794653a4615139a1be0e19();

        when(getUUIDFromFileName.execute(inputPath.getFileName().toString()))
                .thenReturn(uuid);

        Assertions.assertDoesNotThrow(() ->
                readAndProcessFile.execute(filesTuple));

        verify(getUUIDFromFileName, times(1))
                .execute(any());

    }

}