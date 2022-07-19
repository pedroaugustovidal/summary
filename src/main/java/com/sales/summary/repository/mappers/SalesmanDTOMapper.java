package com.sales.summary.repository.mappers;

import com.sales.summary.domain.Salesman;
import com.sales.summary.repository.dto.SalesmanDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SalesmanDTOMapper {

    public Salesman toDomain(SalesmanDTO salesmanDTO) {
        return Salesman.builder()
                .cpf(salesmanDTO.getCpf())
                .name(salesmanDTO.getName())
                .build();
    }

    public SalesmanDTO toDTO(Salesman salesman, UUID uuid) {
        return SalesmanDTO.builder()
                .cpf(salesman.getCpf())
                .name(salesman.getName())
                .uuidFile(uuid)
                .build();
    }

}
