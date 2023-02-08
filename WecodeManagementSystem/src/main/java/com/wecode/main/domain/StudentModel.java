package com.wecode.main.domain;

import java.util.List;

import com.wecode.main.enums.GenderEnum;

public class StudentModel {
	private Long id;
	private String name;
	private String fatherName;
	private GenderEnum gender;
	private String email;
	private Long mobileNo;
	private AddressModel addressModel;
	private List<BatchModel> batchModel;
	private List<FeeModel> feeModel;

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

	public AddressModel getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}

	public List<BatchModel> getBatchModel() {
		return batchModel;
	}

	public void setBatchModel(List<BatchModel> batchModel) {
		this.batchModel = batchModel;
	}

	public List<FeeModel> getFeeModel() {
		return feeModel;
	}

	public void setFeeModel(List<FeeModel> feeModel) {
		this.feeModel = feeModel;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", gender=" + gender
				+ ", email=" + email + ", mobileNo=" + mobileNo + ", addressModel=" + addressModel + ", batchModel="
				+ batchModel + ", feeModel=" + feeModel + "]";
	}
}
