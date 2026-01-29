package com.genairosity.genairositybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Entity representing a type of program or product offered by the Street League academy.
 * Maps to hackathon_teams.genairosity.product_type table.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hackathon_teams.genairosity.product_type")
public class ProductType {

    /**
     * A unique identifier for each type of program or product
     * offered by the Street League academy.
     */
    @Id
    @Column("product_type_id")
    private Integer productTypeId;

    /**
     * The name of the program or product,
     * providing a clear label for identification.
     */
    @Column("product_type_name")
    private String productTypeName;

    /**
     * A specific code assigned to the product,
     * which can be used for inventory and tracking purposes.
     */
    @Column("product_code")
    private String productCode;

    /**
     * The length of the program or product in weeks,
     * indicating how long participants will be engaged.
     */
    @Column("duration_weeks")
    private Integer durationWeeks;

    /**
     * A detailed explanation of the program or product,
     * outlining its features and benefits.
     */
    @Column("description")
    private String description;

    /**
     * The timestamp indicating when the program or product was created,
     * useful for tracking its introduction.
     */
    @Column("created_at")
    private LocalDateTime createdAt;

    /**
     * The timestamp showing the last time the program or product information was updated,
     * helping to maintain current records.
     */
    @Column("updated_at")
    private LocalDateTime updatedAt;

    /**
     * A flag indicating whether the program or product is currently active
     * and available for enrollment.
     */
    @Column("is_active")
    private Boolean isActive;

    /**
     * Specifies the origin of the data for the product type,
     * providing context for data integrity and reliability.
     */
    @Column("data_source")
    private String dataSource;
}