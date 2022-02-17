package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.utils.IdGenerator;

import java.util.ArrayList;

public class WorkerService {
    public static ArrayList<Worker> workerList = new ArrayList<>();
    public IdGenerator idGenerator = new IdGenerator();
    public AddressService addressService = new AddressService();


    /**
     * Busa el index de un empleado en la lista y lo devuelve
     * @return index o en caso de no encontrarlo -1
     */
    public Integer foundIndexInList(String id){
        int index;
        for (index = 0; index < workerList.size(); index++) {
            if (workerList.get(index).getId().equals(id)){
                return index;
            }
        }
        return -1;
    }

    /**
     * Devuelve la lista de empleados
     */
    public ArrayList<Worker> listOfWorkers(){
        // Cada vez que pide la lista va a address service y rellena las direcciones de los empleados
        return addressService.asingAddress(workerList);
    }


    /**
     * Busca a un empleado y si lo encuentra lo edita
     * @return true si lo edita false si se cancela
     */
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

    /**
     * Añade a un empleado a la lista y lo devuelve. Antes de añadirlo comprueba que su id sea el correcto
     * @return Empleado introducido
     */
    public Worker addWorker(Worker newWorker){
        try {
            if (!hasIdCorrect(newWorker.getId())) {
                // Si el id es incorrecto ( que es lo que ocurre cuando el empleado es creado en el front)
                // se le asigna un nuevo id
                newWorker.setId(idGenerator.stringGenerator(workerList, null, null));
            }
            workerList.add(newWorker);
            return newWorker;
        }catch (NullPointerException e){
            // El emplado que se quería crear esta vacío, esto ocuree cuando se carga el archivo
            // excel con su respectiva páguina sin datos
            return null;
        }
    }

    /**
     * Borra a un empleado de la lista
     * @return true si borra false si no borra
     */
    public boolean deleteWorker(String id){
        int index = foundIndexInList(id);
        if (index != -1 ){
            workerList.remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Recoje una lista de empleados y los añade todos a la lista principal
     */
    public void addListToArray(ArrayList<Worker> listToAdd){
        workerList.addAll(listToAdd);
    }

    /**
     * Comprueba que el inicio del string sea acorde con el formato establecido (W-......)
     */
    private boolean hasIdCorrect(String id){
        String[] parts = id.split("-");
        return parts[0].equals("W");
    }
}
