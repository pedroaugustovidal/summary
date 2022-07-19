package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Customer;
import com.sales.summary.domain.Sales;
import com.sales.summary.domain.Salesman;
import com.sales.summary.io.dto.CustomerLayout;
import com.sales.summary.io.dto.LineLayout;
import com.sales.summary.io.dto.SalesLayout;
import com.sales.summary.io.dto.SalesmanLayout;
import com.sales.summary.io.factory.FactoryLineLayout;
import com.sales.summary.io.mapper.CustomerIOMapper;
import com.sales.summary.io.mapper.SalesIOMapper;
import com.sales.summary.io.mapper.SalesmanIOMapper;
import com.sales.summary.usecase.ProcessLine;
import com.sales.summary.usecase.SaveCustomer;
import com.sales.summary.usecase.SaveSales;
import com.sales.summary.usecase.SaveSalesman;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log
public class ProcessLineImpl implements ProcessLine {

    private final FactoryLineLayout factoryLineLayout;

    private final CustomerIOMapper customerIOMapper;
    private final SaveCustomer saveCustomer;

    private final SalesmanIOMapper salesmanIOMapper;
    private final SaveSalesman saveSalesman;

    private final SalesIOMapper salesIOMapper;
    private final SaveSales saveSales;

    @Override
    public void execute(UUID uuid, String line) {
        LineLayout lineLayout = factoryLineLayout.getLineLayout(line);

        //TODO: Aplicar pattern visitor
        if (lineLayout instanceof SalesmanLayout) {
            log.info("Line layout identified as: Salesman");
            Salesman salesman = salesmanIOMapper.toDomain((SalesmanLayout) lineLayout);
            saveSalesman.execute(salesman, uuid);
        }
        if (lineLayout instanceof CustomerLayout) {
            log.info("Line layout identified as: Customer");
            Customer customer = customerIOMapper.toDomain((CustomerLayout) lineLayout);
            saveCustomer.execute(customer, uuid);
        }
        if (lineLayout instanceof SalesLayout) {
            log.info("Line layout identified as: Sales");
            Sales sales = salesIOMapper.toDomain((SalesLayout) lineLayout);
            saveSales.execute(sales, uuid);
        }
    }

}
