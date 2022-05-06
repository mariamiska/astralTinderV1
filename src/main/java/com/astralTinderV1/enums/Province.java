package com.astralTinderV1.enums;

public enum Province {

    BUENOS_AIRES("Buenos Aires"), 
    CATAMARCA("Catamarca"), 
    CHACO("Chaco"), 
    LA_PAMPA("La Pampa"), 
    CORDOBA("Córdoba"), 
    SANTA_FE("Santa Fe"), 
    SAN_JUAN("San Juan"), 
    SANTIAGO_DEL_ESTERO("Santiago del Estero"), 
    CORRIENTES("Corrientes"), 
    MENDOZA("Mendoza"), 
    TUCUMAN("Tucumán"), 
    TIERRA_DEL_FUEGO("Tierra del Fuego"), 
    LA_RIOJA("La Rioja"), 
    CHUBUT("Chubut"), 
    NEUQUEN("Neuquen"), 
    RIO_NEGRO("Río Negro"), 
    ENTRE_RIOS("Entre Ríos"), 
    JUJUY("Jujuy"), 
    FORMOSA("Formosa"), 
    SANTA_CRUZ("Santa Cruz"), 
    SAN_LUIS("San Luis"), 
    MISIONES("Misiones"), 
    SALTA("Salta"),
    YPANE("Ypane");
    
    private final String name;

    private Province(String name) {
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}