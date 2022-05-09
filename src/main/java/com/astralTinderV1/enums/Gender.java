package com.astralTinderV1.enums;

public enum Gender {

    FEMALE("Mujer"),
    MALE("Hombre"), 
    NO_BINARY("No binario"),
    QUEER("Queer"),
    NON_CONFORMING_GENDER("Género fluido"),
    OTHER("Otro");
    
    private final String name;

    private Gender(String name) {
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}