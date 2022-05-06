package com.astralTinderV1.enums;

public enum YearLunarSign {

    B(1962, 15),
    C(1963, 25),
    D(1964, 9),
    E(1965, 19),
    F(1966, 1),
    G(1967, 11),
    H(1968, 22),
    I(1969, 4),
    J(1970, 13),
    K(1971, 24),
    L(1972, 8),
    M(1973, 17),
    N(1974, 26),
    O(1975, 10),
    P(1976, 21),
    Q(1977, 3),
    R(1978, 12),
    S(1979, 23),
    T(1980, 6),
    U(1981, 16),
    V(1982, 25),
    W(1983, 8),
    X(1984, 19),
    Y(1985, 1),
    Z(1986, 11),
    AA(1987, 21),
    AB(1988, 5),
    AC(1989, 14),
    AD(1990, 24),
    AE(1991, 7),
    AF(1992, 18),
    AG(1993, 27),
    AH(1994, 9),
    AI(1995, 20),
    AJ(1996, 3),
    AK(1997, 13),
    AL(1998, 22),
    AM(1999, 5),
    AN(2000, 17),
    AO(2001, 26),
    AP(2002, 8),
    AQ(2003, 19),
    AR(2004, 3);
    /*18AÑOS*/

    private final int anio;
    private final int modificador;

    private YearLunarSign(int anio, int modificador) {
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
