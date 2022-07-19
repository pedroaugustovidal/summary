package com.sales.summary.fixtures;

import com.sales.summary.domain.Summary;

public class SummaryFixture {

    public static Summary gimmeSummary_totalCustomer2_totalSalesman_3_idBestSale7_worstSellerJose() {

        return Summary.builder()
                .totalCustomer(2L)
                .totalSalesman(3L)
                .idBestSale(7L)
                .worstSeller("Jose")
                .build();
    }

}
