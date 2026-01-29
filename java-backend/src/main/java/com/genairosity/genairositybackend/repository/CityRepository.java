package com.genairosity.genairositybackend.repository;

import com.genairosity.genairositybackend.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
}
