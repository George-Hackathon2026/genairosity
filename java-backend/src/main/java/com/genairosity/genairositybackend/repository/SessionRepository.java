package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.Session;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {

    @Query("""
        SELECT * FROM hackathon_teams.genairosity.session 
        WHERE (lead_staff_id = :staffId OR support_staff_id = :staffId)
        AND session_date >= :startDate 
        AND session_date <= :endDate
        AND is_active = true
        ORDER BY session_date, start_time
        """)
    List<Session>
    findStaffTimetable(
            @Param("staffId") Integer staffId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

}
