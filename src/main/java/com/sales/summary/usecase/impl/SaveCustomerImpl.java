package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Customer;
import com.sales.summary.repository.CustomerRepository;
import com.sales.summary.repository.dto.CustomerDTO;
import com.sales.summary.repository.mappers.CustomerDTOMapper;
import com.sales.summary.usecase.SaveCustomer;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log
public class SaveCustomerImpl implements SaveCustomer {

    private final CustomerDTOMapper customerDTOMapper;
    private final CustomerRepository customerRepository;

    @Override
    public Customer execute(Customer customer, UUID uuid) {
        log.info(uuid + ": Saving salesman into db: " + customer);
        CustomerDTO customerDto = customerDTOMapper.toDTO(customer, uuid);
        CustomerDTO customerDtoSaved = customerRepository.findOrCreate(customerDto);

        return customerDTOMapper.toDomain(customerDtoSaved);
    }

}
