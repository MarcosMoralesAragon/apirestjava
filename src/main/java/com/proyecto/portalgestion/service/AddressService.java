package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Address;
import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.utils.IdGenerator;

import java.util.ArrayList;

public class AddressService {

    public static ArrayList<Address> addressList = new ArrayList<>();
    private final IdGenerator idGenerator = new IdGenerator();

    /**
     * Busa el index de una dirección en la lista y lo devuelve
     * @return index o en caso de no encontrarlo -1
     */
    public Integer foundIndex(String id){
        for (int i = 0; i < addressList.size(); i++) {
            if (addressList.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Devuelve una dirección en concreto referida a un id
     * @return la dirección si la encuentra sino devuelve null
     */
    public Address getAddress(String id){
        for (Address address : addressList) {
            if (address.getIdWorker().equals(id)) {
                return address;
            }
        }
        return null;
    }

    /**
     * Añade una dirección a la lista, comprobando antes que el id este correcto
     * @return la dirección vacía o rellena
     */
    public Address createAddress(Address newAddress){
        if(newAddress != null) {
            if (!hasIdCorrect(newAddress.getId())) {
                // Si el id es incorrecto ( que es lo que ocurre cuando el empleado es creado en el front)
                // se le asigna un nuevo id
                newAddress.setId(idGenerator.stringGenerator(null, null, addressList));
            }
            addressList.add(newAddress);
            return newAddress;
        } else {
            // La dirección que se quería crear esta vacia
            return null;
        }
    }

    /**
     * Busca a el empleado editado por su id y cambia todos los campos por los del nuevo
     * @return true si lo edita false si no lo edita
     */
    public boolean editAddress(Address editAddress){
        int index = foundIndex(editAddress.getId());
        if (index != -1){
            addressList.get(index).setStreet(editAddress.getStreet());
            addressList.get(index).setNumber(editAddress.getNumber());
            addressList.get(index).setBlock(editAddress.getBlock());
            addressList.get(index).setDoor(editAddress.getDoor());
            addressList.get(index).setPostCode(editAddress.getPostCode());
            addressList.get(index).setLocality(editAddress.getLocality());
            addressList.get(index).setProvince(editAddress.getProvince());
            return true;
        }
        return false;
    }

    /**
     * Recibe una lista de trabajadores y asigna las direcciones a cada uno de ellos
     * @return la nueva lista con las direcciones asignadas
     */
    public ArrayList<Worker> asingAddress(ArrayList<Worker> workerList){
        for (Worker worker: workerList) {
            // Por cada trabajador recorre la lista de direcciones buscando si alguna direccion le pertenece
            for (Address address : addressList) {
                if (worker.getId().equals(address.getIdWorker())) {
                    worker.setAddress(address);
                }
            }
        }
        return workerList;
    }

    /**
     * Comprueba que el id tiene el prefijo adecuado
     * @return true si el prefijo es el correcto false si no lo es
     */
    private boolean hasIdCorrect(String id){
        String[] parts = id.split("-");
        return parts[0].equals("A");
    }
}
