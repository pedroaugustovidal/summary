package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Customer;
import com.sales.summary.domain.Sales;
import com.sales.summary.domain.Salesman;
import com.sales.summary.fixtures.SalesmanFixture;
import com.sales.summary.io.dto.CustomerLayout;
import com.sales.summary.io.dto.LineLayout;
import com.sales.summary.io.dto.SalesLayout;
import com.sales.summary.io.dto.SalesmanLayout;
import com.sales.summary.io.factory.FactoryLineLayout;
import com.sales.summary.io.mapper.CustomerIOMapper;
import com.sales.summary.io.mapper.SalesIOMapper;
import com.sales.summary.io.mapper.SalesmanIOMapper;
import com.sales.summary.usecase.SaveCustomer;
import com.sales.summary.usecase.SaveSales;
import com.sales.summary.usecase.SaveSalesman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.sales.summary.fixtures.CustomerFixture.gimmeCustomer_namePedro_cnpj12345678012345;
import static com.sales.summary.fixtures.LineLayoutFixture.*;
import static com.sales.summary.fixtures.SalesFixture.gimmeSales_saleId5_total500_sellerJose;
import static com.sales.summary.fixtures.UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProcessLineTest {

    @InjectMocks
    private ProcessLineImpl processLine;

    @Mock
    private FactoryLineLayout factoryLineLayout;

    @Mock
    private CustomerIOMapper customerIOMapper;

    @Mock
    private SaveCustomer saveCustomer;

    @Mock
    private SalesmanIOMapper salesmanIOMapper;

    @Mock
    private SaveSalesman saveSalesman;

    @Mock
    private SalesIOMapper salesIOMapper;

    @Mock
    private SaveSales saveSales;

    @Test
    void shouldExecuteSaveSalesman_WhenSalesmanLayout() {
        String line = "anything";
        UUID uuid = gimmeUUID_62500db838794653a4615139a1be0e19();

        Salesman salesman = SalesmanFixture.gimmeSalesman_cpf12345678901_nameJose();
        LineLayout salesmanLineLayout = gimmeLineLayout_SalesmanLayout_cpf12345678901_nameJose();

        when(factoryLineLayout.getLineLayout(line))
                .thenReturn(salesmanLineLayout);

        when(salesmanIOMapper.toDomain((SalesmanLayout) salesmanLineLayout))
                .thenReturn(salesman);

        Assertions.assertDoesNotThrow(() ->
                processLine.execute(uuid, line));

        verify(factoryLineLayout, times(1))
                .getLineLayout(line);

        verify(salesmanIOMapper, times(1))
                .toDomain((SalesmanLayout) salesmanLineLayout);

        verify(saveSalesman, times(1))
                .execute(salesman, uuid);
    }

    @Test
    void shouldExecuteSaveCustomer_WhenCustomerLayout() {
        String line = "anything";
        UUID uuid = gimmeUUID_62500db838794653a4615139a1be0e19();

        Customer Customer = gimmeCustomer_namePedro_cnpj12345678012345();
        LineLayout CustomerLineLayout = gimmeLineLayout_CustomerLayout_namePedro_cnpj12345678012345();

        when(factoryLineLayout.getLineLayout(line))
                .thenReturn(CustomerLineLayout);

        when(customerIOMapper.toDomain((CustomerLayout) CustomerLineLayout))
                .thenReturn(Customer);

        Assertions.assertDoesNotThrow(() ->
                processLine.execute(uuid, line));

        verify(factoryLineLayout, times(1))
                .getLineLayout(line);

        verify(customerIOMapper, times(1))
                .toDomain((CustomerLayout) CustomerLineLayout);

        verify(saveCustomer, times(1))
                .execute(Customer, uuid);
    }

    @Test
    void shouldExecuteSaveSales_WhenSalesLayout() {
        String line = "anything";
        UUID uuid = gimmeUUID_62500db838794653a4615139a1be0e19();
        Sales sales = gimmeSales_saleId5_total500_sellerJose();
        LineLayout salesLineLayout = gimmeLineLayout_SalesLayout_saleId5_total500_sellerJose();

        when(factoryLineLayout.getLineLayout(line))
                .thenReturn(salesLineLayout);

        when(salesIOMapper.toDomain((SalesLayout) salesLineLayout))
                .thenReturn(sales);

        Assertions.assertDoesNotThrow(() ->
                processLine.execute(uuid, line));

        verify(factoryLineLayout, times(1))
                .getLineLayout(line);

        verify(salesIOMapper, times(1))
                .toDomain((SalesLayout) salesLineLayout);

        verify(saveSales, times(1))
                .execute(sales, uuid);
    }

}