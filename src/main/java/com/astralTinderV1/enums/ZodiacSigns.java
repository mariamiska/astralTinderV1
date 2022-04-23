package com.astralTinderV1.enums;
<<<<<<< HEAD

import static com.astralTinderV1.enums.Cualidades.*;
import static com.astralTinderV1.enums.Elements.*;
=======

import static com.astralTinderV1.enums.Cualidades.*;
import static com.astralTinderV1.enums.Elements.*;

>>>>>>> 6b81525c6e4959d33ee4f159b584192c4ead8fc1

public enum ZodiacSigns {

    CAPRICORNIO(TIERRA, CARDINAL),
    ARIES(FUEGO, CARDINAL),
    VIRGO(TIERRA, MUTABLE),
    LEO(FUEGO, FIJO),
    PISCIS(AGUA, MUTABLE),
    ESCORPIO(AGUA, FIJO),
    SAGITARIO(FUEGO, MUTABLE),
    LIBRA(AIRE, CARDINAL),
    ACUARIO(AIRE, FIJO),
    GEMINIS(AIRE, MUTABLE),
    CANCER(AGUA, CARDINAL),
    TAURO(TIERRA, FIJO);

    private Elements elemento;
    private Cualidades cualidad;

    private ZodiacSigns(Elements elemento, Cualidades cualidad) {
        this.elemento = elemento;
        this.cualidad = cualidad;
    }

    public Elements showElement() {
        return this.elemento;
    }

    public Cualidades showCualidad() {
        return this.cualidad;
    }
}
