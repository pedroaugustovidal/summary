package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Customer;
import com.sales.summary.fixtures.UuidFixture;
import com.sales.summary.repository.CustomerRepository;
import com.sales.summary.repository.dto.CustomerDTO;
import com.sales.summary.repository.mappers.CustomerDTOMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.sales.summary.fixtures.CustomerDTOFixture.gimmeCustomerDTO_id1_uuid_namePedro_cnpj12345678012345_Saved;
import static com.sales.summary.fixtures.CustomerDTOFixture.gimmeCustomerDTO_uuid_namePedro_cnpj12345678012345_Unsaved;
import static com.sales.summary.fixtures.CustomerFixture.gimmeCustomer_namePedro_cnpj12345678012345;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveCustomerTest {

    @InjectMocks
    private SaveCustomerImpl saveCustomer;

    @Mock
    private CustomerDTOMapper customerDTOMapper;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void shouldReturnCustomerSaved_WhenExecuteCustomerUuid() {
        UUID uuid = UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19();
        Customer customer = gimmeCustomer_namePedro_cnpj12345678012345();
        Customer customerExpected = gimmeCustomer_namePedro_cnpj12345678012345();
        CustomerDTO customerDtoUnsaved = gimmeCustomerDTO_uuid_namePedro_cnpj12345678012345_Unsaved();
        CustomerDTO customerDtoSaved = gimmeCustomerDTO_id1_uuid_namePedro_cnpj12345678012345_Saved();

        when(customerDTOMapper.toDTO(customer, uuid))
                .thenReturn(customerDtoUnsaved);

        when(customerRepository.findOrCreate(customerDtoUnsaved))
                .thenReturn(customerDtoSaved);

        when(customerDTOMapper.toDomain(customerDtoSaved))
                .thenReturn(customerExpected);

        Customer result = saveCustomer.execute(customer, uuid);

        Assertions.assertEquals(customerExpected, result);

        verify(customerDTOMapper, times(1))
                .toDTO(customer, uuid);

        verify(customerRepository, times(1))
                .findOrCreate(customerDtoUnsaved);

        verify(customerDTOMapper, times(1))
                .toDomain(customerDtoSaved);

    }

}