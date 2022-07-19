package com.sales.summary.fixtures;

import com.sales.summary.repository.dto.CustomerDTO;

import static com.sales.summary.fixtures.UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19;

public class CustomerDTOFixture {

    public static CustomerDTO gimmeCustomerDTO_uuid_namePedro_cnpj12345678012345_Unsaved() {
        return CustomerDTO.builder()
                .uuidFile(gimmeUUID_62500db838794653a4615139a1be0e19())
                .name("Pedro")
                .cnpj("12345678012345")
                .build();
    }

    public static CustomerDTO gimmeCustomerDTO_id1_uuid_namePedro_cnpj12345678012345_Saved() {
        return CustomerDTO.builder()
                .id(1L)
                .uuidFile(gimmeUUID_62500db838794653a4615139a1be0e19())
                .name("Pedro")
                .cnpj("12345678012345")
                .build();
    }

}
