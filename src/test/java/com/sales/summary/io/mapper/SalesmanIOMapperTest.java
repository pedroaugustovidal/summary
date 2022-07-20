package com.sales.summary.io.mapper;

import com.sales.summary.domain.Salesman;
import com.sales.summary.io.dto.SalesmanLayout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.sales.summary.fixtures.SalesmanFixture.gimmeSalesman_cpf12345678901_nameJose;
import static com.sales.summary.fixtures.SalesmanLayoutFixture.gimmeSalesmanLayout_cpf12345678901_nameJose;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SalesmanIOMapperTest {

    @InjectMocks
    private SalesmanIOMapper salesmanIOMapper;

    @Test
    void shouldReturnSalesman_WhenSalesmanLayout() {
        SalesmanLayout salesmanLayout = gimmeSalesmanLayout_cpf12345678901_nameJose();
        Salesman salesmanExpected = gimmeSalesman_cpf12345678901_nameJose();

        Salesman result = salesmanIOMapper.toDomain(salesmanLayout);

        assertEquals(salesmanExpected, result);
    }

}