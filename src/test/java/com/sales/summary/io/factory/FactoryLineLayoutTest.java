package com.sales.summary.io.factory;

import com.sales.summary.domain.exceptions.CustomerWrongFormatException;
import com.sales.summary.domain.exceptions.SalesWrongFormatException;
import com.sales.summary.domain.exceptions.SalesmanWrongFormatException;
import com.sales.summary.io.dto.LineLayout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.sales.summary.fixtures.LineLayoutFixture.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FactoryLineLayoutTest {

    @InjectMocks
    private FactoryLineLayout factoryLineLayout;

    @Test
    void shouldReturnLineLayout_WhenSalesmanLayout() {
        final String line = "001ç12345678901çJoseç50000";
        LineLayout lineLayoutExpected = gimmeLineLayout_SalesmanLayout_cpf12345678901_nameJose();

        LineLayout result = factoryLineLayout.getLineLayout(line);

        assertEquals(lineLayoutExpected, result);
    }

    @Test
    void shouldReturnLineLayout_WhenCustomerLayout() {
        final String line = "002ç12345678012345çPedroçRural";
        LineLayout lineLayoutExpected = gimmeLineLayout_CustomerLayout_namePedro_cnpj12345678012345();

        LineLayout result = factoryLineLayout.getLineLayout(line);

        assertEquals(lineLayoutExpected, result);
    }

    @Test
    void shouldReturnLineLayout_WhenSalesLayout() {
        final String line = "003ç5ç[1-2-10,2-4-5,3-20-1,4-16-2.50,5-10-40]çJose";
        LineLayout lineLayoutExpected = gimmeLineLayout_SalesLayout_saleId5_total500_sellerJose();

        LineLayout result = factoryLineLayout.getLineLayout(line);

        assertEquals(lineLayoutExpected, result);
    }

    @Test
    void shouldThrowsSalesmanWrongFormatException_WhenSalesmanLayoutInvalidFormat() {
        final String line = "001ç12345678901çJoseç50000ç001";

        assertThrows(SalesmanWrongFormatException.class,
                () -> factoryLineLayout.getLineLayout(line));

    }

    @Test
    void shouldThrowsCustomerWrongFormatException_WhenCustomerLayoutInvalidFormat() {
        final String line = "002ç12345678012345çPedroçRuralçInvalid";

        assertThrows(CustomerWrongFormatException.class,
                () -> factoryLineLayout.getLineLayout(line));
    }

    @Test
    void shouldThrowsSalesWrongFormatException_WhenSalesLayoutInvalidFormat() {
        final String line = "003ç5ç[1-2-10,2-4-5,3-20-1,4-16-2.50,5-10-40]";

        assertThrows(SalesWrongFormatException.class,
                () -> factoryLineLayout.getLineLayout(line));
    }

}