package com.wecode.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.entities.StudentEntity;
import com.wecode.enums.GenderEnum;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

	List<StudentEntity> findByGender(GenderEnum gender);

	Optional<StudentEntity> findByName(String userName);

}
