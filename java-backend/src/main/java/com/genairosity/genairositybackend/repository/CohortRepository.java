package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.Cohort;
import com.genairosity.genairositybackend.model.CohortDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CohortRepository extends CrudRepository<Cohort, Integer> {

    @Query("""
            SELECT 
                c.cohort_id,
                c.cohort_code,
                c.academy_id,
                c.cohort_number,
                c.max_participants,
                c.day_of_week,
                c.session_time,
                c.status,
                c.created_at,
                c.updated_at,
                c.is_active,
                c.data_source,
                a.venue_type
            FROM hackathon_teams.genairosity.cohort c
            JOIN hackathon_teams.genairosity.academy a ON c.academy_id = a.academy_id
            WHERE c.is_active = true AND c.status != 'Completed'
            """)
    List<CohortDto> findAllActive();
}