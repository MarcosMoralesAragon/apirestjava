package com.proyecto.portalgestion.model;

import java.util.Date;

public class Worker {
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private String dni;
    private Date bornDate = new Date();
    private String bornDateString;
    private String nationality;
    private State state;
    private Address address = null;

    public Worker(){}

    public Worker(String id, String name, String firstName, String lastName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}

    public Date getBornDate() {return bornDate;}
    public void setBornDate(Date bornDate) {this.bornDate = bornDate;}

    public String getBornDateString() {return bornDateString;}
    public void setBornDateString(String bornDateString) {this.bornDateString = bornDateString;}

    public String getNationality() {return nationality;}
    public void setNationality(String nationality) {this.nationality = nationality;}

    public State getState() {return state;}
    public void setState(State state) {this.state = state;}

    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fistName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", bornDate=" + bornDate +
                ", nationality='" + nationality + '\'' +
                ", state=" + state +
                ", address=" + address +
                '}';
    }
}
