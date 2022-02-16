package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Worker;

import java.util.ArrayList;

public class BinService {
    public static ArrayList<Worker> bin = new ArrayList<>();
    public ArrayList<Worker> getBin(){return bin;}

    /**
     * Añade un empleado a la lista
     * @return el empleado
     */
    public Worker addToBin(Worker worker){
        bin.add(worker);
        return worker;
    }

    /**
     * Borra al un empleado de la papelera
     * @return un empleado si borra o null si no ha borrado nada
     */
    public Worker deleteFromBin(String workerId){
        for (int i = 0; i < bin.size(); i++){
            if (bin.get(i).getId().equals(workerId)){
                return bin.remove(i);
            }
        }
        return null;
    }

    /**
     * Recupera un empleado de la papelera. Lo borra de esta lista y lo manda a la principal
     * @return un empleado si ha restaurado o null si no
     */
    public Worker restoreFromBin(String workerId){
        WorkerService workerService = new WorkerService();
        Worker restoredWorker = this.deleteFromBin(workerId);
        if (restoredWorker != null){
            workerService.addWorker(restoredWorker);
            return restoredWorker;
        }
        return null;
    }

    /**
     * Vacía la papelera
     */
    public boolean deleteAllFromBin(){
        bin = new ArrayList<>();
        return true;
    }

    /**
     * Vacía la papelera y los añade a todos a la lista principal de empleados
     */
    public boolean restoreAllFromBin(){
        WorkerService workerService = new WorkerService();
        workerService.addListToArray(bin);
        deleteAllFromBin();
        return true;
    }
}
