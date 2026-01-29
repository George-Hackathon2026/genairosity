package com.genairosity.genairositybackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumLessonDto {
    // Lesson plan fields
    private Integer lessonPlanId;
    private String lessonCode;
    private String lessonTitle;
    private Integer durationMinutes;
    private String difficultyLevel;
    private String deliveryMethod;

    // Schedule fields from bridge table
    private Integer weekNumber;
    private Integer dayNumber;
    private String sessionTime;
}