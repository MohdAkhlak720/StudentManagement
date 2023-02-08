package com.wecode.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecode.main.domain.AddressModel;
import com.wecode.main.domain.CountryModel;
import com.wecode.main.entities.AddressEntity;
import com.wecode.main.entities.CountryEntity;
import com.wecode.main.entities.StudentEntity;
import com.wecode.main.exceptionhandler.DataNotFoundException;
import com.wecode.main.repository.AddressRepository;
import com.wecode.main.repository.CountryRepository;
import com.wecode.main.repository.StudentRepository;
import com.wecode.main.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public AddressModel addAddress(AddressModel addressModel) {
		AddressEntity entity = modelToEntity(addressModel);
		addressRepository.save(entity);
		addressModel.setId(entity.getId());
		return addressModel;
	}

	@Override
	public AddressModel getAddressById(Long id) {
		Optional<AddressEntity> optional = addressRepository.findById(id);
		AddressModel model = null;
		if (optional.isPresent()) {
			AddressEntity entity = optional.get();
			model = entityToModel(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id data not found");
		}
	}

	@Override
	public List<AddressModel> getAllAddress() {
		List<AddressEntity> entities = addressRepository.findAll();
		List<AddressModel> addressModel = new ArrayList<>();
		for (AddressEntity entity : entities) {
			AddressModel model = new AddressModel();
			model = entityToModel(entity);
			addressModel.add(model);
		}
		return addressModel;
	}

	@Override
	public AddressModel updateAddressById(Long id, AddressModel addressModel) {
		Optional<AddressEntity> optional = addressRepository.findById(id);
		if (optional.isPresent()) {
			AddressEntity entity = optional.get();
			entity.setCity(addressModel.getCity());
			entity.setPincode(addressModel.getPincode());
			entity.setState(addressModel.getState());
			addressRepository.save(entity);
			addressModel.setId(entity.getId());
			return addressModel;
		} else {
			throw new DataNotFoundException("Given id data not found.");
		}
	}

	@Override
	public AddressModel deleteAddressById(Long id) {
		Optional<AddressEntity> optional = addressRepository.findById(id);
		AddressModel model = null;
		if (optional.isPresent()) {
			AddressEntity entity = optional.get();
			model = entityToModel(entity);
			addressRepository.delete(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id address not found");
		}
	}

	private AddressEntity modelToEntity(AddressModel model) {
		Optional<StudentEntity> optional = studentRepository.findById(model.getStudentId());
		AddressEntity entity = new AddressEntity();
		entity.setCity(model.getCity());
		entity.setPincode(model.getPincode());
		entity.setState(model.getState());
		StudentEntity studentEntity = optional.get();
		if (optional.isPresent()) {
			entity.setStudentEntity(studentEntity);
		}
		studentEntity.setAddressEntity(entity);
		addressRepository.save(entity);
		return entity;
	}

	private AddressModel entityToModel(AddressEntity entity) {
		AddressModel model = new AddressModel();
		model.setCity(entity.getCity());
		model.setId(entity.getId());
		model.setPincode(entity.getPincode());
		model.setState(entity.getState());
		model.setStudentId(entity.getStudentEntity().getId());
		Optional<CountryEntity> optional = countryRepository.findById(entity.getCountry().getId());
		if (optional.isPresent()) {
			CountryEntity countryEntity = optional.get();
			CountryModel countryModel = new CountryModel();
			countryModel.setId(countryEntity.getId());
			countryModel.setMobileCode(countryEntity.getMobileCode());
			countryModel.setCountryName(countryEntity.getCountryName());
			countryModel.setCapital(countryEntity.getCapital());
			countryModel.setAddressId(countryEntity.getAddress().getId());
			model.setCountry(countryModel);
		}
		return model;
	}

}
