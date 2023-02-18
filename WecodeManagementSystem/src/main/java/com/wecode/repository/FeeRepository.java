package com.wecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.entities.FeeEntity;
import com.wecode.enums.BatchEnum;

@Repository
public interface FeeRepository extends JpaRepository<FeeEntity, Long> {

	List<FeeEntity> findByStudentIdAndBatch(Long studentId, BatchEnum batch);

}
