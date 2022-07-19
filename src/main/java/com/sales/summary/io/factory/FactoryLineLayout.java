package com.sales.summary.io.factory;

import com.sales.summary.domain.exceptions.CustomerWrongFormatException;
import com.sales.summary.domain.exceptions.SalesWrongFormatException;
import com.sales.summary.domain.exceptions.SalesmanWrongFormatException;
import com.sales.summary.io.dto.CustomerLayout;
import com.sales.summary.io.dto.LineLayout;
import com.sales.summary.io.dto.SalesLayout;
import com.sales.summary.io.dto.SalesmanLayout;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class FactoryLineLayout {

    public LineLayout getLineLayout(String line) {
        String[] values = line.split("ç");

        if ("001".equals(values[0])) {
            return getSalesmanLayout(values);
        }

        if ("002".equals(values[0])) {
            return getCustomerLayout(values);
        }

        if ("003".equals(values[0])) {
            return getSalesLayout(values);
        }

        return null;
    }

    private SalesmanLayout getSalesmanLayout(String[] values) {
        if (values.length != 4) {
            throw new SalesmanWrongFormatException();
        }

        return SalesmanLayout
                .builder()
                .cpf(values[1])
                .name(values[2])
                .build();
    }

    private CustomerLayout getCustomerLayout(String[] values) {
        if (values.length != 4) {
            throw new CustomerWrongFormatException();
        }

        return CustomerLayout
                .builder()
                .cnpj(values[1])
                .name(values[2])
                .build();
    }

    private SalesLayout getSalesLayout(String[] values) {
        if (values.length != 4) {
            throw new SalesWrongFormatException();
        }

        BigDecimal totalBalance = getTotalBalanceBySale(values[2]);

        return SalesLayout.builder()
                .saleId(Long.parseLong(values[1]))
                .total(totalBalance)
                .seller(values[3])
                .build();
    }

    private BigDecimal getTotalBalanceBySale(String value) {

        return getPriceDataList(value)
                .stream()
                .map(this::getPriceByEachSale)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private List<String> getPriceDataList(String value) {
        return Arrays.asList(
                value.replace("[", "")
                        .replace("]", "")
                        .split(","));
    }

    private BigDecimal getPriceByEachSale(String dataSaleWrap) {
        String[] priceUnwrapped = dataSaleWrap.split("-");

        String quantity = priceUnwrapped[1];
        String price = priceUnwrapped[2];

        return new BigDecimal(quantity)
                .multiply(new BigDecimal(price));
    }
}
