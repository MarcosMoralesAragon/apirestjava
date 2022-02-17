package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Contract;
import com.proyecto.portalgestion.utils.IdGenerator;

import java.util.ArrayList;

public class ContractService {

    public static ArrayList<Contract> contracts = new ArrayList<>();
    private final IdGenerator idGenerator = new IdGenerator();

    /**
     * Busa el index de un contrato en la lista y lo devuelve
     * @return index o en caso de no encontrarlo -1
     */
    public Integer foundIndex(String id){
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Devuelve la lista de contratos que pertenecen al id del empleado seleccionado
     * @return una lista,vacía o no
     */
    public ArrayList<Contract> getContractsFromWorker(String id){

        ArrayList<Contract> contractsFromWorker = new ArrayList<>();
        for (Contract contract : contracts) {
            if (contract.getIdWorkerAsigned().equals(id)){
                contractsFromWorker.add(contract);
            }
        }
        return contractsFromWorker;
    }

    /**
     * Devuelve un contraco en concreto
     */
    public Contract getContract(String contractId){
        int index = foundIndex(contractId);
        if (index != -1){
            return contracts.get(index);
        }
        return null;
    }

    /**
     * Añade un contrato a lista comprobando antes si su codigo es correcto
     */
    public Contract addContract(Contract newContract){
        try{
            if (!hasIdCorrect(newContract.getId())){
                // Si el id es incorrecto ( que es lo que ocurre cuando el empleado es creado en el front)
                // se le asigna un nuevo id
                newContract.setId(idGenerator.stringGenerator(null,contracts, null));
            }
            contracts.add(newContract);
            return newContract;
        }catch (NullPointerException e){
            // El contrato que se quería crear esta vacío, esto ocuree cuando se carga el archivo
            // excel con alguna de las páguinas sin datos
            return null;
        }

    }

    /**
     * Busca el contrato editado en la lista y procede a editarlo
     * @return true si lo edita false si no edita
     */
    public boolean editContract(Contract changeContract){
        if (changeContract != null){
            int index = foundIndex(changeContract.getId());
            if (index != -1){
                contracts.get(index).setDateStartContract(changeContract.getDateStartContract());
                contracts.get(index).setSalary(changeContract.getSalary());
                contracts.get(index).setPosition(changeContract.getPosition());
                if (changeContract.getDateEndContract() != null) {
                    contracts.get(index).setDateEndContract(changeContract.getDateEndContract());
                }
                if (changeContract.getDateEstimatedEndContract() != null) {
                    contracts.get(index).setDateEstimatedEndContract(changeContract.getDateEstimatedEndContract());
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Borra un contrato concreto de la lista
     * @return true si borra false si no borra
     */
    public boolean deleteContract(String idContract){
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getId().equals(idContract)){
                contracts.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba que el id tiene el prefijo adecuado
     * @return true si el prefijo es el correcto false si no lo es
     */
    private boolean hasIdCorrect(String id){
        String[] parts = id.split("-");
        return parts[0].equals("C");
    }
}
