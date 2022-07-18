package com.sales.summary.service;

import com.sales.summary.domain.Customer;
import com.sales.summary.domain.Sales;
import com.sales.summary.domain.Salesman;
import com.sales.summary.domain.exceptions.FileAlreadyCreatedException;
import com.sales.summary.infra.h2.dto.CustomerDTO;
import com.sales.summary.infra.h2.dto.SalesDTO;
import com.sales.summary.infra.h2.dto.SalesmanDTO;
import com.sales.summary.infra.h2.mappers.CustomerMapper;
import com.sales.summary.infra.h2.mappers.SalesMapper;
import com.sales.summary.infra.h2.mappers.SalesmanMapper;
import com.sales.summary.infra.h2.repository.CustomerRepository;
import com.sales.summary.infra.h2.repository.SalesRepository;
import com.sales.summary.infra.h2.repository.SalesmanRepository;
import com.sales.summary.usecase.CreateEmptyFile;
import com.sales.summary.usecase.GetByFileExtension;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log
public class ReadFiles {

    private final GetByFileExtension getByFileExtension;
    private final CreateEmptyFile createEmptyFile;

    private final SalesmanRepository salesmanRepository;
    private final CustomerRepository customerRepository;
    private final SalesRepository salesRepository;

    private final SalesmanMapper salesmanMapper;
    private final CustomerMapper customerMapper;
    private final SalesMapper salesMapper;


    private int number;
    private String inputDirectory;
    private String outputDirectory;

    public void execute(int number) {
        this.number = number;
        inputDirectory = System.getenv("HOMEPATH") + "/data/in";
        outputDirectory = System.getenv("HOMEPATH") + "/data/out";

        System.out.println("INICIADO: " + number);
        List<Path> pathList = getByFileExtension.execute(inputDirectory, "dat");

        System.out.println(pathList.toString());

        for (Path path : pathList) {
            try {

                Path outputFile = createEmptyFile.execute(outputDirectory, getOutputFileNameFromInputFile(path));
                readFileLineByLine(path);
                System.out.println("PASSOU PELA LEITURA: " + number);

            } catch (IOException | FileAlreadyCreatedException e) {
                System.out.println("Ocorreu um erro ao ler o arquivo! THRED: " + number);
            }
        }

        System.out.println("FINALIZADO: " + number);

    }

    private String getOutputFileNameFromInputFile(Path path) {
        return path.getFileName()
                .toString()
                .replace(".dat", ".done.dat");
    }

    @Transactional
    private void readFileLineByLine(Path path) throws IOException {
        System.out.println("Tentando! " + LocalDateTime.now() + "THRED: " + number);
        BufferedReader reader = Files.newBufferedReader(path);
        System.out.println("lendo o arquivo!" + "THRED: " + number);
        String line;
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            String[] lineSplinted = line.split("ç");
            List<String> stringList = Arrays.asList(lineSplinted);
            if ("001".equals(stringList.get(0))) {
                Salesman salesman = new Salesman(stringList);
                SalesmanDTO salesmanDTO = salesmanMapper.toDTO(salesman);
                salesmanRepository.findOrCreate(salesmanDTO);
            }
            if ("002".equals(stringList.get(0))) {
                Customer customer = new Customer(stringList);
                CustomerDTO customerDTO = customerMapper.toDTO(customer);
                customerRepository.findOrCreate(customerDTO);
            }
            if ("003".equals(stringList.get(0))) {
                Sales sales = new Sales(stringList);
                SalesmanDTO salesmanDTO = salesmanMapper.toDTO(sales.getSeller());
                SalesmanDTO dto = salesmanRepository.findOne(Example.of(salesmanDTO)).get();
                SalesDTO salesDTO = salesMapper.toDTO(sales, dto);
                salesRepository.save(salesDTO);
            }

        }
        reader.close();

        System.out.println("TOTAL DE CUSTOMER: " + customerRepository.count());
        System.out.println("TOTAL DE SALESMAN: " + salesmanRepository.count());

        System.out.println("Printando o repositorio:");
        salesmanRepository.findAll().forEach(System.out::println);
    }

}
