package com.genairosity.genairositybackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CohortDto {
    // Cohort fields
    private Integer cohortId;
    private String cohortCode;
    private Integer academyId;
    private Integer cohortNumber;
    private Integer maxParticipants;
    private String dayOfWeek;
    private String sessionTime;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isActive;
    private String dataSource;

    // Academy field
    private String venueType;
}
