package com.wecode.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.main.entities.BatchEntity;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity, Long> {

}
