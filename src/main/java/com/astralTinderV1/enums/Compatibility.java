package com.astralTinderV1.enums;


public enum Compatibility {
    
    LOW("Baja"),
    MEDIUM("Media"),
    HIGH("Alta");
    
    private final String nameCompatibility;

    private Compatibility(String nameCompatibility) {
        this.nameCompatibility = nameCompatibility;
    }

    public String getNameCompatibility() {
        return nameCompatibility;
    }
}
