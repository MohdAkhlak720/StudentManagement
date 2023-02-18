package com.wecode.service;

import java.util.List;

import com.wecode.domain.ExpenseModel;

public interface IExpenseService {
	public ExpenseModel addExpense(ExpenseModel expenseModel);

	public ExpenseModel getExpenseById(Long id);

	public List<ExpenseModel> getAllExpense();

	public List<ExpenseModel> getExpenseByName(String name);

	public ExpenseModel updateExpenseById(Long id, ExpenseModel model);

	public ExpenseModel deletExpenseById(Long id);

}
