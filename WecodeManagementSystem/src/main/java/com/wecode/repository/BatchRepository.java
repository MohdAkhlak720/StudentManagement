package com.wecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.entities.BatchEntity;

@Repository
public interface BatchRepository extends JpaRepository<BatchEntity, Long> {

}
