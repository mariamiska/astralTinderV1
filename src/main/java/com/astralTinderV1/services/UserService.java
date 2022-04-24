package com.astralTinderV1.services;

import com.astralTinderV1.enttities.User;
import com.astralTinderV1.exceptions.ServiceException;
import com.astralTinderV1.repositories.UserRepository;
import java.time.LocalDate;
import java.util.ArrayList;
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        apServ.crearPerfilAstral(user);
        userRepo.save(user);
        System.out.println(user);
        System.out.println(user.getAstralPlane());

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
}
