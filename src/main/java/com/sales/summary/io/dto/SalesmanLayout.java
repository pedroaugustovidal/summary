package com.sales.summary.io.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesmanLayout extends LineLayout {

    private String cpf;
    private String name;

}
