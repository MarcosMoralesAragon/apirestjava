package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Worker;

import java.util.ArrayList;

public class BinService {
    public static ArrayList<Worker> bin = new ArrayList<>();
    public ArrayList<Worker> getBin(){return bin;}

    public Worker addToBin(Worker worker){
        bin.add(worker);
        return worker;
    }

    public Worker deleteFromBin(String workerId){
        for (int i = 0; i < bin.size(); i++){
            if (bin.get(i).getId().equals(workerId)){
                return bin.remove(i);

            }
        }
        return null;
    }

    public Worker restoreFromBin(String workerId){
        WorkerService workerService = new WorkerService();
        Worker restoredWorker = this.deleteFromBin(workerId);
        if (restoredWorker != null){
            workerService.addWorker(restoredWorker);
            return restoredWorker;
        }
        return null;
    }

    public boolean deleteAllFromBin(){
        bin = new ArrayList<>();
        return true;
    }

    public boolean restoreAllFromBin(){
        WorkerService workerService = new WorkerService();
        workerService.addListToArray(bin);
        deleteAllFromBin();
        return true;
    }
}
