package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Sales;
import com.sales.summary.repository.SalesRepository;
import com.sales.summary.repository.dto.SalesDTO;
import com.sales.summary.repository.mappers.SalesDTOMapper;
import com.sales.summary.usecase.SaveSales;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log
public class SaveSalesImpl implements SaveSales {

    private final SalesRepository salesRepository;
    private final SalesDTOMapper salesDTOMapper;

    @Override
    public Sales execute(Sales sales, UUID uuid) {
        log.info(uuid + ": Saving salesman into db: " + sales);
        SalesDTO salesDTO = salesDTOMapper.toDTO(sales, uuid);
        SalesDTO salesDtoSaved = salesRepository.save(salesDTO);

        return salesDTOMapper.toDomain(salesDtoSaved);
    }

}
