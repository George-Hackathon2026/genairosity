package com.genairosity.genairositybackend.controller;

import com.genairosity.genairositybackend.entity.Cohort;
import com.genairosity.genairositybackend.repository.CohortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CohortController {

    @Autowired
    private CohortRepository cohortRepository;

    @GetMapping("/cohort")
    public List<Cohort> getCohorts() {
        List<Cohort> cohorts = new ArrayList<>();
        Iterable<Cohort> iterable = cohortRepository.findAllActive();
        iterable.forEach(cohorts::add);
        return cohorts;
    }

}
