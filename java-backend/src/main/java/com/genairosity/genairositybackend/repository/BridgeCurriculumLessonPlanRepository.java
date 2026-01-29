package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.BridgeCurriculumLessonPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BridgeCurriculumLessonPlanRepository extends CrudRepository<BridgeCurriculumLessonPlan, Long> {
}
