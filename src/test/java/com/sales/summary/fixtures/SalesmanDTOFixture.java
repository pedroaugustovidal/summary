package com.sales.summary.fixtures;

import com.sales.summary.repository.dto.SalesmanDTO;

import static com.sales.summary.fixtures.UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19;

public class SalesmanDTOFixture {

    public static SalesmanDTO gimmeSalesmanDTO_uuid_cpf12345678901_nameJose_Unsaved() {
        return SalesmanDTO.builder()
                .uuidFile(gimmeUUID_62500db838794653a4615139a1be0e19())
                .cpf("12345678901")
                .name("Jose")
                .build();
    }

    public static SalesmanDTO gimmeSalesmanDTO_id2_uuid_cpf12345678901_nameJose_Saved() {
        return SalesmanDTO.builder()
                .id(2L)
                .uuidFile(gimmeUUID_62500db838794653a4615139a1be0e19())
                .cpf("12345678901")
                .name("Jose")
                .build();
    }

}
