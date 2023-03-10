package com.wecode.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wecode.domain.AddressModel;
import com.wecode.domain.BatchModel;
import com.wecode.domain.CountryModel;
import com.wecode.domain.FeeModel;
import com.wecode.domain.StudentModel;
import com.wecode.entities.AddressEntity;
import com.wecode.entities.BatchEntity;
import com.wecode.entities.CountryEntity;
import com.wecode.entities.FeeEntity;
import com.wecode.entities.StudentEntity;
import com.wecode.enums.GenderEnum;
import com.wecode.exceptionhandler.DataNotFoundException;
import com.wecode.repository.AddressRepository;
import com.wecode.repository.CountryRepository;
import com.wecode.repository.StudentRepository;
import com.wecode.response.PageAndSizeResponse;
import com.wecode.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public StudentModel addStudent(StudentModel studentModel) {
		StudentEntity entity = modelToEntity(studentModel);
		studentRepository.save(entity);
		studentModel.setId(entity.getId());
		return studentModel;
	}

	@Override
	public StudentModel getStudentById(Long id) {
		Optional<StudentEntity> optional = studentRepository.findById(id);
		StudentModel model = null;
		if (optional.isPresent()) {
			StudentEntity entity = optional.get();
			model = entityToModel(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id data not found");
		}
	}

	@Override
	public List<StudentModel> getByGender(GenderEnum gender) {
		List<StudentEntity> entities = studentRepository.findByGender(gender);
//		System.out.println(entities);
		List<StudentModel> models = new ArrayList<>();
		for (StudentEntity entity : entities) {
			StudentModel model = new StudentModel();
			model = entityToModel(entity);
			models.add(model);
		}
		return models;
	}

	@Override
	public List<StudentModel> getAllStudent() {
		List<StudentEntity> entities = studentRepository.findAll();
		List<StudentModel> models = new ArrayList<>();
		for (StudentEntity object : entities) {
			StudentModel model = new StudentModel();
			model = entityToModel(object);
			models.add(model);
		}
		return models;
	}

	@Override
	public PageAndSizeResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		PageRequest page = PageRequest.of(pageNumber, pageSize, sort);
		Page<StudentEntity> pageEntity = studentRepository.findAll(page);
		List<StudentEntity> studentEntities = pageEntity.getContent();
		List<StudentModel> studentModels = new ArrayList<>();
		for (StudentEntity entity : studentEntities) {
			StudentModel model = new StudentModel();
			model = entityToModel(entity);
			studentModels.add(model);
		}
		PageAndSizeResponse response = new PageAndSizeResponse();
		response.setStudentModel(studentModels);
		response.setPageNumber(pageEntity.getNumber());
		response.setPageSize(pageEntity.getSize());
		response.setTotalStudent(pageEntity.getTotalElements());
		response.setTotalPages(pageEntity.getTotalPages());
		response.setLastPage(pageEntity.isLast());
		return response;

	}

	@Override
	public StudentModel updateStudentById(Long id, StudentModel studentModel) {
		Optional<StudentEntity> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			StudentEntity entity = optional.get();
			entity.setName(studentModel.getName());
			entity.setEmail(studentModel.getEmail());
			entity.setFatherName(studentModel.getFatherName());
			entity.setMobileNo(studentModel.getMobileNo());
			entity.setGender(studentModel.getGender());
			studentRepository.save(entity);
			studentModel.setId(entity.getId());
			return studentModel;
		} else {
			throw new DataNotFoundException("Given id data not found.");
		}
	}

	@Override
	public StudentModel removeStudentById(Long id) {
		Optional<StudentEntity> optional = studentRepository.findById(id);
		StudentModel model = null;
		if (optional.isPresent()) {
			StudentEntity entity = optional.get();
			model = entityToModel(entity);
			studentRepository.deleteById(id);
			return model;
		} else {
			throw new DataNotFoundException("Given id data not found.");
		}
	}

	private StudentEntity modelToEntity(StudentModel model) {
		StudentEntity entity = new StudentEntity();
		entity.setName(model.getName());
		entity.setFatherName(model.getFatherName());
		entity.setMobileNo(model.getMobileNo());
		entity.setEmail(model.getEmail());
		entity.setGender(model.getGender());
		return entity;
	}

	private StudentModel entityToModel(StudentEntity entity) {
		StudentModel model = new StudentModel();
		model.setName(entity.getName());
		model.setFatherName(entity.getFatherName());
		model.setEmail(entity.getEmail());
		model.setMobileNo(entity.getMobileNo());
		model.setId(entity.getId());
		model.setGender(entity.getGender());
		Optional<AddressEntity> optional = addressRepository.findById(entity.getAddressEntity().getId());
		if (optional.isPresent()) {
			AddressEntity addressEntity = optional.get();
			AddressModel addressModel = new AddressModel();
			addressModel.setId(addressEntity.getId());
			addressModel.setCity(addressEntity.getCity());
			addressModel.setPincode(addressEntity.getPincode());
			addressModel.setState(addressEntity.getState());
			addressModel.setStudentId(addressEntity.getStudentEntity().getId());
			Optional<CountryEntity> country = countryRepository.findById(addressEntity.getCountry().getId());
			if (optional.isPresent()) {
				CountryEntity countryEntity = country.get();
				CountryModel countryModel = new CountryModel();
				countryModel.setId(countryEntity.getId());
				countryModel.setCapital(countryEntity.getCapital());
				countryModel.setCountryName(countryEntity.getCountryName());
				countryModel.setAddressId(countryEntity.getAddress().getId());
				countryModel.setMobileCode(countryEntity.getMobileCode());
				addressModel.setCountry(countryModel);
			}
			model.setAddressModel(addressModel);
		}
		model.setBatchModel(new ArrayList<>());
		for (BatchEntity batchEntity : entity.getBatchName()) {
			BatchModel batchModel = new BatchModel();
			batchModel.setId(batchEntity.getId());
			batchModel.setBatchName(batchEntity.getBatchName());
			batchModel.setDate(batchEntity.getDate());
			batchModel.setDuration(batchEntity.getDuration());
			batchModel.setFee(batchEntity.getFee());
			batchModel.setStudentId(batchEntity.getStudentEntity().getId());
			model.getBatchModel().add(batchModel);
		}
		model.setFeeModel(new ArrayList<>());
		for (FeeEntity feeEntity : entity.getFeeEntities()) {
			FeeModel feeModel = new FeeModel();
			feeModel.setId(feeEntity.getId());
			feeModel.setBatch(feeEntity.getBatch());
			feeModel.setDate(feeEntity.getDate());
			feeModel.setFee(feeEntity.getFee());
			feeModel.setStudentId(feeEntity.getStudent().getId());
			model.getFeeModel().add(feeModel);
		}
		return model;
	}

}
