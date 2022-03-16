package com.proyecto.portalgestion.controller;

import com.proyecto.portalgestion.model.Contract;
import com.proyecto.portalgestion.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContractController {
    private final ContractService contractService = new ContractService();

    // Saca todos los contratos de un empleado
    @GetMapping("/contracts/{id}")
    ArrayList<Contract> getWorkerContracts(@PathVariable String id){return contractService.getContractsFromWorker(id);}

    // Saca un contrato en concreto
    @GetMapping("/contract/{id}")
    Contract getContract(@PathVariable String id){return contractService.getContract(id);}

    // Añade un contrato
    @PostMapping("/contract")
    Contract addContract(@RequestBody Contract contract){return contractService.addContract(contract);}

    // Edita un contrato
    @PutMapping("/contract")
    boolean editContract(@RequestBody Contract contract){return contractService.editContract(contract);}

    // Borra un contrato de la lista
    @DeleteMapping("/contract/{id}")
    boolean deleteContract(@PathVariable String id){return contractService.deleteContract(id);}
}
