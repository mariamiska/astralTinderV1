package com.astralTinderV1.enums;

public enum Elements {

    AIRE("Aire"), 
    TIERRA("Tierra"), 
    FUEGO("Fuego"), 
    AGUA("Agua");
    
    private final String nameElement;

    private Elements(String nameElement) {
        this.nameElement = nameElement;
    }
    
    public String getNameElement(){
        return this.nameElement;
    }
}
