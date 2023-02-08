package com.wecode.main.domain;

public class AddressModel {
	private Long id;
	private Long studentId;
	private Integer pincode;
	private String city;
	private String state;
	private CountryModel country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public CountryModel getCountry() {
		return country;
	}

	public void setCountry(CountryModel country) {
		this.country = country;
	}

}
