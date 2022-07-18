package com.sales.summary.infra.h2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SALESMAN")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesmanDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH })
    private List<SalesDTO> sales;

}
