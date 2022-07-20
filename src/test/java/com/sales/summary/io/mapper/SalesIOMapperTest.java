package com.sales.summary.io.mapper;

import com.sales.summary.domain.Sales;
import com.sales.summary.io.dto.SalesLayout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.sales.summary.fixtures.SalesFixture.gimmeSales_saleId5_total500_sellerJose;
import static com.sales.summary.fixtures.SalesLayoutFixture.gimmeSalesLayout_saleId5_total500_sellerJose;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SalesIOMapperTest {

    @InjectMocks
    private SalesIOMapper salesIOMapper;

    @Test
    void shouldReturnSales_WhenSalesLayout() {
        SalesLayout salesLayout = gimmeSalesLayout_saleId5_total500_sellerJose();
        Sales salesExpect = gimmeSales_saleId5_total500_sellerJose();

        Sales result = salesIOMapper.toDomain(salesLayout);

        assertEquals(salesExpect, result);
    }

}