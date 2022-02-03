package com.proyecto.portalgestion.model;

public enum Position {
    Executive ("Directivo"),
    Officer ("Oficial"),
    Worker ("Operario"),
    Technician ("Tecnico");

    private String position;

    Position(String position){this.position = position;}

    @Override
    public String toString(){return this.position;}
}
