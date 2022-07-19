package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Summary;
import com.sales.summary.io.impl.FileHandlerImpl;
import com.sales.summary.usecase.GetSummaryAndSave;
import com.sales.summary.usecase.GetTupleInputAndOutputFile;
import com.sales.summary.usecase.ReadAndProcessFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.nio.file.Path;
import java.util.List;

import static com.sales.summary.fixtures.PathFixture.gimmeInputPath;
import static com.sales.summary.fixtures.PathFixture.gimmeOutputPath;
import static com.sales.summary.fixtures.SummaryFixture.gimmeSummary_totalCustomer2_totalSalesman_3_idBestSale7_worstSellerJose;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class ReadFilesServiceTest {

    @InjectMocks
    private ReadFilesServiceImpl readFilesService;

    @Mock
    private FileHandlerImpl fileHandler;

    @Mock
    private GetTupleInputAndOutputFile getTupleInputAndOutputFile;

    @Mock
    private ReadAndProcessFile readAndProcessFile;

    @Mock
    private GetSummaryAndSave getSummaryAndSave;

    @Test
    void shouldReturnSuccessfully_WhenExecute() {
        Path inputPath = gimmeInputPath();
        Path outputPath = gimmeOutputPath();
        List<Path> pathList = List.of(inputPath);
        Tuple2<Path, Path> pathsTuple2 = Tuples.of(inputPath, outputPath);
        Summary summaryExpected = gimmeSummary_totalCustomer2_totalSalesman_3_idBestSale7_worstSellerJose();

        when(fileHandler.findFilesToRead())
                .thenReturn(pathList);

        when(getTupleInputAndOutputFile.execute(inputPath))
                .thenReturn(Mono.just(pathsTuple2));

        when(getSummaryAndSave.execute(pathsTuple2))
                .thenReturn(summaryExpected);

        Assertions.assertDoesNotThrow(() ->
                readFilesService.execute());

        verify(fileHandler, times(1))
                .findFilesToRead();

        verify(getTupleInputAndOutputFile, times(1))
                .execute(inputPath);

        verify(readAndProcessFile, times(1))
                .execute(pathsTuple2);

        verify(getSummaryAndSave, times(1))
                .execute(pathsTuple2);


    }

}