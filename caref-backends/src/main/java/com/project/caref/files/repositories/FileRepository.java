package com.project.caref.files.repositories;

import com.project.caref.files.entities.CarefFile;
import com.project.caref.files.entities.enumeration.DocType;
import com.project.caref.models.Car;
import com.project.caref.models.Garage;
import com.project.caref.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Copyright (c) 2020, KTACENT, All Right Reserved.
 * https://www.linkedin.com/in/alex-kouasseu/
 * <p>
 * When : 07/11/2020 -- 13:14
 * By : @author alexk
 * Project : lp-user-service
 * Package : com.lukapharma.api.files.repositories
 */
@Repository
public interface FileRepository extends JpaRepository<CarefFile, Long> {

    List<CarefFile> findByCar(Car car);

    List<CarefFile> findByGarage(Garage garage);

    CarefFile findByUserAndType(User user, DocType type);

    CarefFile findByFileName(String fileName);
}
