package com.proyecto.portalgestion.utils;

import com.proyecto.portalgestion.model.Contract;
import com.proyecto.portalgestion.model.Worker;

import java.util.ArrayList;

public class IdGenerator {

    public String stringGenerator(ArrayList<Worker> workerList, ArrayList<Contract> contractList){
        boolean itExist = true;
        String id = "";
        while (itExist){
            if (workerList != null){
                id = idBuilderString("W-");
                itExist = existsInWorkers(workerList, id);
            } else {
                id = idBuilderString("C-");
                itExist = existsInContracts(contractList, id);
            }
        }
        return id;
    }

    private String idBuilderString(String prefix){
        StringBuilder resultado = new StringBuilder();
        resultado.append(prefix);
        for (int i = 0; i < 6; i++) {
            switch ((int)(Math.random()*2)){
                case 0:
                    resultado.append(numAleatorio());
                    break;
                case 1:
                    resultado.append(letraAleatoria());
                    break;
            }
        }
        return resultado.toString();
    }

    private boolean existsInWorkers(ArrayList<Worker> workerList, String newId){
        for (Worker worker : workerList) {
            if (worker.getId().equals(newId)) {
                return true;
            }
        }
        return false;
    }

    private boolean existsInContracts(ArrayList<Contract> contractList, String newId){
        for (Contract contract : contractList) {
            if (contract.getId().equals(newId)) {
                return true;
            }
        }
        return false;
    }

    private String letraAleatoria() {
        int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97);
        return String.valueOf((char) codigoAscii);
    }
    private String numAleatorio() {
        int numeroaleatorio = (int)(Math.random()*10);
        return String.valueOf(numeroaleatorio);
    }
}
