package com.sales.summary.usecase;

import com.sales.summary.domain.Salesman;

import java.util.UUID;

public interface SaveSalesman {

    Salesman execute(Salesman salesman, UUID uuid);

}
