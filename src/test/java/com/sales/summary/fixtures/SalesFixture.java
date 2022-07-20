package com.sales.summary.fixtures;

import com.sales.summary.domain.Sales;

import java.math.BigDecimal;

public class SalesFixture {

    public static Sales gimmeSales_saleId5_total500_sellerJose() {
        return Sales.builder()
                .saleId(5L)
                .total(new BigDecimal("500.00"))
                .seller("Jose")
                .build();
    }

}
