package com.astralTinderV1.enums;

public enum Cualidades {
    
    CARDINAL("Cardinal"),
    FIJO("Fijo"),
    MUTABLE("Mutable");
    
    private final String name;

    private Cualidades(String name) {
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}