package com.sales.summary.io.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerLayout extends LineLayout {

    private String cnpj;
    private String name;


}
