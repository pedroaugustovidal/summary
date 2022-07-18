package com.sales.summary.infra.h2.mappers;

import com.sales.summary.domain.Customer;
import com.sales.summary.infra.h2.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toDomain(CustomerDTO customerDTO) {
        return Customer.builder()
                .cnpj(customerDTO.getCnpj())
                .name(customerDTO.getName())
                .build();
    }

    public CustomerDTO toDTO(Customer customer) {
        return CustomerDTO.builder()
                .cnpj(customer.getCnpj())
                .name(customer.getName())
                .build();
    }

}
