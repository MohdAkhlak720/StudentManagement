package com.wecode.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.main.entities.StudentEntity;
import com.wecode.main.enums.GenderEnum;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

	List<StudentEntity> findByGender(GenderEnum gender);

}
