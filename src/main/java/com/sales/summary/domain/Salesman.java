package com.sales.summary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salesman {

    private String cpf;
    private String name;

    public Salesman(List<String> input) {
        this.cpf = input.get(1);
        this.name = input.get(2);
    }

}
