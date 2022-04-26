package com.astralTinderV1.enums;

import static com.astralTinderV1.enums.Cualidades.*;
import static com.astralTinderV1.enums.Elements.*;

public enum ZodiacSigns {

    CAPRICORNIO(TIERRA, CARDINAL, "Capricornio"),
    ARIES(FUEGO, CARDINAL, "Aries"),
    VIRGO(TIERRA, MUTABLE, "Virgo"),
    LEO(FUEGO, FIJO, "Leo"),
    PISCIS(AGUA, MUTABLE, "Piscis"),
    ESCORPIO(AGUA, FIJO, "Escorpio"),
    SAGITARIO(FUEGO, MUTABLE, "Sagitario"),
    LIBRA(AIRE, CARDINAL, "Libra"),
    ACUARIO(AIRE, FIJO, "Acuario"),
    GEMINIS(AIRE, MUTABLE, "Géminis"),
    CANCER(AGUA, CARDINAL, "Cáncer"),
    TAURO(TIERRA, FIJO, "Tauro");

    private final Elements elemento;
    private final Cualidades cualidad;
    private final String nameSign;

    private ZodiacSigns(Elements elemento, Cualidades cualidad, String nameSign) {
        this.elemento = elemento;
        this.cualidad = cualidad;
        this.nameSign = nameSign;
    }
    


    public Elements showElement() {
        return this.elemento;
    }

    public Cualidades showCualidad() {
        return this.cualidad;
    }
    
    public String nameSign(){
        return this.nameSign;
    }
}
