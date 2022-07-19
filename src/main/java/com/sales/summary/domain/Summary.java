package com.sales.summary.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Summary {

    Long totalCustomer;
    Long totalSalesman;
    Long idBestSale;
    String worstSeller;

    @Override
    public String toString() {
        String delimiter = "ç";
        return totalCustomer + delimiter +
                totalSalesman + delimiter +
                idBestSale + delimiter +
                worstSeller;
    }
}

