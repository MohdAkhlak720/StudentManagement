package com.wecode.main.domain;

public class CountryModel {
	private Long id;
	private Long addressId;
	private Long mobileCode;
	private String capital;
	private String countryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getMobileCode() {
		return mobileCode;
	}

	public void setMobileCode(Long mobileCode) {
		this.mobileCode = mobileCode;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
