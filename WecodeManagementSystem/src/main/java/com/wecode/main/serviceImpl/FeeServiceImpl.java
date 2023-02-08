package com.wecode.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecode.main.domain.FeeModel;
import com.wecode.main.entities.FeeEntity;
import com.wecode.main.entities.StudentEntity;
import com.wecode.main.enums.BatchEnum;
import com.wecode.main.exceptionhandler.DataNotFoundException;
import com.wecode.main.repository.BatchRepository;
import com.wecode.main.repository.FeeRepository;
import com.wecode.main.repository.StudentRepository;
import com.wecode.main.service.IFeeService;

@Service
public class FeeServiceImpl implements IFeeService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private FeeRepository feeRepository;

	@Autowired
	private BatchRepository batchRepository;

	@Override
	public FeeModel createFee(FeeModel feeModel) {
		FeeEntity entity = modelToEntity(feeModel);
		feeRepository.save(entity);
		feeModel.setId(entity.getId());
		return feeModel;
	}

	@Override
	public FeeModel getFeeById(Long id) {
		Optional<FeeEntity> optional = feeRepository.findById(id);
		FeeModel feeModel = null;
		if (optional.isPresent()) {
			FeeEntity entity = optional.get();
			feeModel = entityToModel(entity);
			return feeModel;
		} else {
			throw new DataNotFoundException("Given id fee not found");
		}
	}

	@Override
	public List<FeeModel> getByBatchInfo(Long studentId, BatchEnum batch) {
		List<FeeEntity> feeEntities = feeRepository.findByStudentIdAndBatch(studentId, batch);
		List<FeeModel> feeModels = new ArrayList<>();
		for (FeeEntity entity : feeEntities) {
			FeeModel model = new FeeModel();
			model = entityToModel(entity);
			feeModels.add(model);
		}
		return feeModels;
	}

	@Override
	public List<FeeModel> getAllFee() {
		List<FeeEntity> feeEntities = feeRepository.findAll();
		List<FeeModel> feeModel = new ArrayList<>();
		for (FeeEntity entity : feeEntities) {
			FeeModel model = new FeeModel();
			model = entityToModel(entity);
			feeModel.add(model);
		}
		return feeModel;
	}

	@Override
	public FeeModel updateFeeById(Long id, FeeModel feeModel) {
		Optional<FeeEntity> optional = feeRepository.findById(id);
		if (optional.isPresent()) {
			FeeEntity entity = optional.get();
			entity.setBatch(feeModel.getBatch());
			entity.setDate(feeModel.getDate());
			entity.setFee(feeModel.getFee());
			feeRepository.save(entity);
			feeModel.setId(entity.getId());
			return feeModel;
		} else {
			throw new DataNotFoundException("Given id data not found for update.");
		}
	}

	@Override
	public FeeModel removeFeeById(Long id) {
		Optional<FeeEntity> optional = feeRepository.findById(id);
		FeeModel model = null;
		if (optional.isPresent()) {
			FeeEntity entity = optional.get();
			model = entityToModel(entity);
			feeRepository.delete(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id data not found for delete.");
		}
	}

	private FeeEntity modelToEntity(FeeModel model) {
		Optional<StudentEntity> optional = studentRepository.findById(model.getStudentId());
		FeeEntity entity = new FeeEntity();
		entity.setBatch(model.getBatch());
		entity.setDate(model.getDate());
		entity.setFee(model.getFee());
		StudentEntity studentEntity = optional.get();
		if (optional.isPresent()) {
			entity.setStudent(studentEntity);
		}
		studentRepository.save(studentEntity);
		return entity;
	}

	private FeeModel entityToModel(FeeEntity entity) {
		FeeModel model = new FeeModel();
		model.setId(entity.getId());
		model.setBatch(entity.getBatch());
		model.setDate(entity.getDate());
		model.setFee(entity.getFee());
		model.setStudentId(entity.getStudent().getId());
		return model;
	}

}
