package com.sales.summary.usecase.impl;

import com.sales.summary.io.impl.FileHandlerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.io.IOException;
import java.nio.file.Path;

import static com.sales.summary.fixtures.PathFixture.gimmeInputPath;
import static com.sales.summary.fixtures.PathFixture.gimmeOutputPath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetTupleInputAndOutputFileTest {

    @InjectMocks
    private GetTupleInputAndOutputFileImpl getTupleInputAndOutputFile;

    @Mock
    private FileHandlerImpl fileHandler;

    @Test
    void shouldReturnMonoTuple2InputAndOutputFile_WhenSaveOutputEmptyFile() throws IOException {
        Path inputPath = gimmeInputPath();
        Path outputPath = gimmeOutputPath();
        Tuple2<Path, Path> filesTupleExpected = Tuples.of(inputPath, outputPath);

        when(fileHandler.writeEmptyResultFile(inputPath))
                .thenReturn(outputPath);

        Mono<Tuple2<Path, Path>> result = getTupleInputAndOutputFile.execute(inputPath);

        StepVerifier.create(result)
                .consumeNextWith(filesTuple ->
                        assertEquals(filesTupleExpected, filesTuple))
                .expectComplete()
                .verify();

        verify(fileHandler, times(1))
                .writeEmptyResultFile(any());

    }

    @Test
    void shouldThrowError_WhenOccurSaveError() throws IOException {
        Path inputPath = gimmeInputPath();
        Path outputPath = gimmeOutputPath();
        Tuple2<Path, Path> filesTupleExpected = Tuples.of(inputPath, outputPath);

        when(fileHandler.writeEmptyResultFile(inputPath))
                .thenThrow(IOException.class);

        Mono<Tuple2<Path, Path>> result = getTupleInputAndOutputFile.execute(inputPath);

        StepVerifier.create(result)
                .expectError()
                .verify();
    }

}