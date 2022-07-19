package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Salesman;
import com.sales.summary.repository.SalesmanRepository;
import com.sales.summary.repository.dto.SalesmanDTO;
import com.sales.summary.repository.mappers.SalesmanDTOMapper;
import com.sales.summary.usecase.SaveSalesman;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log
public class SaveSalesmanImpl implements SaveSalesman {

    private final SalesmanDTOMapper salesmanDTOMapper;
    private final SalesmanRepository salesmanRepository;

    @Override
    public Salesman execute(Salesman salesman, UUID uuid) {
        log.info(uuid + ": Saving salesman into db: " + salesman);
        SalesmanDTO salesmanDto = salesmanDTOMapper.toDTO(salesman, uuid);
        SalesmanDTO salesmanDtoSaved = salesmanRepository.findOrCreate(salesmanDto);

        return salesmanDTOMapper.toDomain(salesmanDtoSaved);
    }

}
