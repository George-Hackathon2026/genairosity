package com.genairosity.genairositybackend.controller;

import com.genairosity.genairositybackend.entity.City;
import com.genairosity.genairositybackend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        Iterable<City> iterable = cityRepository.findAll();
        iterable.forEach(cities::add);
        return cities;
    }

    @GetMapping("/health")
    public String health() {
        return "API is running!";
    }
}