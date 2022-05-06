package com.astralTinderV1.enttities;

import com.astralTinderV1.enums.Gender;
import com.astralTinderV1.enums.Province;
import com.astralTinderV1.enums.Roles;
import com.astralTinderV1.enums.SexualOrientation;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    private String name;

    private String surname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @DateTimeFormat(pattern = "HH:mm")
    private Date birthHour;

    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo image;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> matches;

    @ManyToMany
    private List<User> likeReceived;

    @ManyToMany
    private List<User> likeSent;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Province province;

    @Enumerated(EnumType.STRING)
    private SexualOrientation sexOrient;

    @OneToOne
    private AstralPlane astralPlane;

    @Override
    public String toString() {
        return "eish2";
    }
    
}
