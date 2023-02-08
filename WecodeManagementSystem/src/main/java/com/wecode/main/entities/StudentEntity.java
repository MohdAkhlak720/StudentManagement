package com.wecode.main.entities;

import java.util.List;

import com.wecode.main.enums.GenderEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String fatherName;
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	private String email;
	private Long mobileNo;

	@OneToOne(mappedBy = "studentEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private AddressEntity addressEntity;

	@OneToMany(mappedBy = "studentEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BatchEntity> batchName;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FeeEntity> feeEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

	public List<BatchEntity> getBatchName() {
		return batchName;
	}

	public void setBatchName(List<BatchEntity> batchName) {
		this.batchName = batchName;
	}

	public List<FeeEntity> getFeeEntities() {
		return feeEntities;
	}

	public void setFeeEntities(List<FeeEntity> feeEntities) {
		this.feeEntities = feeEntities;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", gender=" + gender
				+ ", email=" + email + ", mobileNo=" + mobileNo + ", addressEntity=" + addressEntity + ", batchName="
				+ batchName + ", feeEntities=" + feeEntities + "]";
	}

}
