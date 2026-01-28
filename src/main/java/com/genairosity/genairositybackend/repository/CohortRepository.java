package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.Cohort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends CrudRepository<Cohort, Integer> {
}
