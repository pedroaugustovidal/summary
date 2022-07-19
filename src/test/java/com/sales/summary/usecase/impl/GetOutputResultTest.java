package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Summary;
import com.sales.summary.repository.CustomerRepository;
import com.sales.summary.repository.SalesRepository;
import com.sales.summary.repository.SalesmanRepository;
import com.sales.summary.repository.dto.SalesDTO;
import com.sales.summary.repository.dto.SalesmanDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.sales.summary.fixtures.SummaryFixture.gimmeSummary_totalCustomer2_totalSalesman_3_idBestSale7_worstSellerJose;
import static com.sales.summary.fixtures.UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class GetOutputResultTest {

    @InjectMocks
    private GetOutputResultImpl getOutputResult;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private SalesmanRepository salesmanRepository;

    @Mock
    private SalesRepository salesRepository;

    @Test
    void shouldReturnSummary_WhenExecRepository() {
        final UUID uuid = gimmeUUID_62500db838794653a4615139a1be0e19();
        Summary summaryExpected = gimmeSummary_totalCustomer2_totalSalesman_3_idBestSale7_worstSellerJose();

        when(customerRepository.countByUuidFile(uuid))
                .thenReturn(2L);

        when(salesmanRepository.countByUuidFile(uuid))
                .thenReturn(3L);

        when(salesmanRepository.findTopWorstSeller(uuid))
                .thenReturn(SalesmanDTO.builder().name("Jose").build());

        when(salesRepository.findHigherSale(uuid))
                .thenReturn(SalesDTO.builder()
                        .saleId(7L)
                        .build());

        Summary result = getOutputResult.execute(uuid);

        assertEquals(summaryExpected, result);

        verify(customerRepository, times(1))
                .countByUuidFile(any());

        verify(salesmanRepository, times(1))
                .countByUuidFile(any());

        verify(salesmanRepository, times(1))
                .findTopWorstSeller(any());

        verify(salesRepository, times(1))
                .findHigherSale(any());

    }

}