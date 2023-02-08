package com.wecode.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.main.entities.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
