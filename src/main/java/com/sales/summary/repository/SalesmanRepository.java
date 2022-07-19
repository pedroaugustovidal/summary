package com.sales.summary.repository;

import com.sales.summary.repository.dto.SalesmanDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static org.springframework.data.domain.Example.of;

@Repository
public interface SalesmanRepository extends JpaRepository<SalesmanDTO, Long> {

    default SalesmanDTO findOrCreate(SalesmanDTO salesmanDTO) {
        return findOne(of(salesmanDTO))
                .orElseGet(() -> save(salesmanDTO));
    }

    @Query(value = "select top 1 sm.*, " +
            "sum(s.total) as total " +
            "from SALESMAN sm " +
            "left join SALES s " +
            "on sm.name = s.seller " +
            "where sm.uuid_file = :uuid " +
            "group by sm.name " +
            "order by total asc", nativeQuery = true)
    SalesmanDTO findTopWorstSeller(UUID uuid);

    long countByUuidFile(UUID uuid);

}
