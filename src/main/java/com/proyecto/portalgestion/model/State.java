package com.proyecto.portalgestion.model;

public enum State {

    Working("0"),
    Down("1"),
    InProcess("2");

    private String state;
    State(String state) { this.state = state; }

    @Override
    public String toString(){return this.state;}
}