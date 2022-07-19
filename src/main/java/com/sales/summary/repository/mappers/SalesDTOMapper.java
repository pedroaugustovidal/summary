package com.sales.summary.repository.mappers;

import com.sales.summary.domain.Sales;
import com.sales.summary.repository.dto.SalesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SalesDTOMapper {

    private final SalesmanDTOMapper salesmanDTOMapper;

    public Sales toDomain(SalesDTO salesDTO) {
        return Sales.builder()
                .saleId(salesDTO.getSaleId())
                .total(salesDTO.getTotal())
                .seller(salesDTO.getSeller())
                .build();
    }

    public SalesDTO toDTO(Sales sales, UUID uuid) {
        return SalesDTO.builder()
                .saleId(sales.getSaleId())
                .uuidFile(uuid)
                .total(sales.getTotal())
                .seller(sales.getSeller())
                .build();
    }

}
