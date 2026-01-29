package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.BridgeProductTypeLessonPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BridgeCurriculumLessonPlanRepository extends CrudRepository<BridgeProductTypeLessonPlan, Long> {
}
