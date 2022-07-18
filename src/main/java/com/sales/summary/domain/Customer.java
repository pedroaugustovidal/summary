package com.sales.summary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private String cnpj;
    private String name;

    public Customer(List<String> stringList) {
        this.cnpj = stringList.get(1);
        this.name = stringList.get(2);
    }
}
