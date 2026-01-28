package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.Cohort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CohortRepository extends CrudRepository<Cohort, Integer> {
    @Query("SELECT * FROM hackathon_teams.genairosity.cohort WHERE is_active = true AND status != 'Complete'")
    List<Cohort> findAllActive();
}
