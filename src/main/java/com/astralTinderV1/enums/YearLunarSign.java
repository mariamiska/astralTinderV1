package com.astralTinderV1.enums;

public enum YearLunarSign {

    B(62, 15),
    C(63, 25),
    D(64, 9),
    E(65, 19),
    F(66, 1),
    G(67, 11),
    H(68, 22),
    I(69, 4),
    J(70, 13),
    K(71, 24),
    L(72, 8),
    M(73, 17),
    N(74, 26),
    O(75, 10),
    P(76, 21),
    Q(77, 3),
    R(78, 12),
    S(79, 23),
    T(80, 6),
    U(81, 16),
    V(82, 25),
    W(83, 8),
    X(84, 19),
    Y(85, 1),
    Z(86, 11),
    AA(87, 21),
    AB(88, 5),
    AC(89, 14),
    AD(90, 24),
    AE(91, 7),
    AF(92, 18),
    AG(93, 27),
    AH(94, 9),
    AI(95, 20),
    AJ(96, 3),
    AK(97, 13),
    AL(98, 22),
    AM(99, 5),
    AN(00, 17),
    AO(01, 26),
    AP(02, 8),
    AQ(03, 19),
    AR(04, 3);
    /*18AÑOS*/

    private final Integer anio;
    private final Integer modificador;

    private YearLunarSign(Integer anio, Integer modificador) {
        this.anio = anio;
        this.modificador = modificador;
    }

    public int anioAtributo() {
        return this.anio;
    }

    public int modAtributo() {
        return this.modificador;
    }
}
