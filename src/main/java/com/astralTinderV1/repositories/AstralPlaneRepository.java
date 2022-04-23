package com.astralTinderV1.repositories;

import com.astraltinder.astralTinder.enttities.AstralPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstralPlaneRepository  extends JpaRepository<AstralPlane,String>{
    
}