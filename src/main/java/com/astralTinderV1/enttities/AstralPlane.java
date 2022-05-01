package com.astralTinderV1.enttities;

import com.astralTinderV1.enums.Cualidades;
import com.astralTinderV1.enums.Elements;
import com.astralTinderV1.enums.ZodiacSigns;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    
    @Enumerated(EnumType.STRING)
    private ZodiacSigns ascendente;
    
    @Enumerated(EnumType.STRING)
    private ZodiacSigns lunarSign;
    
    @Enumerated(EnumType.STRING)
    private ZodiacSigns solarSign;

    @Enumerated(EnumType.STRING)
    private Cualidades cualidad;
    
    @Enumerated(EnumType.STRING)
    private Elements element;

}
