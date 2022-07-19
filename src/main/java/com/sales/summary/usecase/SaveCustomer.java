package com.sales.summary.usecase;

import com.sales.summary.domain.Customer;

import java.util.UUID;

public interface SaveCustomer {

    Customer execute(Customer customer, UUID uuid);

}
