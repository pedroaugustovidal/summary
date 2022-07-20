package com.sales.summary.io.mapper;

import com.sales.summary.domain.Sales;
import com.sales.summary.io.dto.SalesLayout;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalesIOMapper {

    public Sales toDomain(SalesLayout salesLayout) {
        return Sales.builder()
                .saleId(salesLayout.getSaleId())
                .total(salesLayout.getTotal())
                .seller(salesLayout.getSeller())
                .build();
    }

}
