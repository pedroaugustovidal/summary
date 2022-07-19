package com.sales.summary.io.mapper;

import com.sales.summary.domain.Salesman;
import com.sales.summary.io.dto.SalesmanLayout;
import org.springframework.stereotype.Component;

@Component
public class SalesmanIOMapper {

    public Salesman toDomain(SalesmanLayout salesmanLayout) {
        return Salesman.builder()
                .cpf(salesmanLayout.getCpf())
                .name(salesmanLayout.getName())
                .build();
    }

}
