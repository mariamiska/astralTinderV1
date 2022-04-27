package com.astralTinderV1.enums;

public enum Roles {
    ADMIN("Admin"),
    USER("User");
    
    private final String nameRole;

    private Roles(String nameRole) {
        this.nameRole = nameRole;
    }

    public String showRole() {
        return nameRole;
    } 
}