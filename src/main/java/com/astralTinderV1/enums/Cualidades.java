package com.astralTinderV1.enums;

public enum Cualidades {

    CARDINAL("Cardinal",
            "Tu cualidad Cardinal corresponde a los signos que inician con las estaciones (verano - otoño - invierno - primavera) por ello tu naturaleza siempre tienee a dar el primer paso. Centras toda su energía en iniciar proyectos. Se asocia a vos el poder, la acción y verte constantemente frente a nuevos retos. Te las ingenias, te impulsas y arriesgas porque tienes un gran coraje!",
            "Emprendedores. Lideres. Voluntariosos. Desafiantes. Impetuosos"),    
    FIJO("Fijo",
            "Tu cualidad Fijo corresponde a los signos que comienzan a mediaos de las estaciones (verano - otoño - invierno - primavera) por ello eres una persona de acción y llebas a cabo ideas o proyectos ya sean propios o no. Con tu propio empuje sos determinad@, persistente, estable en tus acciones y confiable. Decides tomar el control de las cosas y ser responsable de que todo funcione.",
            "Estabilidad. Rigidez. Consistencia. Lealtad. Resistencia"),    
    MUTABLE("Mutable",
            "Tu cualiad Mutable corresponde con signos comienzan al final de las estaciones (verano - otoño - invierno - primavera) y por ello estas preparad@ con una flexibilidad organica para cambio. Sos bastante receptiv@ a adaptarte de la mejor forma a los cambios que se presenten en la marcha. Presentas condiciones para evolucionar, salir de la zona de conford, generar conexiones y comunicar",
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
