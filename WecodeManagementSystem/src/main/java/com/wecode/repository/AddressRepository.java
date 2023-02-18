package com.wecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecode.entities.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
