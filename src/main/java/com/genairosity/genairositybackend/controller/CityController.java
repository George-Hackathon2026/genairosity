package com.genairosity.genairositybackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/cities")
    public List<Map<String, Object>> getCities() {
        return jdbcTemplate.queryForList("SELECT * FROM hackathon.emea.city LIMIT 100");
    }

    @GetMapping("/health")
    public String health() {
        return "API is running!";
    }
}