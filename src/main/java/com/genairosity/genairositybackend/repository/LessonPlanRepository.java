package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.LessonPlan;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonPlanRepository extends CrudRepository<LessonPlan, Integer> {

    @Query("""
            SELECT lp.* 
            FROM hackathon_teams.genairosity.lesson_plan lp
            JOIN hackathon_teams.genairosity.academy a 
                ON lp.product_type_id = a.product_type_id
            JOIN hackathon_teams.genairosity.cohort c 
                ON c.academy_id = a.academy_id
            WHERE c.cohort_id = :cohortId
            AND lp.is_active = true
            ORDER BY lp.difficulty_level, lp.lesson_title
            """)
    List<LessonPlan> findLessonPlansByCohortId(@Param("cohortId") Integer cohortId);
}
