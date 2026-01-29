package com.genairosity.genairositybackend.controller;

import com.genairosity.genairositybackend.entity.Session;
import com.genairosity.genairositybackend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TimetableController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/staff/{staffId}/timetable")
    public List<Session> getStaffTimetable(
            @PathVariable Integer staffId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        // Default to next 180 days if dates not provided
        if (startDate == null) {
            startDate = LocalDate.now();
        }
        if (endDate == null) {
            endDate = startDate.plusDays(180);
        }

        return sessionRepository.findStaffTimetable(staffId, startDate, endDate);
    }
}