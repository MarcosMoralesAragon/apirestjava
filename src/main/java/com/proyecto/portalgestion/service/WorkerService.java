package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.utils.IdGenerator;

import java.util.ArrayList;

public class WorkerService {
    public static ArrayList<Worker> workerList = new ArrayList<>();
    public IdGenerator idGenerator = new IdGenerator();
    public AddressService addressService = new AddressService();

    public Integer foundIndexInList(String id){
        int index;
        for (index = 0; index < workerList.size(); index++) {
            if (workerList.get(index).getId().equals(id)){
                return index;
            }
        }
        return -1;
    }

    public ArrayList<Worker> listOfWorkers(){return addressService.asingAddress(workerList);}

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

    public Worker addWorker(Worker newWorker){
        if (!hasIdCorrect(newWorker.getId())){
            newWorker.setId(idGenerator.stringGenerator(workerList, null, null));
        }
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

    public void addListToArray(ArrayList<Worker> listToAdd){
        workerList.addAll(listToAdd);
    }

    private boolean hasIdCorrect(String id){
        String[] parts = id.split("-");
        return parts[0].equals("W");
    }
}
