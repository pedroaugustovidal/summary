package com.sales.summary.fixtures;

import com.sales.summary.io.dto.CustomerLayout;

public class CustomerLayoutFixture {

    public static CustomerLayout gimmeCustomerLayout_namePedro_cnpj12345678012345() {
        return CustomerLayout.builder()
                .name("Pedro")
                .cnpj("12345678012345")
                .build();
    }

}
