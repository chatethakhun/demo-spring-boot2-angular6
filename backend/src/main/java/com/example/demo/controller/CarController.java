package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.entity.Result;
import com.example.demo.reposity.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {
    private CarRepository repository;

    @Autowired
    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Result addCar(@RequestBody String name) {
        Car car = new Car();
        car.setName(name);
        repository.save(car);
        Result result  =  new Result();
        result.setResult(true);
        result.setMessage("add message successfull");
        return result;
    }

    @GetMapping
    public List<Car> getAllCar() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
}
