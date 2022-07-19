package com.sales.summary.io.dto;

import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesLayout extends LineLayout {

    private Long saleId;
    private BigDecimal total;
    private String seller;

}
