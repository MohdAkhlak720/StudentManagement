package com.wecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.entities.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

//	@Query(value = "select * from Expense e where e.name =?1", nativeQuery = true)
	List<ExpenseEntity> findByNameIgnoreCase(String name);

}
