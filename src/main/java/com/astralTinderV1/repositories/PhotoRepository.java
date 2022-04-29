package com.astralTinderV1.repositories;

import com.astralTinderV1.enttities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {
    
}
