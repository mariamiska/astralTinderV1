package com.astralTinderV1.enums;

public enum SexualOrientation {

    LESBIAN("Lesbian"),
    GAY("Gay"),
    HETEROSEXUAL("Heterosexual"),
    BISEXUAL("Bisexual"),
    PANSEXUAL("Pansexual"),
    ASEXUAL("Asexual"),
    OTHER("Otro");
    
    private final String name;

    private SexualOrientation(String name) {
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}