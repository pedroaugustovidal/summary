package com.sales.summary.infra.h2.repository;

import com.sales.summary.infra.h2.dto.SalesmanDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import static org.springframework.data.domain.Example.of;

@Repository
public interface SalesmanRepository extends JpaRepository<SalesmanDTO, Long> {

    default SalesmanDTO findOrCreate(SalesmanDTO salesmanDTO) {
        return findOne(of(salesmanDTO))
                .orElseGet(() -> save(salesmanDTO));
    }

}
