package com.proyecto.portalgestion.controller;

import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.service.WorkerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WorkerController {
    WorkerController(){}

    private final WorkerService workerService = new WorkerService();


    // Saca todos los trabajadores
    @GetMapping("/workers")
    ArrayList<Worker> getWorkers(){
        return workerService.listOfWorkers();
    }

    // Saca un trabajador en concreto
    // @GetMapping("/workers/{id}")
    // Worker getWorkerById(@PathVariable String id){return workerService.getWorkerById(id);}

    // Añade un trabajador nuevo
    @PostMapping("/workers")
    Worker addWorker(@RequestBody  Worker worker ){
        return workerService.addWorker(worker);
    }

    //Edita un trabajador
    @PutMapping("/workers/{id}")
    Worker changeWorker(@RequestBody Worker worker, @PathVariable String id){return workerService.editWorker(worker);}

    @DeleteMapping("/workers/{id}")
    boolean deleteWorker(@PathVariable String id){
        return workerService.deleteWorker(id);
    }
}
