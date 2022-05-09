
package com.astralTinderV1.enums;

public enum descripSimulator {
   ARI("Sabiduría ariana: la decisión se toma, no se piensa.",
        "Lo importante no es competir, sino ganar.",
        "Nuestra mayor gloria no está en no caer nunca, sino en levantarnos cada vez que caemos.",
        "Que la fuerza te acompañe.",
        "¡Lo quiero ya ya ya!"),
   
   TAU("Disfrutá sólo los placeres del momento.",
        "El lunes empiezo la dieta.",
        "¿Nadie se va a comer eso?",
        "Más vale muerte que... revisar mi punto de vista.",
        "Esto es mío, mío, mío."),
   
   GEMI("El que tiene boca se equivoca.",
        "¡No me callo nada!",
        "La inteligencia es la habilidad de adaptarse a los cambios.",
        "Me siento tan alegre y triste al mismo tiempo.",
        "¿La vida sin juego? ¿Qué es eso?"),
   
   CAN("Lloro sin parar, ¿en qué fase de la luna estamos?",
        "Con mi familia no te metas.",
        "No es sobreprotección, es amor.",
        "Todo tiempo pasado fue mejor.",
        "Cuando uno de mis amigos se crea enemigos, yo los convierto en mis enemigos."),
   
   LEO("Las grandes almas tienen voluntades; las débiles tan solo deseos.",
        "¡Arriba los corazones!",
        "¿Egoista yo? Explicate mejor.",
        "No entiendo por qué no me ama.",
        "Soy lo mejor que me pasó en la vida."),
   
   VIR( "Keep calm and pasame el alcohol en gel.",
        "Ya te dije que te amaba... el año pasado, ¿no te alcanza?",
        "¿Quién te crees que sos?",
        "La casa está en orden.",
        "Tengo mucho por ordenar tovia..."),
   
   LIB("¿Quién soy yo sin vos?",
        "Tal para cual, Pascuala con Pascual.",
        "Dejame pensarlo un tiempo más y te respondo.",
        "La belleza perece en la vida, pero es inmortal en el arte.",
        "Está bien, está bien, ¡hagamos lo que vos quieras!"),
   
   ESC("Yo deseo... tantas cosas.",
        "Antes muerta que sencilla.",
        "¿Cómo que no me amás hasta la muerte?",
        "Ahorremos detalles y vamos a lo importante: el sexo.",
        "Renacer de las cenizas... es mi deporte."),
   
   SAG("¿Tiene corazón este camino? Si tiene, el camino es bueno.",
        "Retroceder nunca, rendirse jamás.",
        "¿Cómo que no tengo razón?",
        "Lo importante es el camino, no la meta",
        "Dme una causa para luchar, no importa cual... solo dame una!"), 
 
   CAP("La paciencia es un árbol de raíz amarga, pero de frutos muy dulces.",
        "Miralos a esos inmaduros, como juegan, se divierten y son felices.",
        "Un viaje de diez mil kilómetros empieza por un solo paso.",
        "No temas de ser lento, teme sólo a detenerte.",
        "Mejor solo que... mejor solo."),
   
   ACU("Para ver extraterrestres solo hace falta asistir a una reunión de acuarianos.",       
        "Te amé tanto pero tanto en ese instante, pero bueh... después me aburrí.",
        "El amor es la celabracion de las diferencias.",
        "Libertad, igualdad, fraternidad.",
        "¡Todos ustedes son taaaan tradicionales!"),
   
   PIS("¿Cómo que no me pueden dar un diagnóstico del tercer ojo?",
        "Si amar estuviese penado, yo estaría condenado a cadena perpetua.",
        "¿¿Colgado yo?? Perdón... ¿¿quién eras vos??",
        "La imaginación es más importante que el conocimiento.",
        "Lindo día para comer una hamburguesa...");
   
   private final String agumento1;
   private final String agumento2;
   private final String agumento3;
   private final String agumento4;
   private final String agumento5;

   private descripSimulator(String agumento1, String agumento2, String agumento3, String agumento4, String agumento5) {
       this.agumento1 = agumento1;
       this.agumento2 = agumento2;
       this.agumento3 = agumento3;
       this.agumento4 = agumento4;
       this.agumento5 = agumento5;
   }

    public String getAgumento1() {
        return agumento1;
    }

    public String getAgumento2() {
        return agumento2;
    }

    public String getAgumento3() {
        return agumento3;
    }

    public String getAgumento4() {
        return agumento4;
    }

    public String getAgumento5() {
        return agumento5;
    }  
}
