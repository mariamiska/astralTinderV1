package com.astralTinderV1.services;

import com.astralTinderV1.enttities.Photo;
import com.astralTinderV1.enttities.User;
import com.astralTinderV1.enums.Roles;
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
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepo;
    private AstralPlaneService apServ;
    private PhotoService photoServ;

    @Autowired
    public UserService(UserRepository userRepo, AstralPlaneService apServ, PhotoService photoServ) {
        this.userRepo = userRepo;
        this.apServ = apServ;
        this.photoServ = photoServ;
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
    public void save(User user, MultipartFile archivo) throws Exception {
        Photo photo = photoServ.multiPartToEntity(archivo);
        user.setImage(photo);
        age(user);
        validate(user);
        user.setRole(Roles.USER);
        encodedPassword(user);
        apServ.crearPerfilAstral(user);
        userRepo.save(user);
        System.out.println(user);
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
    public User getById(String id) {
        return userRepo.getById(id);
    }

    @Transactional
    public List<User> getAll() {
        return userRepo.findAll();
    }

    public void age(User user) {
        int añoNacio = user.getBirth().getYear();
        int añoAhora = LocalDate.now().getYear();
        int edad = añoAhora - (añoNacio + 1900);
        user.setAge(edad);

    }

    public boolean mayorDeEdad(User user) {
        return user.getAge() >= 18;
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
        if (user.getBirthHour() == null) {
            throw new Exception("Debes ingresar tu hora de nacimiento para la carta astral");
        }
        if (user.getPhoneNumber().isEmpty()) {
            throw new Exception("Debes ingresar numero de telefono");
        }
        if (user.getPassword().length() < 6 || user.getPassword().isEmpty()) {
            throw new Exception("La contraseña debe tener más de 6 caracteres");
        }

        boolean emailExists = getAll().stream().anyMatch(existingUser -> existingUser.getEmail().equals(user.getEmail()));

        if (emailExists) {
            throw new Exception("El email ya existe con otro usuario!");
        }

        if (user.getEmail().isEmpty()) {
            throw new Exception("Debe tener un email");
        }
    }

    public void validateModify(User user) throws Exception {
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
        if (user.getBirthHour() == null) {
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
    public void modifyUser(User user, MultipartFile file) throws Exception {

        age(user);
        validateModify(user);
        apServ.crearPerfilAstral(user);
        encodedPassword(user);
        Photo photo = photoServ.multiPartToEntity(file);
        user.setImage(photo);
        userRepo.save(user);
    }

    @Transactional
    public User modifyPassword(String id, String password) {
        User user = userRepo.getById(id);
        user.setPassword(password);
        encodedPassword(user);
        return userRepo.save(user);
    }

    @Transactional
    public List<User> getMatches(User user) {
        return user.getMatches();
    }

    public void descripcionZodiacal(User user) {
        user.getAstralPlane().getSolarSign().showInfoSolar();
    }
}
