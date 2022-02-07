package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.utils.IdGenerator;
import com.proyecto.portalgestion.utils.ParseDate;

import java.util.ArrayList;

public class WorkerService {
    public ArrayList<Worker> workerList = new ArrayList<>();
    public IdGenerator idGenerator = new IdGenerator();

    public Integer foundIndexInList(String id){
        int index;
        for (index = 0; index < workerList.size(); index++) {
            if (workerList.get(index).getId().equals(id)){
                return index;
            }
        }
        return -1;
    }

    public ArrayList<Worker> listOfWorkers(){return workerList;}

    public boolean editWorker(Worker worker){
        int index = foundIndexInList(worker.getId());
        if (index != -1){
            workerList.get(index).setId(worker.getId());
            workerList.get(index).setName(worker.getName());
            workerList.get(index).setFirstName(worker.getFirstName());
            workerList.get(index).setLastName(worker.getLastName());
            workerList.get(index).setDni(worker.getDni());
            workerList.get(index).setNationality(worker.getNationality());
            workerList.get(index).setState(worker.getState());
            return true;
        } else {
            return false;
        }
    }

    public Worker getWorkerById(String id){
        int index = foundIndexInList(id);
        if (index != -1){
            return workerList.get(index);
        } else {
            return null;
        }
    }

    public Worker addWorker(Worker newWorker){
        newWorker.setId(idGenerator.stringGenerator(workerList, null));
        workerList.add(newWorker);
        return newWorker;
    }

    public boolean deleteWorker(String id){
        int index = foundIndexInList(id);
        if (index != -1 ){
            workerList.remove(index);
            return true;
        } else {
            return false;
        }
    }
}
