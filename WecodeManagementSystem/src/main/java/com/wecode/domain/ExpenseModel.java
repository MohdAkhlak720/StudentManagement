package com.wecode.domain;

import java.util.Date;

import com.wecode.enums.ExpenseEnum;

public class ExpenseModel {
	private Long id;
	private Date date;
	private String name;
	private String description;
	private Integer amount;
	private ExpenseEnum expense;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public ExpenseEnum getExpense() {
		return expense;
	}

	public void setExpense(ExpenseEnum expense) {
		this.expense = expense;
	}

	@Override
	public String toString() {
		return "ExpenseModel [id=" + id + ", date=" + date + ", name=" + name + ", description=" + description
				+ ", amount=" + amount + ", expense=" + expense + "]";
	}

}
