package com.sales.summary.fixtures;

import com.sales.summary.domain.Salesman;

public class SalesmanFixture {

    public static Salesman gimmeSalesman_cpf12345678901_nameJose() {
        return Salesman.builder()
                .cpf("12345678901")
                .name("Jose")
                .build();
    }

}
