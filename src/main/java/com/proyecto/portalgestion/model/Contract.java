package com.proyecto.portalgestion.model;

import java.util.Date;

public class Contract {
    private String id;
    private Date dateStartContract;
    private Date dateEndContract = null;
    private Date dateEstimatedEndContract = null;
    private Integer salary;
    private Position position;
    private String idWorkerAsignied;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public Date getDateStartContract() {return dateStartContract;}
    public void setDateStartContract(Date dateStartContract) {this.dateStartContract = dateStartContract;}

    public Date getDateEndContract() {return dateEndContract;}
    public void setDateEndContract(Date dateEndContract) {this.dateEndContract = dateEndContract;}

    public Date getDateEstimatedEndContract() {return dateEstimatedEndContract;}
    public void setDateEstimatedEndContract(Date dateEstimatedEndContract) {this.dateEstimatedEndContract = dateEstimatedEndContract;}

    public Integer getSalary() {return salary;}
    public void setSalary(Integer salary) {this.salary = salary;}

    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}

    public String getIdWorkerAsignied() {return idWorkerAsignied;}
    public void setIdWorkerAsignied(String idWorkerAsignied) {this.idWorkerAsignied = idWorkerAsignied;}

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", dateStartContract=" + dateStartContract +
                ", dateEndContract=" + dateEndContract +
                ", dateEstimatedEndContract=" + dateEstimatedEndContract +
                ", salary=" + salary +
                ", position=" + position +
                ", idWorkerAsignied='" + idWorkerAsignied + '\'' +
                '}';
    }
}
