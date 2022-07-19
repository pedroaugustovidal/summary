package com.sales.summary.repository;

import com.sales.summary.repository.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static org.springframework.data.domain.Example.of;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, Long> {

    default CustomerDTO findOrCreate(CustomerDTO customerDTO) {
        return findOne(of(customerDTO))
                .orElseGet(() -> save(customerDTO));
    }

    long countByUuidFile(UUID uuid);

}
