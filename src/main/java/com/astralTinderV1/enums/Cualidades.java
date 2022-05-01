package com.astralTinderV1.enums;

public enum Cualidades {

    CARDINAL("Cardinal",
            "Los signos de cualidad Cardinal son los que inician las estaciones (verano - otoño - invierno - primavera) por lo que estas personas son las que siempre dan el primer paso. Centran toda su energía en iniciar mil proyectos. Se asocia a ellos el poder, la acción y verse constantemente frente a nuevos retos. Se las ingenian, se impulsan y arriesgan porque hay coraje!",
            "Emprendedores. Lideres. Voluntariosos. Desafiantes. Impetuosos"),    
    FIJO("Fijo",
            "Los signos Fijos comienzan a mediaos de las estaciones (verano - otoño - invierno - primavera) por lo que no tieneden a ser iniciadores, pero si grandes ejecutores de ideas o proyectos. Con su propio empuje son determinados, persistentes, estables en sus acciones y confiables. Básicamente ellos deciden tomar el control de las cosas y ser responsables de que todo funcione. ",
            "Estabilidad. Rigidez. Consistencia. Lealtad. Resistencia"),    
    MUTABLE("Mutable",
            "Los signos Fijos comienzan al final de las estaciones (verano - otoño - invierno - primavera) y por ello estan preparados con una flexibilidad organica para cambio. Son bastante receptivos a adaptarse de la mejor forma a los cambios que se presenten en la marcha. Presentan condiciones para evolucionar, salir de la zona de conford, generar conexiones y comunicar",
            "Flexibilidad. Versatilidad. Adaptabilidad. Inestabilidad. Impredecibles");

    private final String name;
    private final String infoCualidad;
    private final String keywords;

    private Cualidades(String name, String infoCualiad, String keywords) {
        this.name = name;
        this.infoCualidad = infoCualiad;
        this.keywords = keywords;
    }

    public String showName() {
        return name;
    }

    public String showInfoCualidad() {
        return infoCualidad;
    }

    public String showKeywords() {
        return keywords;
    }
}
