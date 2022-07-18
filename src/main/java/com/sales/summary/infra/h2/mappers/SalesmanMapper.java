package com.sales.summary.infra.h2.mappers;

import com.sales.summary.domain.Salesman;
import com.sales.summary.infra.h2.dto.SalesmanDTO;
import org.springframework.stereotype.Component;

@Component
public class SalesmanMapper {

    public Salesman toDomain(SalesmanDTO salesmanDTO) {
        return Salesman.builder()
                .cpf(salesmanDTO.getCpf())
                .name(salesmanDTO.getName())
                .build();
    }

    public SalesmanDTO toDTO(Salesman salesman) {
        return SalesmanDTO.builder()
                .cpf(salesman.getCpf())
                .name(salesman.getName())
                .build();
    }

}
