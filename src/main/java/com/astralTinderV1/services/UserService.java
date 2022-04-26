package com.astralTinderV1.services;

import com.astralTinderV1.enttities.User;
import com.astralTinderV1.enums.Gender;
import com.astralTinderV1.enums.Province;
import com.astralTinderV1.enums.Roles;
import com.astralTinderV1.enums.SexualOrientation;
import com.astralTinderV1.exceptions.ServiceException;
import com.astralTinderV1.repositories.UserRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepo;
    private AstralPlaneService apServ;

    @Autowired
    public UserService(UserRepository userRepo, AstralPlaneService apServ) {
        this.userRepo = userRepo;
        this.apServ = apServ;
    }

    @Override
    public UserDetails loadUserByUsername(String eMail) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(eMail);
        if (user == null) {
            throw new UsernameNotFoundException("usuario inexistente");
        }

        List<GrantedAuthority> permissions = new ArrayList<>();
        GrantedAuthority rolePermission = new SimpleGrantedAuthority("ROLE_" + user.getRole());
        permissions.add(rolePermission);

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        session.setAttribute("userSession", user);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), permissions);
    }

    /**
     * no olvidar encriptar contraseñas que sino no entra
     *
     * @param user
     * @throws java.lang.Exception
     */
    @Transactional(rollbackOn = {Exception.class})
    public void save(User user) throws Exception {
        //falta validar    
        validate(user);
        encodedPassword(user);
        apServ.crearPerfilAstral(user);
        user.setRole(Roles.USER);
        userRepo.save(user);
    }

    public void encodedPassword(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    @Transactional(rollbackOn = {Exception.class})
    public User findById(String id) throws ServiceException {
        Optional<User> res;
        res = userRepo.findById(id);
        if (!res.isPresent()) {
            throw new ServiceException("el id no corresponde a alguna persona en la BDD");
        }
        return res.get();
    }

    @Transactional
    public List<User> getAll() {
        return userRepo.findAll();
    }

    public boolean mayorDeEdad(User user) {
        int añoNacio = user.getBirth().getYear();
        int añoAhora = LocalDate.now().getYear();
        int edad = añoAhora - añoNacio;
        if (edad >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public void validate(User user) throws Exception {
        if (user.getName().isEmpty()) {
            throw new Exception("Debe tener un nombre");
        }
        if (user.getSurname().isEmpty()) {
            throw new Exception("Debe tener un apellido ");
        }
        if (mayorDeEdad(user) != true) {
            throw new Exception("Debe ser mayor de 18 años");
        }
        if (user.getBirth() == null) {
            throw new Exception("Debes ingresar tu fecha de nacimiento para la carta astral");
        }
        if (user.getBirthHour().equals(null)) {
            throw new Exception("Debes ingresar tu hora de nacimiento para la carta astral");
        }
        if (user.getPhoneNumber().isEmpty()) {
            throw new Exception("Debes ingresar numero de telefono");
        }
        if (user.getPassword().length() < 6 || user.getPassword().isEmpty()) {
            throw new Exception("La contraseña debe tener más de 6 caracteres");
        }
        if (user.getEmail().isEmpty()) {
            throw new Exception("Debe tener un email");
        }
    }

    public User getUserbyEmail(String username) {
        return userRepo.findByEmail(username);
    }

    @Transactional
    public void changeRole(String id) throws ServiceException {

        Optional<User> res = userRepo.findById(id);

        if (res.isPresent()) {

            User user = res.get();

            if (user.getRole().equals(Roles.USER)) {

                user.setRole(Roles.ADMIN);

            } else if (user.getRole().equals(Roles.ADMIN)) {
                user.setRole(Roles.USER);
            }
        }
    }

    @Transactional
    public User modifyUser(String id, String name, String surname, String phonenumber, Date birth, Date birthHour, String email, Province province, Gender gender, SexualOrientation sexOrient) throws Exception {
        User user = userRepo.getById(id);
        
        user.setName(name);
        user.setSurname(surname);
        user.setPhoneNumber(phonenumber);
        user.setEmail(email);
        user.setBirth(birth);
        user.setBirthHour(birthHour);
        user.setProvince(province);
        user.setGender(gender);
        user.setSexOrient(sexOrient);
        
        
        validate(user);
        apServ.crearPerfilAstral(user);
        encodedPassword(user);

        return userRepo.save(user);
    }

    @Transactional
    public User modifyPassword(String id, String password) {
        User user = userRepo.getById(id);
        user.setPassword(password);
        encodedPassword(user);
        return userRepo.save(user);
    }
}
