package com.astralTinderV1.enums;

public enum ZodiacSigns {

    CAPRICORNIO("Capricornio"),
    ARIES("Aries"),
    VIRGO("Virgo"),
    LEO("Leo"),
    PISCIS("Piscis"),
    ESCORPIO("Escorpio"),
    SAGITARIO("Sagitario"),
    LIBRA("Libra"),
    ACUARIO("Acuario"),
    GEMINIS("Géminis"),
    CANCER("Cáncer"),
    TAURO("Tauro");

    private final String nameSign;

    private ZodiacSigns(String nameSign) {
        this.nameSign = nameSign;
    }
        
    public String nameSign(){
        return this.nameSign;
    }
}
