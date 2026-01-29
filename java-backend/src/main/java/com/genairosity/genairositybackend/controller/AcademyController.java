package com.genairosity.genairositybackend.controller;

import com.genairosity.genairositybackend.entity.Academy;
import com.genairosity.genairositybackend.repository.AcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AcademyController {

    @Autowired
    private AcademyRepository academyRepository;

    @GetMapping("/academies")
    public List<Academy> getCities() {
        List<Academy> academies = new ArrayList<>();
        Iterable<Academy> iterable = academyRepository.findAll();
        iterable.forEach(academies::add);
        return academies;
    }
}
