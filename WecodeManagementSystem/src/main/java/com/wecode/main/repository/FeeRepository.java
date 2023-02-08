package com.wecode.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.main.entities.FeeEntity;
import com.wecode.main.enums.BatchEnum;

@Repository
public interface FeeRepository extends JpaRepository<FeeEntity, Long> {

	List<FeeEntity> findByStudentIdAndBatch(Long studentId, BatchEnum batch);

}
