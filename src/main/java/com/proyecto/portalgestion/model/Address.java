package com.proyecto.portalgestion.model;

public class Address {

    private String id;
    private String street;
    private Integer number = null;
    private String block;
    private String door;
    private Integer postCode;
    private String locality;
    private String idWorker;

    public Address(){}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}

    public Integer getNumber() {return number;}
    public void setNumber(Integer number) {this.number = number;}

    public String getBlock() {return block;}
    public void setBlock(String block) {this.block = block;}

    public String getDoor() {return door;}
    public void setDoor(String door) {this.door = door;}

    public Integer getPostCode() {return postCode;}
    public void setPostCode(Integer postCode) {this.postCode = postCode;}

    public String getLocality() {return locality;}
    public void setLocality(String locality) {this.locality = locality;}

    public String getIdWorker() {return idWorker;}
    public void setIdWorker(String idWorker) {this.idWorker = idWorker;}

    @Override
    public String toString() {
        return "Addres{" +
                "id='" + id + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", block='" + block + '\'' +
                ", door='" + door + '\'' +
                ", postCode=" + postCode +
                ", locality='" + locality + '\'' +
                ", idWorker='" + idWorker + '\'' +
                '}';
    }
}
