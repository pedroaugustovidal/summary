package com.sales.summary.fixtures;

import com.sales.summary.domain.Customer;

public class CustomerFixture {

    public static Customer gimmeCustomer_namePedro_cnpj12345678012345() {
        return Customer.builder()
                .name("Pedro")
                .cnpj("12345678012345")
                .build();
    }

}
