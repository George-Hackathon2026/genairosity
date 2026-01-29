package com.genairosity.genairositybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Bridge entity linking curricula to lesson plans with weekly schedule.
 * Maps to hackathon_teams.genairosity.bridge_curriculum_lesson_plan table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hackathon_teams.genairosity.bridge_curriculum_lesson_plan")
public class BridgeCurriculumLessonPlan {
    @Id
    @Column("bridge_id")
    private Long bridgeId;

    /**
     * Reference to curriculum table.
     */
    @Column("curriculum_id")
    private Integer curriculumId;

    /**
     * Reference to lesson_plan table.
     */
    @Column("lesson_plan_id")
    private Integer lessonPlanId;

    /**
     * Week number in the curriculum (1-12).
     */
    @Column("week_number")
    private Integer weekNumber;

    /**
     * Day number within the week (1-7).
     */
    @Column("day_number")
    private Integer dayNumber;

    /**
     * Time of day for the session (e.g., "14:30").
     */
    @Column("session_time")
    private String sessionTime;

    /**
     * Order of this lesson within the day.
     */
    @Column("sequence_order")
    private Integer sequenceOrder;

    /**
     * When this mapping was created.
     */
    @Column("created_at")
    private LocalDateTime createdAt;

    /**
     * Last update timestamp.
     */
    @Column("updated_at")
    private LocalDateTime updatedAt;
}
