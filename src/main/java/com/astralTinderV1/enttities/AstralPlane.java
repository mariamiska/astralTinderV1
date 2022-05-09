package com.astralTinderV1.enttities;

import com.astralTinderV1.enums.Cualidades;
import com.astralTinderV1.enums.Elements;
import com.astralTinderV1.enums.ZodiacSigns;
import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class AstralPlane {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private ZodiacSigns ascendente;

    private ZodiacSigns lunarSign;

    private ZodiacSigns solarSign;

    private Cualidades cualidad;

    private Elements element;
}
