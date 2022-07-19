package com.sales.summary.fixtures;

import com.sales.summary.repository.dto.SalesDTO;

import java.math.BigDecimal;

import static com.sales.summary.fixtures.UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19;

public class SalesDTOFixture {

    public static SalesDTO gimmeSalesDTO_uuid_saleId5_total500_sellerJose_Unsaved() {
        return SalesDTO.builder()
                .uuidFile(gimmeUUID_62500db838794653a4615139a1be0e19())
                .saleId(5L)
                .total(new BigDecimal("500"))
                .seller("Jose")
                .build();
    }

    public static SalesDTO gimmeSalesDTO_id3_uuid_saleId5_total500_sellerJose_Saved() {
        return SalesDTO.builder()
                .id(3L)
                .uuidFile(gimmeUUID_62500db838794653a4615139a1be0e19())
                .saleId(5L)
                .total(new BigDecimal("500"))
                .seller("Jose")
                .build();
    }

}
