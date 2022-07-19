package com.sales.summary.usecase;

import com.sales.summary.domain.Sales;

import java.util.UUID;

public interface SaveSales {

    Sales execute(Sales sales, UUID uuid);

}
