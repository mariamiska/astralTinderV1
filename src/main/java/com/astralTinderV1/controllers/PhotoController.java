package com.astralTinderV1.controllers;

import com.astralTinderV1.enttities.User;
import com.astralTinderV1.exceptions.ServiceException;
import com.astralTinderV1.services.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class PhotoController {
    
    @Autowired
    private UserService userServ;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USUARIO')")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<byte[]> photoUser(@PathVariable String id) {

        try {
            User user = userServ.findById(id);
            if (user.getImage() == null) {
                throw new ServiceException("El usuario no tiene una foto asignada.");
            }
            byte[] photo = user.getImage().getContent();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(photo, headers, HttpStatus.OK);
        } catch (ServiceException ex) {
            Logger.getLogger(PhotoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

  
}
