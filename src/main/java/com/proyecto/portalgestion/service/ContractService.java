package com.proyecto.portalgestion.service;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.proyecto.portalgestion.model.Contract;
import com.proyecto.portalgestion.utils.IdGenerator;

import java.util.ArrayList;

public class ContractService {

    public static ArrayList<Contract> contracts = new ArrayList<>();
    private final IdGenerator idGenerator = new IdGenerator();

    public Integer foundIndex(String id){
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Contract> getContractsFromWorker(String id){

        ArrayList<Contract> contractsFromWorker = new ArrayList<>();
        for (Contract contract : contracts) {
            if (contract.getIdWorkerAsigned().equals(id)){
                contractsFromWorker.add(contract);
            }
        }
        return contractsFromWorker;
    }

    public Contract getContract(String contractId){
        int index = foundIndex(contractId);
        if (index != -1){
            return contracts.get(index);
        }
        return null;
    }

    public Contract addContract(Contract newContract){
        newContract.setId(idGenerator.stringGenerator(null,contracts, null));
        contracts.add(newContract);
        return newContract;
    }

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

    public boolean deleteContract(String idContract){
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getId().equals(idContract)){
                contracts.remove(i);
                return true;
            }
        }
        return false;
    }
}
