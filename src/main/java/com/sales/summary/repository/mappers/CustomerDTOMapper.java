package com.sales.summary.repository.mappers;

import com.sales.summary.domain.Customer;
import com.sales.summary.repository.dto.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerDTOMapper {

    public Customer toDomain(CustomerDTO customerDTO) {
        return Customer.builder()
                .cnpj(customerDTO.getCnpj())
                .name(customerDTO.getName())
                .build();
    }

    public CustomerDTO toDTO(Customer customer, UUID uuid) {
        return CustomerDTO.builder()
                .cnpj(customer.getCnpj())
                .name(customer.getName())
                .uuidFile(uuid)
                .build();
    }

}
