package com.wecode.main.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer pincode;
	private String city;
	private String state;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "studentId", nullable = false)
	private StudentEntity studentEntity;

	@OneToOne(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CountryEntity country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

}
