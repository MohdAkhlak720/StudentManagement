package com.wecode.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecode.domain.CountryModel;
import com.wecode.entities.AddressEntity;
import com.wecode.entities.CountryEntity;
import com.wecode.exceptionhandler.DataNotFoundException;
import com.wecode.repository.AddressRepository;
import com.wecode.repository.CountryRepository;
import com.wecode.service.ICountryService;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public CountryModel addCountry(CountryModel countryModel) {
		CountryEntity countryEntity = modelToEntity(countryModel);
		countryRepository.save(countryEntity);
		countryModel.setId(countryEntity.getId());
		return countryModel;
	}

	@Override
	public CountryModel getCountryById(Long id) {
		Optional<CountryEntity> optional = countryRepository.findById(id);
		if (optional.isPresent()) {
			CountryEntity entity = optional.get();
			CountryModel model = entityToModel(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id Country not found");
		}
	}

	@Override
	public List<CountryModel> getAllCountry() {
		List<CountryEntity> countryEntities = countryRepository.findAll();
		List<CountryModel> countryModels = new ArrayList<>();
		for (CountryEntity country : countryEntities) {
			CountryModel model = new CountryModel();
			model = entityToModel(country);
			countryModels.add(model);
		}
		return countryModels;
	}

	@Override
	public CountryModel updateCountryById(Long id, CountryModel model) {
		Optional<CountryEntity> optional = countryRepository.findById(id);
		if (optional.isPresent()) {
			CountryEntity entity = optional.get();
			entity.setCapital(model.getCapital());
			entity.setMobileCode(model.getMobileCode());
			entity.setCountryName(model.getCountryName());
			countryRepository.save(entity);
			model.setId(entity.getId());
			return model;
		} else {
			throw new DataNotFoundException("Given id Country not found for update.");
		}
	}

	@Override
	public CountryModel deleteCountryById(Long id) {
		Optional<CountryEntity> optional = countryRepository.findById(id);
		if (optional.isPresent()) {
			CountryEntity entity = optional.get();
			CountryModel model = entityToModel(entity);
			countryRepository.delete(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id Country not found for delete.");
		}
	}

	private CountryEntity modelToEntity(CountryModel model) {
		Optional<AddressEntity> optional = addressRepository.findById(model.getAddressId());
		CountryEntity entity = new CountryEntity();
		entity.setMobileCode(model.getMobileCode());
		entity.setCountryName(model.getCountryName());
		entity.setCapital(model.getCapital());
		AddressEntity addressEntity = optional.get();
		if (optional.isPresent()) {
			entity.setAddress(addressEntity);
		}
		addressEntity.setCountry(entity);
		countryRepository.save(entity);
		return entity;
	}

	private CountryModel entityToModel(CountryEntity entity) {
		CountryModel model = new CountryModel();
		model.setId(entity.getId());
		model.setAddressId(entity.getAddress().getId());
		model.setCapital(entity.getCapital());
		model.setMobileCode(entity.getMobileCode());
		model.setCountryName(entity.getCountryName());
		return model;
	}

}
