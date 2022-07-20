package com.sales.summary.fixtures;

import com.sales.summary.io.dto.SalesLayout;

import java.math.BigDecimal;

public class SalesLayoutFixture {

    public static SalesLayout gimmeSalesLayout_saleId5_total500_sellerJose() {
        return SalesLayout.builder()
                .saleId(5L)
                .total(new BigDecimal("500.00"))
                .seller("Jose")
                .build();
    }

}
