package com.sales.summary.infra.h2.repository;

import com.sales.summary.infra.h2.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static org.springframework.data.domain.Example.of;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, Long> {

    default CustomerDTO findOrCreate(CustomerDTO customerDTO) {
        return findOne(of(customerDTO))
                .orElseGet(() -> save(customerDTO));
    }

}
