package com.rental.controllers;

import com.rental.entity.Vehicle;
import com.rental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") String id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return (vehicle != null) ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle createdVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(201).body(createdVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("id") String id) {
        try {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}

