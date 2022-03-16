package com.proyecto.portalgestion.utils;

import com.proyecto.portalgestion.model.Address;
import com.proyecto.portalgestion.model.Contract;
import com.proyecto.portalgestion.model.Worker;

import java.util.ArrayList;

public class IdGenerator {

    /**
     * Funcion principal, recibe como parametro una de las 3 posibles listas del sitema
     * y en funcion de cual reciba crea un string usando distintos prefijos
     * @return el id ya generado
     */
    public String stringGenerator(ArrayList<Worker> workerList,
                                  ArrayList<Contract> contractList,
                                  ArrayList<Address> addressList){
        boolean itExist = true;
        String id = "";
        while (itExist){
            if (workerList != null){
                id = idBuilderString("W-");
                itExist = existsInWorkers(workerList, id);
            } else if (contractList != null){
                id = idBuilderString("C-");
                itExist = existsInContracts(contractList, id);
            } else if(addressList != null){
                id = idBuilderString("A-");
                itExist = existsInAddress(addressList, id);
            }
        }
        return id;
    }

    /**
     * Rellena la cadena con 6 caracteres aleatorios entre numeros y letras
     * @return devuele el id
     */
    private String idBuilderString(String prefix){
        StringBuilder resultado = new StringBuilder();
        resultado.append(prefix);
        for (int i = 0; i < 6; i++) {
            switch ((int)(Math.random()*2)){
                case 0:
                    resultado.append(randomNum());
                    break;
                case 1:
                    resultado.append(randomLetter());
                    break;
            }
        }
        return resultado.toString();
    }

    /**
     * Se asegura que el id no exista en la lista de los empleados para evitar 2 códigos iguales
     * @return true si existe false si no existe
     */
    private boolean existsInWorkers(ArrayList<Worker> workerList, String newId){
        for (Worker worker : workerList) {
            if (worker.getId().equals(newId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Se asegura que el id no exista en la lista de los contratos para evitar 2 códigos iguales
     * @return true si existe false si no existe
     */
    private boolean existsInContracts(ArrayList<Contract> contractList, String newId){
        for (Contract contract : contractList) {
            if (contract.getId().equals(newId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Se asegura que el id no exista en la lista de las direcciones para evitar 2 códigos iguales
     * @return true si existe false si no existe
     */
    private boolean existsInAddress(ArrayList<Address> addressList, String newId){
        for (Address address : addressList) {
            if (address.getId().equals(newId)) {
                return true;
            }
        }
        return false;
    }


    private String randomLetter() {
        int codigoAscii = (int)Math.floor(Math.random()*(122 - 97)+97);
        return String.valueOf((char) codigoAscii);
    }
    private String randomNum() {
        int numeroaleatorio = (int)(Math.random()*10);
        return String.valueOf(numeroaleatorio);
    }
}
