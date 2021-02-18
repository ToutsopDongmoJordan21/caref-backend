package com.project.caref.controllers;

import com.project.caref.exeption.ResourceNotFoundException;
import com.project.caref.models.Car;
import com.project.caref.models.dto.CarDto;
import com.project.caref.repository.AccessoireRepository;
import com.project.caref.repository.CarRepository;
import com.project.caref.service.CarDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarDetailsService carDetailsService;

    @Autowired
    private AccessoireRepository accessoireRepository;

    @GetMapping("/cars")
    public ResponseEntity<?> getAllCars() {
        return ResponseEntity.ok(carDetailsService.findAllCar());
    }

    @GetMapping("/cars/userCreated/{id}")
    public ResponseEntity<?> getUserCreated(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(carDetailsService.findAllByCreatedBy(userId));
    }

    @DeleteMapping("/cars/{id}")
    public Map<String, Boolean> deleteCar(@PathVariable(value = "id") Long carId)
        throws ResourceNotFoundException {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " +carId));

        carRepository.delete(car);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Car was successful delete", Boolean.TRUE);
        return response;
    }

    @PostMapping(value="/cars")
    public ResponseEntity<?> saveCar(@RequestBody CarDto car) throws Exception {
        return ResponseEntity.ok(carDetailsService.save(car));
    }


    @GetMapping("/cars/{id}")
    public ResponseEntity<?> getCarById(@PathVariable(value = "id") Long carId) {
        return ResponseEntity.ok(carDetailsService.findOneCarById(carId));
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<?> updateCar(@PathVariable(value = "id") Long carId,
                                       @RequestBody CarDto carDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(carDetailsService.updateCar(carId,carDto));
    }


}
