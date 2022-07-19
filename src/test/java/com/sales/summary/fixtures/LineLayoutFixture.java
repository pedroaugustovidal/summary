package com.sales.summary.fixtures;

import com.sales.summary.io.dto.LineLayout;

import static com.sales.summary.fixtures.CustomerLayoutFixture.gimmeCustomerLayout_namePedro_cnpj12345678012345;
import static com.sales.summary.fixtures.SalesLayoutFixture.gimmeSalesLayout_saleId5_total500_sellerJose;
import static com.sales.summary.fixtures.SalesmanLayoutFixture.gimmeSalesmanLayout_cpf12345678901_nameJose;

public class LineLayoutFixture {

    public static LineLayout gimmeLineLayout_SalesmanLayout_cpf12345678901_nameJose() {
        return gimmeSalesmanLayout_cpf12345678901_nameJose();
    }

    public static LineLayout gimmeLineLayout_CustomerLayout_namePedro_cnpj12345678012345() {
        return gimmeCustomerLayout_namePedro_cnpj12345678012345();
    }

    public static LineLayout gimmeLineLayout_SalesLayout_saleId5_total500_sellerJose() {
        return gimmeSalesLayout_saleId5_total500_sellerJose();
    }

}
