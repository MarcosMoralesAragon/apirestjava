package com.proyecto.portalgestion.controller;

import com.proyecto.portalgestion.model.Contract;
import com.proyecto.portalgestion.service.ContractService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContractController {
    private final ContractService contractService = new ContractService();

    @GetMapping("/contracts/{id}")
    ArrayList<Contract> getWorkerContracts(@PathVariable String id){return contractService.getContractsFromWorker(id);}

    @GetMapping("/contract/{id}")
    Contract getContract(@PathVariable String id){return contractService.getContract(id);}

    @PostMapping("/contract")
    Contract addContract(@RequestBody Contract contract){return contractService.addContract(contract);}

    @PutMapping("/contract")
    boolean editContract(@RequestBody Contract contract){return contractService.editContract(contract);}

    @DeleteMapping("/contract/{id}")
    boolean deleteContract(@PathVariable String id){return contractService.deleteContract(id);}
}
