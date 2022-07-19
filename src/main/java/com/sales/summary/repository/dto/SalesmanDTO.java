package com.sales.summary.repository.dto;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "SALESMAN")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SalesmanDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "uuid_file", nullable = false, columnDefinition = "BINARY(16)")
    private UUID uuidFile;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "name", nullable = false)
    private String name;

}
