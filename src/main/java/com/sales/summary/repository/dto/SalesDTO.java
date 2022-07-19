package com.sales.summary.repository.dto;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "SALES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SalesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "uuid_file", nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    private UUID uuidFile;

    @Column(name = "sale_id")
    private Long saleId;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "seller")
    private String seller;

}
