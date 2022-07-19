package com.sales.summary.fixtures;

import com.sales.summary.io.dto.SalesmanLayout;

public class SalesmanLayoutFixture {

    public static SalesmanLayout gimmeSalesmanLayout_cpf12345678901_nameJose() {
        return SalesmanLayout.builder()
                .cpf("12345678901")
                .name("Jose")
                .build();
    }

}
