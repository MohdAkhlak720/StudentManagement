package com.wecode.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecode.domain.ExpenseModel;
import com.wecode.entities.ExpenseEntity;
import com.wecode.exceptionhandler.DataNotFoundException;
import com.wecode.repository.ExpenseRepository;
import com.wecode.service.IExpenseService;

@Service
public class ExpenseServiceImpl implements IExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public ExpenseModel addExpense(ExpenseModel expenseModel) {
		ExpenseEntity entity = modelToEntity(expenseModel);
		expenseRepository.save(entity);
		expenseModel.setId(entity.getId());
		return expenseModel;
	}

	@Override
	public ExpenseModel getExpenseById(Long id) {
		Optional<ExpenseEntity> optional = expenseRepository.findById(id);
		ExpenseModel model = null;
		if (optional.isPresent()) {
			ExpenseEntity entity = optional.get();
			model = entityToModel(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id any expense not found.");
		}
	}

	@Override
	public List<ExpenseModel> getAllExpense() {
		List<ExpenseEntity> expenseEntities = expenseRepository.findAll();
		List<ExpenseModel> expenseModel = new ArrayList<>();
		for (ExpenseEntity entity : expenseEntities) {
			ExpenseModel model = new ExpenseModel();
			model = entityToModel(entity);
			expenseModel.add(model);
		}
		return expenseModel;
	}

	@Override
	public List<ExpenseModel> getExpenseByName(String name) {
		List<ExpenseEntity> expenseEntities = expenseRepository.findByNameIgnoreCase(name);
		List<ExpenseModel> expenseModel = new ArrayList<>();
		for (ExpenseEntity entity : expenseEntities) {
			ExpenseModel model = new ExpenseModel();
			model = entityToModel(entity);
			expenseModel.add(model);
		}
		return expenseModel;
	}

	@Override
	public ExpenseModel updateExpenseById(Long id, ExpenseModel model) {
		Optional<ExpenseEntity> optional = expenseRepository.findById(id);
		if (optional.isPresent()) {
			ExpenseEntity entity = optional.get();
			entity.setAmount(model.getAmount());
			entity.setDate(model.getDate());
			entity.setDescription(model.getDescription());
			entity.setExpense(model.getExpense());
			entity.setName(model.getName());
			expenseRepository.save(entity);
			model.setId(entity.getId());

			return model;
		} else {
			throw new DataNotFoundException("Given id Expense not found for update.");
		}
	}

	@Override
	public ExpenseModel deletExpenseById(Long id) {
		Optional<ExpenseEntity> optional = expenseRepository.findById(id);
		ExpenseModel model = null;
		if (optional.isPresent()) {
			ExpenseEntity entity = optional.get();
			model = entityToModel(entity);
			expenseRepository.delete(entity);
			return model;
		} else {
			throw new DataNotFoundException("Given id Expense not found for delete.");
		}
	}

	private ExpenseEntity modelToEntity(ExpenseModel model) {
		ExpenseEntity entity = new ExpenseEntity();
		entity.setName(model.getName());
		entity.setExpense(model.getExpense());
		entity.setAmount(model.getAmount());
		entity.setDescription(model.getDescription());
		entity.setDate(model.getDate());
		return entity;
	}

	private ExpenseModel entityToModel(ExpenseEntity entity) {
		ExpenseModel model = new ExpenseModel();
		model.setAmount(entity.getAmount());
		model.setDate(entity.getDate());
		model.setDescription(entity.getDescription());
		model.setExpense(entity.getExpense());
		model.setName(entity.getName());
		model.setId(entity.getId());
		return model;
	}

}
