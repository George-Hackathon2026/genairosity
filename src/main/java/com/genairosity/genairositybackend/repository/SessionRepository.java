package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {
}
