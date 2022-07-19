package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Summary;
import com.sales.summary.repository.CustomerRepository;
import com.sales.summary.repository.SalesRepository;
import com.sales.summary.repository.SalesmanRepository;
import com.sales.summary.usecase.GetOutputResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetOutputResultImpl implements GetOutputResult {

    private final CustomerRepository customerRepository;
    private final SalesmanRepository salesmanRepository;
    private final SalesRepository salesRepository;

    @Override
    public Summary execute(UUID uuid) {

        return Summary.builder()
                .totalCustomer(customerRepository.countByUuidFile(uuid))
                .totalSalesman(salesmanRepository.countByUuidFile(uuid))
                .worstSeller(salesmanRepository.findTopWorstSeller(uuid).getName())
                .idBestSale(salesRepository.findHigherSale(uuid).getSaleId())
                .build();

    }

}
