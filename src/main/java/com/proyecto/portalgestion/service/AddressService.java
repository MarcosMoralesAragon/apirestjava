package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Address;
import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.utils.IdGenerator;

import java.util.ArrayList;

public class AddressService {

    public static ArrayList<Address> addressList = new ArrayList<>();
    private final IdGenerator idGenerator = new IdGenerator();

    public Integer foundIndex(String id){
        for (int i = 0; i < addressList.size(); i++) {
            if (addressList.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public Address getAddress(String id){
        for (Address address : addressList) {
            if (address.getIdWorker().equals(id)) {
                return address;
            }
        }
        return null;
    }

    public Address createAddress(Address newAddress){
        newAddress.setId(idGenerator.stringGenerator(null, null, addressList));
        addressList.add(newAddress);
        return newAddress;
    }

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

    public ArrayList<Worker> asingAddress(ArrayList<Worker> workerList){
        for (Worker worker: workerList) {
            for (int i = 0; i < addressList.size(); i++) {
                if (worker.getId().equals(addressList.get(i).getIdWorker())){
                    worker.setAddress(addressList.get(i));
                }
            }
        }
        return workerList;
    }
}
