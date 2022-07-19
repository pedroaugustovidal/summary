package com.sales.summary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

    private Long saleId;
    private BigDecimal total;
    private String seller;

    public Sales(List<String> input) {
        if (input.size() != 4) {
            throw new RuntimeException("Sales is not possible to build!");
        }

        this.saleId = Long.parseLong(input.get(1));
        this.total = getTotalValue(input.get(2));
        this.seller = input.get(3);

    }

    private BigDecimal getTotalValue(String input) {
        List<String> split = Arrays.asList(input
                .replace("[", "")
                .replace("]", "")
                .split(","));


        return split.stream()
                .map(this::getSaleTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getSaleTotalPrice(String itemsSplit) {
        String[] items = itemsSplit.split("-");
        return new BigDecimal(items[1]).multiply(new BigDecimal(items[2]));
    }
}
