package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.Staff;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {
    @Query("SELECT * FROM hackathon_teams.genairosity.staff WHERE is_active = true")
    List<Staff> findAllActive();
}
