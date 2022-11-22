package com.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datajpa.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
