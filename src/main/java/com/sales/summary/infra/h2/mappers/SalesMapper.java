package com.sales.summary.infra.h2.mappers;

import com.sales.summary.domain.Sales;
import com.sales.summary.infra.h2.dto.SalesDTO;
import com.sales.summary.infra.h2.dto.SalesmanDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalesMapper {

    private final SalesmanMapper salesmanMapper;

    public Sales toDomain(SalesDTO salesDTO) {
        return Sales.builder()
                .saleId(salesDTO.getSaleId())
                .total(salesDTO.getTotal())
                .seller(salesmanMapper.toDomain(salesDTO.getSeller()))
                .build();
    }

    public SalesDTO toDTO(Sales sales, SalesmanDTO salesmanDTO) {
        return SalesDTO.builder()
                .saleId(sales.getSaleId())
                .total(sales.getTotal())
                .seller(salesmanDTO)
                .build();
    }

}
