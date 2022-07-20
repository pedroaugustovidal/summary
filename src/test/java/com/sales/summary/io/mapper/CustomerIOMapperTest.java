package com.sales.summary.io.mapper;

import com.sales.summary.domain.Customer;
import com.sales.summary.io.dto.CustomerLayout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.sales.summary.fixtures.CustomerFixture.gimmeCustomer_namePedro_cnpj12345678012345;
import static com.sales.summary.fixtures.CustomerLayoutFixture.gimmeCustomerLayout_namePedro_cnpj12345678012345;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CustomerIOMapperTest {

    @InjectMocks
    private CustomerIOMapper customerIOMapper;

    @Test
    void shouldReturnCustomer_WhenCustomerLayout() {
        CustomerLayout customerLayout = gimmeCustomerLayout_namePedro_cnpj12345678012345();
        Customer customerExpected = gimmeCustomer_namePedro_cnpj12345678012345();

        Customer result = customerIOMapper.toDomain(customerLayout);

        assertEquals(customerExpected, result);

    }

}