package com.genairosity.genairositybackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity representing a workshop or activity session delivered in the Street League program.
 * Maps to hackathon_teams.genairosity.session table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hackathon_teams.genairosity.session")
public class Session {

    /**
     * A unique identifier for each workshop or activity session delivered,
     * allowing for easy tracking and reference.
     */
    @Id
    @Column("session_id")
    private Integer sessionId;

    /**
     * A code that represents the specific session,
     * which can be used for categorization or identification purposes.
     */
    @Column("session_code")
    private String sessionCode;

    /**
     * Identifies the group of participants associated with the session,
     * helping to manage and analyze attendance and engagement.
     */
    @Column("cohort_id")
    private Integer cohortId;

    /**
     * Links to the specific lesson plan that outlines the objectives
     * and activities for the session.
     */
    @Column("lesson_plan_id")
    private Integer lessonPlanId;

    /**
     * Identifies the primary staff member responsible for leading the session,
     * providing accountability and contact information.
     */
    @Column("lead_staff_id")
    private Integer leadStaffId;

    /**
     * Identifies any additional staff members who assisted during the session,
     * ensuring proper support and resource allocation.
     */
    @Column("support_staff_id")
    private Integer supportStaffId;

    /**
     * Indicates the scheduled start time of the session,
     * which is crucial for planning and coordination.
     */
    @Column("start_time")
    private String startTime;

    /**
     * Records the actual duration of the session in minutes,
     * allowing for analysis of time management and session effectiveness.
     */
    @Column("actual_duration_minutes")
    private Integer actualDurationMinutes;

    /**
     * Describes the nature of the session, such as workshop, seminar, or activity,
     * which helps in categorizing the offerings.
     */
    @Column("session_type")
    private String sessionType;

    /**
     * Links to the specific type of sport associated with the session,
     * aiding in the organization of sports-related activities.
     */
    @Column("sport_type_id")
    private Integer sportTypeId;

    /**
     * The number of participants expected to attend the session,
     * useful for planning resources and materials.
     */
    @Column("planned_participants")
    private Integer plannedParticipants;

    /**
     * The actual number of participants who attended the session,
     * allowing for comparison with planned attendance.
     */
    @Column("actual_participants")
    private Integer actualParticipants;

    /**
     * Indicates the current status of the session, such as scheduled, completed, or canceled,
     * providing insight into session management.
     */
    @Column("session_status")
    private String sessionStatus;

    /**
     * Indicates whether weather conditions had an impact on the session,
     * which can be important for future planning and risk assessment.
     */
    @Column("weather_impact")
    private Boolean weatherImpact;

    /**
     * Indicates if there were any external visitors present during the session,
     * which can be relevant for reporting and evaluation.
     */
    @Column("external_visitor")
    private Boolean externalVisitor;

    /**
     * The date on which the session took place,
     * essential for historical records and scheduling.
     */
    @Column("session_date")
    private LocalDate sessionDate;

    /**
     * Records the timestamp of when the session entry was created,
     * useful for tracking changes and data management.
     */
    @Column("created_at")
    private LocalDateTime createdAt;

    /**
     * Records the timestamp of the last update made to the session entry,
     * providing insight into data maintenance.
     */
    @Column("updated_at")
    private LocalDateTime updatedAt;

    /**
     * Indicates whether the session is currently active or not,
     * helping to filter out inactive sessions from reports.
     */
    @Column("is_active")
    private Boolean isActive;

    /**
     * Specifies the origin of the data,
     * which can be important for understanding the context and reliability of the information.
     */
    @Column("data_source")
    private String dataSource;
}
