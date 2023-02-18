package com.wecode.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecode.domain.BatchModel;
import com.wecode.entities.BatchEntity;
import com.wecode.entities.StudentEntity;
import com.wecode.exceptionhandler.DataNotFoundException;
import com.wecode.repository.BatchRepository;
import com.wecode.repository.StudentRepository;
import com.wecode.service.IBatchService;

@Service
public class BatchServiceImpl implements IBatchService {

	@Autowired
	private BatchRepository batchRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public BatchModel addBatch(BatchModel batchModel) {
		BatchEntity entity = modelToEntity(batchModel);
		batchRepository.save(entity);
		batchModel.setId(entity.getId());
		return batchModel;
	}

	@Override
	public BatchModel getBatchById(Long id) {
		Optional<BatchEntity> optional = batchRepository.findById(id);
		BatchModel batchModel = null;
		if (optional.isPresent()) {
			BatchEntity entity = optional.get();
			batchModel = entityToModel(entity);
			return batchModel;
		} else {
			throw new DataNotFoundException("Data not found in given id.");
		}
	}

	@Override
	public List<BatchModel> getAllBacth() {
		List<BatchEntity> entities = batchRepository.findAll();
		List<BatchModel> modelList = new ArrayList<>();
		for (BatchEntity entity : entities) {
			BatchModel model = new BatchModel();
			model = entityToModel(entity);
			modelList.add(model);
		}
		return modelList;
	}

	@Override
	public BatchModel updateBatchById(Long id, BatchModel batchModel) {
		Optional<BatchEntity> optional = batchRepository.findById(id);
		if (optional.isPresent()) {
			BatchEntity entity = optional.get();
			entity.setBatchName(batchModel.getBatchName());
			entity.setDate(batchModel.getDate());
			entity.setDuration(batchModel.getDuration());
			entity.setFee(batchModel.getFee());
			batchRepository.save(entity);
			batchModel.setId(entity.getId());
			return batchModel;
		} else {
			throw new DataNotFoundException("Given id batch not found");
		}
	}

	@Override
	public BatchModel deleteBatchById(Long id) {
		Optional<BatchEntity> optional = batchRepository.findById(id);
		BatchModel model = null;
		if (optional.isPresent()) {
			BatchEntity entity = optional.get();
			model = entityToModel(entity);
			batchRepository.delete(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id batch not found");
		}
	}

	private BatchEntity modelToEntity(BatchModel model) {
		BatchEntity entity = new BatchEntity();
		entity.setBatchName(model.getBatchName());
		entity.setDate(model.getDate());
		entity.setDuration(model.getDuration());
		entity.setFee(model.getFee());
		Optional<StudentEntity> optional = studentRepository.findById(model.getStudentId());
		StudentEntity studentEntity = optional.get();
		if (optional.isPresent()) {
			entity.setStudentEntity(studentEntity);
		}
		studentRepository.save(studentEntity);
		return entity;

	}

	private BatchModel entityToModel(BatchEntity entity) {
		BatchModel model = new BatchModel();
		model.setId(entity.getId());
		model.setBatchName(entity.getBatchName());
		model.setDate(entity.getDate());
		model.setDuration(entity.getDuration());
		model.setFee(entity.getFee());
		model.setStudentId(entity.getStudentEntity().getId());
		return model;
	}

}
