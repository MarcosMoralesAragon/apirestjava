package com.proyecto.portalgestion.controller;

import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.service.BinService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BinController {
    private final BinService binService = new BinService();

    @GetMapping("/bin")
    ArrayList<Worker> getWorkers(){return binService.getBin();}

    @PostMapping("/bin-add")
    Worker addWorkerToBin(@RequestBody Worker worker){return addWorkerToBin(worker);}

    @DeleteMapping("/bin-delete/{id}")
    Worker deleteWorkerFromBin(@PathVariable String id){return binService.deleteFromBin(id);}

    @DeleteMapping("/bin-deleteAll")
    boolean deleteAllWorkersFromBin(){return binService.deleteAllFromBin();}

    @DeleteMapping("/bin-restore/{id}")
    Worker restoreWorkerFromBin(@PathVariable String id){return binService.restoreFromBin(id);}

    @DeleteMapping("/bin-restoreAll")
    boolean restoreAllWorkersFromBin(){return binService.restoreAllFromBin();}

}
