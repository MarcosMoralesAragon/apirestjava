package com.proyecto.portalgestion.controller;


import com.proyecto.portalgestion.model.Address;
import com.proyecto.portalgestion.service.AddressService;
import com.proyecto.portalgestion.service.WorkerService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AddressController {
    private final AddressService addressService = new AddressService();
    private final WorkerService workerService = new WorkerService();

    @GetMapping("/address/{id}")
    Address getAddress(@PathVariable String id){return addressService.getAddress(id);}

    @PostMapping("/address")
    Address addAddress(@RequestBody Address address){return addressService.createAddress(address);}

    @PutMapping("/address")
    boolean editAddress(@RequestBody Address address){return addressService.editAddress(address);}
}
