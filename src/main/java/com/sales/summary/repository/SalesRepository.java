package com.sales.summary.repository;

import com.sales.summary.repository.dto.SalesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SalesRepository extends JpaRepository<SalesDTO, Long> {

    List<SalesDTO> findBySeller(String seller);

    @Query(value = "select top 1 s.* " +
            "from SALES s " +
            "where s.uuid_file = :uuid " +
            "order by total desc", nativeQuery = true)
    SalesDTO findHigherSale(UUID uuid);


}
