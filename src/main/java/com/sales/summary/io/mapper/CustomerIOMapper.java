package com.sales.summary.io.mapper;

import com.sales.summary.domain.Customer;
import com.sales.summary.io.dto.CustomerLayout;
import org.springframework.stereotype.Component;

@Component
public class CustomerIOMapper {

    public Customer toDomain(CustomerLayout customerLayout) {
        return Customer.builder()
                .cnpj(customerLayout.getCnpj())
                .name(customerLayout.getName())
                .build();
    }

}
