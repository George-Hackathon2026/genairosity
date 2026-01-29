package com.genairosity.genairositybackend.controller;

import com.genairosity.genairositybackend.model.CurriculumLessonDto;
import com.genairosity.genairositybackend.repository.LessonPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CurriculumController {

    @Autowired
    private LessonPlanRepository lessonPlanRepository;

    @GetMapping("/cohort/{cohortId}/curriculum")
    public ResponseEntity<List<CurriculumLessonDto>> getCohortCurriculum(
            @PathVariable Integer cohortId
    ) {
        List<CurriculumLessonDto> curriculum =
                lessonPlanRepository.findCurriculumWithScheduleByCohortId(cohortId);

        return ResponseEntity.ok(curriculum);
    }
}