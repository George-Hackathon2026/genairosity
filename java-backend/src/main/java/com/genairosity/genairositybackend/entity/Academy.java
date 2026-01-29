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
 * Entity representing an academy instance in the Street League program.
 * Maps to hackathon_teams.genairosity.academy table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hackathon_teams.genairosity.academy")
public class Academy {

    /**
     * Unique identifier for each academy instance,
     * allowing for distinct identification across different records.
     */
    @Id
    @Column("academy_id")
    private Long academyId;

    /**
     * A code representing the specific academy,
     * which can be used for quick reference and categorization.
     */
    @Column("academy_code")
    private String academyCode;

    /**
     * Identifier for the community associated with the academy,
     * linking it to a specific geographical or organizational area.
     */
    @Column("community_id")
    private Integer communityId;

    /**
     * Identifier for the type of product offered by the academy,
     * helping to categorize the offerings available.
     */
    @Column("product_type_id")
    private Integer productTypeId;

    /**
     * The year in which the academy instance is operational,
     * providing context for the data related to that specific time frame.
     */
    @Column("year")
    private Integer year;

    /**
     * The quarter of the year during which the academy instance is active,
     * allowing for seasonal analysis of performance.
     */
    @Column("quarter")
    private Integer quarter;

    /**
     * The maximum number of participants that the academy can accommodate,
     * indicating the scale of operations.
     */
    @Column("capacity")
    private Integer capacity;

    /**
     * Describes the type of venue where the academy is held,
     * which can influence the learning environment and logistics.
     */
    @Column("venue_type")
    private String venueType;

    /**
     * The date when the academy instance begins,
     * marking the commencement of activities and programs.
     */
    @Column("start_date")
    private LocalDate startDate;

    /**
     * The date when the academy instance concludes,
     * indicating the end of the scheduled activities.
     */
    @Column("end_date")
    private LocalDate endDate;

    /**
     * Timestamp indicating when the academy record was created,
     * useful for tracking data entry and changes over time.
     */
    @Column("created_at")
    private LocalDateTime createdAt;

    /**
     * Timestamp showing the last time the academy record was updated,
     * providing insight into the currency of the information.
     */
    @Column("updated_at")
    private LocalDateTime updatedAt;

    /**
     * A boolean value indicating whether the academy instance is currently active,
     * helping to filter out inactive records.
     */
    @Column("is_active")
    private Boolean isActive;

    /**
     * Information about the origin of the data,
     * which can be important for understanding the reliability and context of the records.
     */
    @Column("data_source")
    private String dataSource;
}
