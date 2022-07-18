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
    private Salesman seller;

    public Sales(List<String> input) {
        if (input.size() != 4) {
            throw new RuntimeException("Sales is not possible to build!");
        }

        this.saleId = Long.parseLong(input.get(1));

        BigDecimal totalBalance = getTotalValue(input);

        this.total = totalBalance;
        this.seller = Salesman.builder()
                .name(input.get(3))
                .build();

    }

    private BigDecimal getTotalValue(List<String> input) {
        List<String> split = Arrays.asList(input.get(2)
                .replace("[", "")
                .replace("]", "")
                .split(","));


        BigDecimal totalBalance = split.stream()
                .map(itemsSplit -> {
                    String[] items = itemsSplit.split("-");
                    return new BigDecimal(items[1]).multiply(new BigDecimal(items[2]));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalBalance;
    }
}
