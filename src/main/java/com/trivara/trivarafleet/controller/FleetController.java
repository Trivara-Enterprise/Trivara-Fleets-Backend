package com.trivara.trivarafleet.controller;

import com.trivara.trivarafleet.entity.Vehicle;
import com.trivara.trivarafleet.entity.Driver;
import com.trivara.trivarafleet.repository.VehicleRepository;
import com.trivara.trivarafleet.repository.DriverRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fleet")
public class FleetController {

    private final VehicleRepository vehicleRepo;
    private final DriverRepository driverRepo;

    public FleetController(VehicleRepository vehicleRepo, DriverRepository driverRepo) {
        this.vehicleRepo = vehicleRepo;
        this.driverRepo = driverRepo;
    }

    // --- Vehicle (Postgres) ---
    @PostMapping("/vehicles")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleRepo.findAll();
    }

    // --- Driver (H2) ---
    @PostMapping("/drivers")
    public Driver addDriver(@RequestBody Driver driver) {
        return driverRepo.save(driver);
    }

    @GetMapping("/drivers")
    public List<Driver> getDrivers() {
        return driverRepo.findAll();
    }
}
