package com.genairosity.genairositybackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

/**
 * Entity representing a cohort group within the academies.
 * Maps to hackathon_teams.genairosity.cohort table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hackathon_teams.genairosity.cohort")
public class Cohort {

    /**
     * Unique identifier for each cohort group within the academies,
     * allowing for easy reference and management.
     */
    @Id
    @Column("cohort_id")
    private Integer cohortId;

    /**
     * A specific code assigned to each cohort,
     * which can be used for quick identification and categorization.
     */
    @Column("cohort_code")
    private String cohortCode;

    /**
     * Identifier for the academy to which the cohort belongs,
     * linking the cohort to its respective institution.
     */
    @Column("academy_id")
    private Integer academyId;

    /**
     * Sequential number representing the cohort's order or position within the academy,
     * useful for organization.
     */
    @Column("cohort_number")
    private Integer cohortNumber;

    /**
     * The maximum number of participants allowed in the cohort,
     * which helps in planning and resource allocation.
     */
    @Column("max_participants")
    private Integer maxParticipants;

    /**
     * Indicates the day of the week when the cohort sessions are scheduled,
     * providing insight into the cohort's timetable.
     */
    @Column("day_of_week")
    private String dayOfWeek;

    /**
     * The specific time at which the cohort sessions take place,
     * essential for scheduling and attendance tracking.
     */
    @Column("session_time")
    private String sessionTime;

    /**
     * Current status of the cohort, which may indicate whether it is active,
     * completed, or canceled, aiding in management decisions.
     */
    @Column("status")
    private String status;

    /**
     * Timestamp indicating when the cohort was created,
     * useful for tracking the history and changes over time.
     */
    @Column("created_at")
    private LocalDateTime createdAt;

    /**
     * Timestamp showing the last time the cohort information was updated,
     * important for maintaining accurate records.
     */
    @Column("updated_at")
    private LocalDateTime updatedAt;

    /**
     * Boolean value indicating whether the cohort is currently active,
     * helping to filter out inactive cohorts in reports.
     */
    @Column("is_active")
    private Boolean isActive;

    /**
     * Information about the origin of the data for the cohort,
     * which can be important for data integrity and auditing.
     */
    @Column("data_source")
    private String dataSource;
}
