package com.sales.summary.infra.h2.repository;

import com.sales.summary.infra.h2.dto.SalesDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<SalesDTO, Long> {
}
