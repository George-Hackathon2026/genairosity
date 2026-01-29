package com.genairosity.genairositybackend.controller;

import com.genairosity.genairositybackend.entity.Staff;
import com.genairosity.genairositybackend.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/staff")
    public List<Staff> getStaff() {
        List<Staff> staff = new ArrayList<>();
        Iterable<Staff> iterable = staffRepository.findAllActive();
        iterable.forEach(staff::add);
        return staff;
    }

    @GetMapping("/staff/{staffId}")
    public ResponseEntity<Staff> getStaff(@PathVariable("staffId") Integer staffId) {
        Optional<Staff> optional = staffRepository.findById(staffId);

        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
