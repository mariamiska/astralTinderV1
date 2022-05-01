package com.astralTinderV1.enums;

public enum Elements {

    AIRE("Aire",
            "Tu elemento es el Aire, que representa la mente, el intelecto, la respiración. El aire trae la razón, la comunicación, el entendimiento. El aire representa las ideas, la objetividad, el raciocinio, los intercambios. En exceso nos encontramos con la dispersión, la superficialidad, la frialdad, la indecisión, la rebeldía, el anarquismo, la falsedad y la mentira."),  
    TIERRA("Tierra",
            "Tu elemento es la Tierra. Está representado por la materialidad del impulso energético del fuego. La habilidad de concretar cosas, la practicidad y la creatividad son sus características. En exceso trae terquedad, estancamiento, lentitud, rigidez, crítica, escepticismo, crueldad e insensibilidad."), 
    FUEGO("Fuego",
            "Tu elemento es el Fuego. Es representado por el ánimo, el entusiasmo, la energía, la voluntad y la pasión. El fuego trae la acción, la proactividad, la energía. El placer de vivir, el impulso de la superación y el crecimiento continuo como seres humanos. Pero si lo encontramos en exceso, trae agresividad, irritabilidad, arrogancia, orgullo y vanidad que pueden ser clasificados como los puntos negativos de los signos de fuego."),    
    AGUA("Agua",
            "Tu elemento es el Agua. Es el sentir, la emoción. No entienden con la mente sino con el corazón. Es la comprensión que va más allá de la mente. En exceso causa actitudes infantiles, caprichos, manipulación, infiltración, vulnerabilidad, inconstancia e inestabilidad.");

    private final String nameElement;
    private final String infoElement;
    
    private Elements(String nameElement, String infoElement) {
        this.nameElement = nameElement;
        this.infoElement = infoElement;
    }

    public String showNameElement() {
        return this.nameElement;
    }

    public String showInfoElement() {
        return infoElement;
    }
}
