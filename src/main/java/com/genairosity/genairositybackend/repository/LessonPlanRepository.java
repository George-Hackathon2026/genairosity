package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.LessonPlan;
import com.genairosity.genairositybackend.model.CurriculumLessonDto;
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

    @Query("""
            SELECT 
                lp.lesson_plan_id,
                lp.lesson_code,
                lp.lesson_title,
                lp.duration_minutes,
                lp.difficulty_level,
                lp.delivery_method,
                b.week_number,
                b.day_number,
                b.session_time
            FROM hackathon_teams.genairosity.lesson_plan lp
            JOIN hackathon_teams.genairosity.bridge_product_type_lesson_plan b 
                ON lp.lesson_plan_id = b.lesson_plan_id
            JOIN hackathon_teams.genairosity.academy a 
                ON b.product_type_id = a.product_type_id
            JOIN hackathon_teams.genairosity.cohort c 
                ON a.academy_id = c.academy_id
            WHERE c.cohort_id = :cohortId
            AND b.is_active = true
            AND lp.is_active = true
            ORDER BY b.week_number, b.day_number
            """)
    List<CurriculumLessonDto> findCurriculumWithScheduleByCohortId(@Param("cohortId") Integer cohortId);
}
