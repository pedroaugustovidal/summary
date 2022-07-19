package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Summary;
import com.sales.summary.io.impl.FileHandlerImpl;
import com.sales.summary.usecase.GetUUIDFromFileName;
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
import static com.sales.summary.fixtures.SummaryFixture.gimmeSummary_totalCustomer2_totalSalesman_3_idBestSale7_worstSellerJose;
import static com.sales.summary.fixtures.UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetSummaryAndSaveTest {

    @InjectMocks
    private GetSummaryAndSaveImpl getSummaryAndSave;

    @Mock
    private GetOutputResultImpl getOutputResult;

    @Mock
    private GetUUIDFromFileName getUUIDFromFileName;

    @Mock
    private FileHandlerImpl fileHandler;

    @Test
    void shouldReturnSummary_WhenFileSaved() {
        Path inputPath = gimmeInputPath();
        Path outputPath = gimmeOutputPath();
        UUID uuid = gimmeUUID_62500db838794653a4615139a1be0e19();
        Summary summaryExpected = gimmeSummary_totalCustomer2_totalSalesman_3_idBestSale7_worstSellerJose();

        String fileName = inputPath.getFileName().toString();
        Tuple2<Path, Path> filesTuple = Tuples.of(inputPath, outputPath);

        when(getUUIDFromFileName.execute(fileName))
                .thenReturn(uuid);

        when(getOutputResult.execute(uuid))
                .thenReturn(summaryExpected);

        Summary result = getSummaryAndSave.execute(filesTuple);

        assertEquals(summaryExpected, result);

        verify(getUUIDFromFileName, times(1))
                .execute(any());

        verify(getOutputResult, times(1))
                .execute(any());

        verify(fileHandler, times(1))
                .writeResultFile(outputPath, summaryExpected);

    }

}