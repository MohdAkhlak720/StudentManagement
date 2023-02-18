package com.wecode.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wecode.enums.ExpenseEnum;

@Entity
@Table(name = "Expense")
public class ExpenseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String name;
	private String description;
	private Integer amount;
	@Enumerated(EnumType.STRING)
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
		return "ExpenseEntity [id=" + id + ", date=" + date + ", name=" + name + ", description=" + description
				+ ", amount=" + amount + ", expense=" + expense + "]";
	}

	

}
