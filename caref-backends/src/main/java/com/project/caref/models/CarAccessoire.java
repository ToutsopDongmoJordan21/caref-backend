package com.project.caref.models;

import com.project.caref.exeption.ResourceNotFoundException;
import com.project.caref.files.dto.FileDto;
import com.project.caref.models.dto.CarDto;
import com.project.caref.models.dto.CarResponseDto;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "car_accessoire")
public class CarAccessoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id",
            referencedColumnName = "id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accessoire_id",
            referencedColumnName = "id")
    private Accessoire accessoire;

    public CarAccessoire() {
    }

    public CarAccessoire(Long id, Car car, Accessoire accessoire) {
        this.id = id;
        this.car = car;
        this.accessoire = accessoire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Accessoire getAccessoire() {
        return accessoire;
    }

    public void setAccessoire(Accessoire accessoire) {
        this.accessoire = accessoire;
    }


    }
