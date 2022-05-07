package com.astralTinderV1.services;

import com.astralTinderV1.enttities.Photo;
import com.astralTinderV1.enttities.User;
import com.astralTinderV1.exceptions.ServiceException;
import com.astralTinderV1.repositories.PhotoRepository;
import java.io.IOException;
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

    @Transactional
    public Photo multiPartToEntity(MultipartFile file) throws ServiceException {
        if (file != null) {
            try {
                Photo photo = new Photo();
                photo.setMime(file.getContentType());
                photo.setName(file.getName());
                photo.setContent(file.getBytes());

                return photoRepository.save(photo);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void eliminar(String id) {

        Photo entidad = photoRepository.getOne(id);
        photoRepository.delete(entidad);
    }

    @Transactional(readOnly = true)
    public Photo getOne(String id
    ) {
        return photoRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    public List<Photo> listarTodos() {
        return photoRepository.findAll();
    }

}
