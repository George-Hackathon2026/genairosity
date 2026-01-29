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
 * Entity representing a staff member in the Street League program.
 * Maps to hackathon_teams.genairosity.staff table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hackathon_teams.genairosity.staff")
public class Staff {

    /**
     * A unique identifier assigned to each staff member,
     * allowing for easy reference and tracking within the system.
     */
    @Id
    @Column("staff_id")
    private Integer staffId;

    /**
     * A specific code associated with each staff member,
     * which may be used for internal identification or categorization purposes.
     */
    @Column("staff_code")
    private String staffCode;

    /**
     * An identifier representing the city where the staff member is based,
     * useful for location-based analysis and reporting.
     */
    @Column("city_id")
    private Integer cityId;

    /**
     * Describes the position or job title of the staff member,
     * providing insight into their responsibilities and functions within the organization.
     */
    @Column("role")
    private String role;

    /**
     * Indicates the nature of the staff member's employment,
     * such as full-time, part-time, or contract, which can affect benefits and scheduling.
     */
    @Column("employment_type")
    private String employmentType;

    /**
     * Represents the total number of years the staff member has worked in relevant roles,
     * which can be an indicator of their expertise and skill level.
     */
    @Column("years_experience")
    private Integer yearsExperience;

    /**
     * Indicates whether the staff member has received certification in first aid,
     * which is important for safety and emergency preparedness.
     */
    @Column("is_first_aid_certified")
    private Boolean isFirstAidCertified;

    /**
     * Shows if the staff member has undergone training in safeguarding practices,
     * essential for protecting vulnerable individuals in their care.
     */
    @Column("is_safeguarding_trained")
    private Boolean isSafeguardingTrained;

    /**
     * Denotes whether the staff member holds qualifications in coaching,
     * relevant for roles that involve training or mentoring others.
     */
    @Column("is_coaching_qualified")
    private Boolean isCoachingQualified;

    /**
     * The date when the staff member was officially hired,
     * useful for tracking tenure and employment history.
     */
    @Column("hire_date")
    private LocalDate hireDate;

    /**
     * Timestamp indicating when the staff member's record was created in the system,
     * important for data management and auditing purposes.
     */
    @Column("created_at")
    private LocalDateTime createdAt;

    /**
     * Timestamp reflecting the last time the staff member's record was updated,
     * which helps in maintaining accurate and current information.
     */
    @Column("updated_at")
    private LocalDateTime updatedAt;

    /**
     * Indicates whether the staff member is currently active in their role,
     * which is crucial for understanding staffing levels and availability.
     */
    @Column("is_active")
    private Boolean isActive;

    /**
     * Specifies the origin of the data for the staff member's record,
     * providing context for data integrity and reliability.
     */
    @Column("data_source")
    private String dataSource;
}
