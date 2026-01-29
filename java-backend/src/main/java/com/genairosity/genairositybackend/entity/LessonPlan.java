package com.genairosity.genairositybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity representing a lesson plan in the Street League program.
 * Maps to hackathon_teams.genairosity.lesson_plan table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hackathon_teams.genairosity.lesson_plan")
public class LessonPlan {

    /**
     * A unique identifier for each lesson plan,
     * allowing for easy reference and management of lesson plans.
     */
    @Id
    @Column("lesson_plan_id")
    private Integer lessonPlanId;

    /**
     * A specific code assigned to each lesson,
     * which can be used for categorization and quick identification.
     */
    @Column("lesson_code")
    private String lessonCode;

    /**
     * The title of the lesson,
     * providing a brief description of the content and focus of the lesson plan.
     */
    @Column("lesson_title")
    private String lessonTitle;

    /**
     * An identifier linking the lesson plan to a specific theme,
     * helping to categorize lessons by overarching topics.
     */
    @Column("theme_id")
    private Integer themeId;

    /**
     * An identifier that classifies the type of product associated with the lesson plan,
     * aiding in product management.
     */
    @Column("product_type_id")
    private Integer productTypeId;

    /**
     * The total time allocated for the lesson, measured in minutes,
     * which helps in scheduling and planning.
     */
    @Column("duration_minutes")
    private Integer durationMinutes;

    /**
     * Indicates the complexity of the lesson,
     * providing guidance on the appropriate audience and skill level required.
     */
    @Column("difficulty_level")
    private String difficultyLevel;

    /**
     * Describes how the lesson will be delivered,
     * such as in-person, online, or hybrid, which is essential for planning logistics.
     */
    @Column("delivery_method")
    private String deliveryMethod;

    /**
     * Indicates whether specific equipment is needed for the lesson,
     * helping to ensure all necessary resources are available.
     */
    @Column("requires_equipment")
    private Boolean requiresEquipment;

    /**
     * The maximum number of participants allowed in the lesson,
     * which is important for managing class sizes and resources.
     */
    @Column("max_participants")
    private Integer maxParticipants;

    /**
     * Tracks the version of the lesson plan,
     * allowing for updates and revisions to be managed effectively.
     */
    @Column("version")
    private String version;

    /**
     * The date from which the lesson plan is considered valid,
     * helping to manage the relevance of the content over time.
     */
    @Column("effective_from")
    private LocalDate effectiveFrom;

    /**
     * The timestamp indicating when the lesson plan was created,
     * useful for tracking the history of lesson plans.
     */
    @Column("created_at")
    private LocalDateTime createdAt;

    /**
     * The timestamp showing the last time the lesson plan was modified,
     * important for maintaining up-to-date information.
     */
    @Column("updated_at")
    private LocalDateTime updatedAt;

    /**
     * Indicates whether the lesson plan is currently active and available for use,
     * assisting in managing lesson offerings.
     */
    @Column("is_active")
    private Boolean isActive;

    /**
     * Identifies the source of the data for the lesson plan,
     * which can be useful for understanding the context and reliability of the information.
     */
    @Column("data_source")
    private String dataSource;
}