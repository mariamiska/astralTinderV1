package com.astralTinderV1.services;

import com.astralTinderV1.enttities.Photo;
import com.astralTinderV1.enttities.User;
import com.astralTinderV1.repositories.PhotoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    private User user;

    private Photo multiPartToEntity(MultipartFile file) throws Exception {
        if (file.getSize() == 0) {
            throw new Exception("Debe tener una foto de perfil");
        }
        try {
            Photo photo = new Photo();
            photo.setMime(file.getContentType());
            photo.setName(file.getName());
            photo.setContent(file.getBytes());
            return photo;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void save(Photo entidad) {
        photoRepository.save(entidad);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void eliminar(String id) {

        Photo entidad = photoRepository.getOne(id);
        photoRepository.delete(entidad);
    }

    @Transactional(readOnly = true)
    public Photo getOne(String id) {
        return photoRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    public List<Photo> listarTodos() {
        return photoRepository.findAll();
    }

}
