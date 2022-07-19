package com.sales.summary.repository.dto;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "CUSTOMER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "uuid_file", nullable = false, columnDefinition = "BINARY(16)")
    private UUID uuidFile;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "name", nullable = false)
    private String name;

}
