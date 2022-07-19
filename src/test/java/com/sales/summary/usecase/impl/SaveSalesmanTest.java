package com.sales.summary.usecase.impl;

import com.sales.summary.domain.Salesman;
import com.sales.summary.fixtures.UuidFixture;
import com.sales.summary.repository.SalesmanRepository;
import com.sales.summary.repository.dto.SalesmanDTO;
import com.sales.summary.repository.mappers.SalesmanDTOMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static com.sales.summary.fixtures.SalesmanDTOFixture.gimmeSalesmanDTO_id2_uuid_cpf12345678901_nameJose_Saved;
import static com.sales.summary.fixtures.SalesmanDTOFixture.gimmeSalesmanDTO_uuid_cpf12345678901_nameJose_Unsaved;
import static com.sales.summary.fixtures.SalesmanFixture.gimmeSalesman_cpf12345678901_nameJose;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveSalesmanTest {

    @InjectMocks
    private SaveSalesmanImpl saveSalesman;

    @Mock
    private SalesmanDTOMapper salesmanDTOMapper;

    @Mock
    private SalesmanRepository salesmanRepository;

    @Test
    void shouldReturnSalesmanSaved_WhenExecuteSalesmanUuid() {
        UUID uuid = UuidFixture.gimmeUUID_62500db838794653a4615139a1be0e19();
        Salesman salesman = gimmeSalesman_cpf12345678901_nameJose();
        Salesman salesmanExpected = gimmeSalesman_cpf12345678901_nameJose();
        SalesmanDTO salesmanDtoUnsaved = gimmeSalesmanDTO_uuid_cpf12345678901_nameJose_Unsaved();
        SalesmanDTO salesmanDtoSaved = gimmeSalesmanDTO_id2_uuid_cpf12345678901_nameJose_Saved();

        when(salesmanDTOMapper.toDTO(salesman, uuid))
                .thenReturn(salesmanDtoUnsaved);

        when(salesmanRepository.findOrCreate(salesmanDtoUnsaved))
                .thenReturn(salesmanDtoSaved);

        when(salesmanDTOMapper.toDomain(salesmanDtoSaved))
                .thenReturn(salesmanExpected);

        Salesman result = saveSalesman.execute(salesman, uuid);

        Assertions.assertEquals(salesmanExpected, result);

        verify(salesmanDTOMapper, times(1))
                .toDTO(salesman, uuid);

        verify(salesmanRepository, times(1))
                .findOrCreate(salesmanDtoUnsaved);

        verify(salesmanDTOMapper, times(1))
                .toDomain(salesmanDtoSaved);

    }

}