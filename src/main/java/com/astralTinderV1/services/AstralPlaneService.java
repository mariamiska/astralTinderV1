package com.astralTinderV1.services;

import com.astralTinderV1.enttities.AstralPlane;
import com.astralTinderV1.enttities.User;
import com.astralTinderV1.enums.Cualidades;
import com.astralTinderV1.enums.Elements;
import com.astralTinderV1.enums.YearLunarSign;
import com.astralTinderV1.enums.ZodiacSigns;
import com.astralTinderV1.exceptions.ServiceException;
import com.astralTinderV1.repositories.AstralPlaneRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class AstralPlaneService {

    private final AstralPlaneRepository astralRepo;

    @Transactional
    public void crearPerfilAstral(User user) {

        user.setAstralPlane(new AstralPlane());
        resolveSolarSign(user);
        resolveLunarSign(user);
        resolveAscendant(user);
        resolveElement(user);
        resolveCualidad(user);

        astralRepo.save(user.getAstralPlane());
    }

    @Autowired
    public AstralPlaneService(AstralPlaneRepository astralRepo) {
        this.astralRepo = astralRepo;
    }

    public void save(AstralPlane astralPlane) {
        astralRepo.save(astralPlane);
    }

    public AstralPlane findById(String id) throws ServiceException {
        Optional<AstralPlane> res;
        res = astralRepo.findById(id);
        if (!res.isPresent()) {
            throw new ServiceException("el id no corresponde a alguna persona en la BDD");
        }
        return res.get();
    }

    private void resolveSolarSign(User user) {
        Integer month = user.getBirth().getMonth();
        Integer day = user.getBirth().getDay();

        if (month == 00 && day >= 20 || month == 1 && day <= 18) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.ACUARIO);
        } else if (month == 1 && day >= 19 || month == 2 && day <= 20) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.PISCIS);
        } else if (month == 2 && day >= 21 || month == 3 && day <= 19) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.ARIES);
        } else if (month == 3 && day >= 20 || month == 4 && day <= 20) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.TAURO);
        } else if (month == 4 && day >= 21 || month == 5 && day <= 21) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.GEMINIS);
        } else if (month == 5 && day >= 22 || month == 6 && day <= 22) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.CANCER);
        } else if (month == 6 && day >= 23 || month == 7 && day <= 22) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.LEO);
        } else if (month == 7 && day >= 23 || month == 8 && day <= 22) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.VIRGO);
        } else if (month == 8 && day >= 23 || month == 9 && day <= 22) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.LIBRA);
        } else if (month == 9 && day >= 23 || month == 10 && day <= 21) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.ESCORPIO);
        } else if (month == 10 && day >= 22 || month == 11 && day <= 21) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.SAGITARIO);
        } else if (month == 11 && day >= 22 || month == 00 && day <= 19) {
            user.getAstralPlane().setSolarSign(ZodiacSigns.CAPRICORNIO);
        }

    }

    private void resolveLunarSign(User user) {
        int yearU = user.getBirth().getYear();
        int monthU = user.getBirth().getMonth();
        int dayU = user.getBirth().getDay();
        int lunarAdd = modYearAdd(yearU) + modMonthAdd(monthU) + dayU;
        int gradoLunar = lunarAddRefact(lunarAdd);
        switch (gradoLunar) {
            case 0:
            case 1:
            case 27:
            case 28:
                user.getAstralPlane().setLunarSign(ZodiacSigns.ARIES);
                break;
            case 2:
            case 3:
            case 4:
                user.getAstralPlane().setLunarSign(ZodiacSigns.TAURO);
                break;
//            case 5:
//            case 6:
//                user.getAstralPlane().setLunarSign(ZodiacSigns.GEMINIS);
//                break;
            case 7:
            case 8:
                user.getAstralPlane().setLunarSign(ZodiacSigns.CANCER);
                break;
            case 9:
            case 10:
                user.getAstralPlane().setLunarSign(ZodiacSigns.LEO);
                break;
            case 11:
            case 12:
            case 13:
                user.getAstralPlane().setLunarSign(ZodiacSigns.VIRGO);
                break;
            case 14:
            case 15:
                user.getAstralPlane().setLunarSign(ZodiacSigns.LIBRA);
                break;
            case 16:
            case 17:
                user.getAstralPlane().setLunarSign(ZodiacSigns.ESCORPIO);
                break;
            case 18:
            case 19:
                user.getAstralPlane().setLunarSign(ZodiacSigns.SAGITARIO);
                break;
            case 20:
            case 21:
                break;
            case 22:
                user.getAstralPlane().setLunarSign(ZodiacSigns.CAPRICORNIO);
                break;
            case 23:
            case 24:
                user.getAstralPlane().setLunarSign(ZodiacSigns.ACUARIO);
                break;
            case 25:
            case 26:
                user.getAstralPlane().setLunarSign(ZodiacSigns.PISCIS);
                break;
        }

    }

    private int modYearAdd(int num) {
        //num es el año de nacimiento del usuario
        int addValor = 0;
        YearLunarSign[] anioArray = YearLunarSign.values();
        for (YearLunarSign anioArray1 : anioArray) {
            if (anioArray1.anioAtributo() == num) {
                addValor = addValor + anioArray1.modAtributo();
            }
        } 
        return addValor;
    }

    private int modMonthAdd(int num) {
        int mod = 0;
        switch (num) {
            case 0:
                break;
            case 1:
                mod = mod + 4;
                break;
            case 2:
                mod = mod + 4;
                break;
            case 3:
                mod = mod + 8;
                break;
            case 4:
                mod = mod + 11;
                break;
            case 5:
                mod = mod + 14;
                break;
            case 6:
                mod = mod + 17;
                break;
            case 7:
                mod = mod + 21;
                break;
            case 8:
                mod = mod + 24;
                break;
            case 9:
                mod = mod + 27;
                break;
            case 10:
                mod = mod + 3;
                break;
            case 11:
                mod = mod + 6;
                break;
        }
        return mod;
    }

    private int lunarAddRefact(int num) {
        int aux = 0;
        if (num >= 0 && num <= 28) {
            aux = num;
        } else if (num >= 29 && num <= 54) {
            aux = num - 27;
        } else if (num >= 55 && num <= 81) {
            aux = num - 55;
        } else if (num > 81) {
            aux = num - 82;
        }
        return aux;
    }

    private void resolveElement(User user) {
        ZodiacSigns signo = user.getAstralPlane().getSolarSign();
        switch (signo.ordinal()) {
            case 1:
            case 5:
            case 9:
                user.getAstralPlane().setElement(Elements.TIERRA);
                break;
            case 0:
            case 4:
            case 8:
                user.getAstralPlane().setElement(Elements.FUEGO);
                break;
            case 3:
            case 7:
            case 11:
                user.getAstralPlane().setElement(Elements.AGUA);
                break;
            case 2:
            case 6:
            case 10:
                user.getAstralPlane().setElement(Elements.AIRE);
                break;
            default:
                break;
        }
    }

    private void resolveCualidad(User user) {
        ZodiacSigns signo = user.getAstralPlane().getSolarSign();
        switch (signo.ordinal()) {
            case 0:
            case 3:
            case 6:
            case 9:
                user.getAstralPlane().setCualidad(Cualidades.CARDINAL);
                break;
            case 1:
            case 4:
            case 7:
            case 10:
                user.getAstralPlane().setCualidad(Cualidades.FIJO);
                break;
            case 2:
            case 5:
            case 8:
            case 11:
                user.getAstralPlane().setCualidad(Cualidades.MUTABLE);
                break;
            default:
                break;
        }
    }

    private void resolveAscendant(User user) {
        int h = user.getBirthHour().getHours();
        int hour = h - 2;
        if (hour >= 24) {
            hour = 00;
        }
        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.ARIES) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            }
        }

        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.TAURO) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            }
        }

        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.GEMINIS) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            }
        }

        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.CANCER) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            }
        }

        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.LEO) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            }
        }
        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.VIRGO) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            }
        }
        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.LIBRA) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            }
        }
        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.ESCORPIO) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            }
        }

        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.SAGITARIO) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            }
        }
        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.CAPRICORNIO) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            }
        }
        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.ACUARIO) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            }
        }
        if (user.getAstralPlane().getSolarSign() == ZodiacSigns.PISCIS) {
            if (hour >= 6 && hour < 8) {
                user.getAstralPlane().setAscendente(ZodiacSigns.PISCIS);
            } else if (hour >= 8 && hour < 10) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ARIES);
            } else if (hour >= 10 && hour < 12) {
                user.getAstralPlane().setAscendente(ZodiacSigns.TAURO);
            } else if (hour >= 12 && hour < 14) {
                user.getAstralPlane().setAscendente(ZodiacSigns.GEMINIS);
            } else if (hour >= 14 && hour < 16) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CANCER);
            } else if (hour >= 16 && hour < 18) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LEO);
            } else if (hour >= 18 && hour < 20) {
                user.getAstralPlane().setAscendente(ZodiacSigns.VIRGO);
            } else if (hour >= 20 && hour < 22) {
                user.getAstralPlane().setAscendente(ZodiacSigns.LIBRA);
            } else if (hour >= 22 && hour < 00) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ESCORPIO);
            } else if (hour >= 00 && hour < 2) {
                user.getAstralPlane().setAscendente(ZodiacSigns.SAGITARIO);
            } else if (hour >= 2 && hour < 4) {
                user.getAstralPlane().setAscendente(ZodiacSigns.CAPRICORNIO);
            } else if (hour >= 4 && hour < 6) {
                user.getAstralPlane().setAscendente(ZodiacSigns.ACUARIO);
            }
        }
    }
    private int compatibilidad(User user1, User user2) {
        //user1 = usuario en session, user2 = user random
        int solarUser1 = user1.getAstralPlane().getSolarSign().ordinal();
        int solarUser2 = user1.getAstralPlane().getSolarSign().ordinal();
        int k = 0;
        int matriz[][] = {{2, 0, 2, 0, 2, 2, 1, 1, 2, 0, 2, 0},
        {0, 2, 1, 2, 1, 2, 1, 2, 0, 2, 0, 2},
        {2, 1, 1, 0, 2, 1, 2, 0, 1, 0, 2, 0},
        {0, 2, 0, 2, 1, 2, 0, 2, 0, 1, 0, 2},
        {2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 1, 1},
        {2, 2, 1, 2, 1, 1, 0, 2, 1, 2, 1, 1},
        {1, 1, 2, 0, 2, 0, 1, 1, 2, 1, 2, 1},
        {1, 2, 0, 2, 2, 2, 1, 2, 0, 2, 1, 2},
        {2, 0, 1, 0, 2, 1, 2, 0, 1, 0, 2, 0},
        {0, 2, 0, 1, 2, 2, 1, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 1, 1, 2, 1, 2, 0, 2, 0},
        {0, 2, 0, 2, 1, 1, 1, 2, 0, 2, 0, 1}};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (solarUser1 == i && solarUser2 == j) {
                    matriz[i][j] = k;
                }
            }
        }
        //0 es bajo
        //1 es medio 
        //2 es alto
        return k;
    }
}
