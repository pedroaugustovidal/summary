package com.sales.summary.infra.h2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SALES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "saleId")
    private Long saleId;

    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private SalesmanDTO seller;

}
