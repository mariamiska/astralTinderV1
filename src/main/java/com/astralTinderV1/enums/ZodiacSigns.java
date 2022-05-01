package com.astralTinderV1.enums;

public enum ZodiacSigns {

    CAPRICORNIO("Capricornio",
            "Estabilidad, seguridad y tranquilidad es lo que mejor define a un Capricornio. Son personas justas y exigentes con los demás, porque también lo son con ellos mismos. Suelen perder el control de sus emociones, por lo que es fácil que sean pesimistas y melancólicos, pero siempre tratan de buscar ayuda. Por eso es recomendable que mantengan la estabilidad emocional a través de la meditación, respiración o actividades que les ayuden a relajarse."),
    ARIES("Aries",
            "Los Aries son personas llenas de energía y entusiasmo por la vida. Aventureros por naturaleza, les encantan los retos, la libertad y las nuevas ideas, por lo que nunca tienen miedo a los comienzos o nuevas etapas. Son líderes y prefieren dar órdenes a recibirlas. Aries es el primer signo del Zodiaco, de ahí que sean líderes y les guste empezar nuevos retos. Siempre lucharán si creen que la causa merece la pena."),
    VIRGO("Virgo",
            "Los Virgo son observadores, pacientes y les cuesta hacer amigos por su carácter frío que muestran a veces. A pesar de ello tienen encanto y suelen ayudar a los demás cuando se presenta un problema. El método, el estudio y la lógica predominan en ellos, por eso les gusta aprender siempre, así como tener un análisis de la situación. Tanto se paran a pensar que a veces pueden retrasar la conclusión de los proyectos más complicados que llevan a cabo. Son intuitivos y capaces de ver todos los lados de un argumento."),
    LEO("Leo",
            "Es el signo más dominante del Zodiaco. Es creativo y extrovertido. Tienen ambición, fuerza, valentía y seguridad en sus capacidades. No temen a los obstáculos y suelen ser buenos, idealistas e inteligentes. Para los Leo, el lujo y el poder están entre sus gustos. Asimismo, son capaces de utilizar trucos y mentiras para desacreditar a sus enemigos. A veces, también pueden caer en la superioridad y la prepotencia."),
    PISCIS("Piscis",
            "Son tranquilos, amables y pacientes. Los Piscis son sensibles a los sentimientos de los demás y responden con simpatía al tacto y al sufrimiento. Son queridos por el resto de los signos, debido al carácter afable, cariñoso y amable. Les preocupan más los problemas de los demás que los suyos propios. Eso sí, les cuesta mucho luchar por el poder establecido. Son creativos y artísticos."),
    ESCORPIO("Escorpio",
            "Un Escorpio es una persona tranquila que parece alejada de la realidad, aunque nunca dejan de observar todo a su alrededor con el ojo crítico. Tienen mucha fuerza de voluntad y muestran tenacidad, pero también les afecta al estado de ánimo las circunstancias que les rodean. Suelen ser críticos y esto les lleva, a veces, a ser algo resentidos con los demás. Sin embargo son excelentes amigos de aquellos a los que consideran que merecen su respeto."),
    SAGITARIO("Sagitario",
            "Sagitario es el signo más positivo de todo el Zodiaco. Cuando las cosas se ponen complicadas un Sagitario siempre sacará la mejor versión y se olvidará de la negatividad. Entre sus mejores características están las de ser buenos organizadores y abarcar nuevos proyectos y aprender cosas nuevas. El lado negativo es el genio que pueden mostrar a veces, sobre todo cuando detectan que alguien no va a su ritmo. Muchas veces también son exigentes con los demás, porque cuando un objetivo se les pone enfrente no dudan en sacrificarse."),
    LIBRA("Libra",
            "El signo del Zodiaco más civilizado. Tienen encanto, elegancia, buen gusto y son amables y pacíficos, por lo que no es raro que ante conflictos sean imparciales y muestren su rechazo a ellos. Valoran el esfuerzo de los demás y les gusta trabajar en equipo. El lado negativo de Libra es que de lo curiosos que son a veces se entrometen en la vida de los demás. Están en contra de la rutina, y una vez que tengan una opinión de algo no les gusta que se les contradiga."),
    ACUARIO("Acuario",
            "Los Acuario tienen una personalidad fuerte y atractiva, pero hay dos tipos: los que son tímidos, sensibles y pacientes; y los que son exuberantes, vivos y frívolos. Eso sí, ambos son honestos y no dudarán en cambiar su opinión si estaban equivocados. Es el signo más tolerante de los doce, pero tampoco les gusta pertenecer a la multitud. Muchas veces sienten la necesidad de retirarse para meditar. No hacen amigos con facilidad, a pesar de la personalidad abierta que tienen."),
    GEMINIS("Géminis",
            "Carácter doble, complejo y contradictorio es lo que mejor define a un Géminis. Al contrario que los Aries, los Géminis empiezan con entusiasmo nuevas aventuras, pero tienden a aburrirse rápido por la falta de constancia. Son personas cariñosas, amables y generosas, aunque tienen algo de mentirosos si quieren obtener algo. Eso sí, sin perder el encanto. Suelen ser personas que se desaniman con facilidad ante las dificultades, por lo que necesitan escuchar halagos y recibir atención. Inteligencia y capacidad para aprender la tienen, aunque suelen aburrirse en el proceso de aprendizaje."),
    CANCER("Cáncer",
            "Los Cáncer son personas complicadas de clasificar, si se atiende a su carácter. Los hay tímidos y aburridos, pero también brillantes y famosos. De hecho, algunos presentan una alta capacidad literaria y artística, gracias a su capacidad imaginativa. Les encanta ser extrovertidos, pero también tienen tendencia a retraerse. El hogar es lo más importante para ellos, por la seguridad y el calor que encuentran en él."),
    TAURO("Tauro",
            "Un Tauro es una persona que tiene una gran fuerza de voluntad, es práctico y decidido en la toma de decisiones. Suelen ser personas estables y conservadoras y no dudan en seguir a un líder si les despierta confianza. Son gente de paz, por lo que lo normal es que respeten las leyes y normas. El hecho de que tengan entusiasmo por la rutina y la continuidad hace que sean algo tozudos y de ideas fijas. No suelen hundirse en las dificultades y siempre salen adelante. Amantes de la buena comida, bebida y distintos placeres de la vida deben tener cuidado con los excesos.");

    private final String nameSign;
    private final String infoSolar;

    private ZodiacSigns(String nameSign, String infoSolar) {
        this.nameSign = nameSign;
        this.infoSolar = infoSolar;
    }

    public String nameSign() {
        return this.nameSign;
    }

    public String showInfoSolar() {
        return infoSolar;
    }
}
