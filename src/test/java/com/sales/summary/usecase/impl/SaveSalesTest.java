package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Sales;
import com.sales.summary.repository.SalesRepository;
import com.sales.summary.repository.dto.SalesDTO;
import com.sales.summary.repository.mappers.SalesDTOMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.sales.summary.fixtures.SalesDTOFixture.gimmeSalesDTO_id3_uuid_saleId5_total500_sellerJose_Saved;
import static com.sales.summary.fixtures.SalesDTOFixture.gimmeSalesDTO_uuid_saleId5_total500_sellerJose_Unsaved;
import static com.sales.summary.fixtures.SalesFixture.gimmeSales_saleId5_total500_sellerJose;
import static com.sales.summary.fixtures.UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveSalesTest {

    @InjectMocks
    private SaveSalesImpl saveSales;

    @Mock
    private SalesDTOMapper salesDTOMapper;

    @Mock
    private SalesRepository salesRepository;

    @Test
    void shouldReturnSalesSaved_WhenExecuteSalesUuid() {
        UUID uuid = gimmeUUID_62500db838794653a4615139a1be0e19();
        Sales sales = gimmeSales_saleId5_total500_sellerJose();
        Sales salesExpected = gimmeSales_saleId5_total500_sellerJose();
        SalesDTO salesDtoUnsaved = gimmeSalesDTO_uuid_saleId5_total500_sellerJose_Unsaved();
        SalesDTO salesDtoSaved = gimmeSalesDTO_id3_uuid_saleId5_total500_sellerJose_Saved();

        when(salesDTOMapper.toDTO(sales, uuid))
                .thenReturn(salesDtoUnsaved);

        when(salesRepository.save(salesDtoUnsaved))
                .thenReturn(salesDtoSaved);

        when(salesDTOMapper.toDomain(salesDtoSaved))
                .thenReturn(salesExpected);

        Sales result = saveSales.execute(sales, uuid);

        Assertions.assertEquals(salesExpected, result);

        verify(salesDTOMapper, times(1))
                .toDTO(sales, uuid);

        verify(salesRepository, times(1))
                .save(salesDtoUnsaved);

        verify(salesDTOMapper, times(1))
                .toDomain(salesDtoSaved);

    }

}