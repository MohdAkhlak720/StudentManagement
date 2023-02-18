package com.wecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.entities.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

}
