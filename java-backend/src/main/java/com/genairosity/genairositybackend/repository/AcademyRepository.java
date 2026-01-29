package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.Academy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends CrudRepository<Academy, Long> {
}
