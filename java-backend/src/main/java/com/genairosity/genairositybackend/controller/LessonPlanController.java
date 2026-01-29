package com.genairosity.genairositybackend.controller;

import com.genairosity.genairositybackend.entity.LessonPlan;
import com.genairosity.genairositybackend.repository.LessonPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LessonPlanController {
    @Autowired
    private LessonPlanRepository lessonPlanRepository;

    @GetMapping("/cohort/{cohortId}/lessonplans")
    public List<LessonPlan> getStaff(@PathVariable("cohortId") Integer cohortId) {
        return lessonPlanRepository.findLessonPlansByCohortId(cohortId);
    }

}
