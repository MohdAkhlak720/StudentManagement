package com.wecode.main.service;

import java.util.List;

import com.wecode.main.domain.CountryModel;

public interface ICountryService {
	public CountryModel addCountry(CountryModel countryModel);

	public CountryModel getCountryById(Long id);

	public List<CountryModel> getAllCountry();

	public CountryModel updateCountryById(Long id, CountryModel model);

	public CountryModel deleteCountryById(Long id);
}
