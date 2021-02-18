package com.project.caref.repository;

import com.project.caref.models.Accessoire;
import com.project.caref.models.Car;
import com.project.caref.models.CarAccessoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarAccessoireRepository extends JpaRepository<CarAccessoire, Long> {
    List<CarAccessoire> findByCar(Car car);
    CarAccessoire findByCarAndAccessoire(Car car, Accessoire accessoire);
}
