package com.proyecto.portalgestion.controller;

import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.service.BinService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BinController {
    private final BinService binService = new BinService();

    // Saca todos los empeleado que figuran en la papelera
    @GetMapping("/bin")
    ArrayList<Worker> getWorkers(){return binService.getBin();}

    // Añade un empleado a la lista de la papelera
    @PostMapping("/bin-add")
    Worker addWorkerToBin(@RequestBody Worker worker){return binService.addToBin(worker);}

    // Borra un empleado de la papeera
    @DeleteMapping("/bin-delete/{id}")
    Worker deleteWorkerFromBin(@PathVariable String id){return binService.deleteFromBin(id);}

    // Borra todos los empleados de la papelera
    @DeleteMapping("/bin-deleteAll")
    boolean deleteAllWorkersFromBin(){return binService.deleteAllFromBin();}

    // Restaura un empleado concreto
    @DeleteMapping("/bin-restore/{id}")
    Worker restoreWorkerFromBin(@PathVariable String id){return binService.restoreFromBin(id);}

    // Restaura a todos los empleados
    @DeleteMapping("/bin-restoreAll")
    boolean restoreAllWorkersFromBin(){return binService.restoreAllFromBin();}

}
