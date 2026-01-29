package com.genairosity.genairositybackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

/**
 * Entity representing a city where Street League operates.
 * Maps to hackathon_teams.genairosity.city table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city", schema = "hackathon_teams.genairosity")
public class City {

    /**
     * A unique identifier for each city where Street League operates,
     * useful for referencing specific locations in the database.
     */
    @Id
    @Column("city_id")
    private Integer cityId;

    /**
     * The name of the city where the academies are located,
     * providing a clear reference for users to identify the location.
     */
    @Column("city_name")
    private String cityName;

    /**
     * An identifier for the region associated with the city,
     * which can help in categorizing cities based on geographical areas.
     */
    @Column("region_id")
    private Integer regionId;

    /**
     * The geographical latitude of the city,
     * which can be used for mapping and location-based services.
     */
    @Column("latitude")
    private Double latitude;

    /**
     * The geographical longitude of the city,
     * complementing the latitude for precise location identification.
     */
    @Column("longitude")
    private Double longitude;

    /**
     * The timestamp indicating when the city record was created,
     * useful for tracking the history of data entries.
     */
    @Column("created_at")
    private LocalDateTime createdAt;

    /**
     * The timestamp showing the last time the city record was updated,
     * helping to maintain data accuracy and relevance.
     */
    @Column("updated_at")
    private LocalDateTime updatedAt;

    /**
     * A boolean value indicating whether the city is currently active
     * in the Street League program, assisting in filtering relevant data.
     */
    @Column("is_active")
    private Boolean isActive;

    /**
     * Information about the origin of the data,
     * which can provide context and reliability for users analyzing the records.
     */
    @Column("data_source")
    private String dataSource;
}
