package com.wecode.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wecode.domain.ExpenseModel;
import com.wecode.response.Response;
import com.wecode.service.IExpenseService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/expense")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ExpenseController {

	@Autowired
	private IExpenseService service;

//	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "add new expense", response = ExpenseModel.class)
	@PostMapping()
	public ResponseEntity<ExpenseModel> addExpense(@RequestBody ExpenseModel expenseModel) {
		ExpenseModel model = service.addExpense(expenseModel);
		return new ResponseEntity<ExpenseModel>(model, HttpStatus.CREATED);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "get all expense", response = Response.class)
	@GetMapping()
	public ResponseEntity<Response> getAll() {
		List<ExpenseModel> model = service.getAllExpense();
		return new ResponseEntity<Response>(new Response(new Date(), model), HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "get a expense by given id", response = Response.class)
	@GetMapping("/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) {
		ExpenseModel expenseModel = service.getExpenseById(id);
		return new ResponseEntity<Response>(new Response(new Date(), expenseModel), HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "get expense by given name", response = Response.class)
	@GetMapping("/name")
	public ResponseEntity<Response> getByName(@RequestParam String name) {
		List<ExpenseModel> models = service.getExpenseByName(name);
		return new ResponseEntity<Response>(new Response(new Date(), models), HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "update a expense by given id", response = Response.class)
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateById(@PathVariable Long id, @RequestBody ExpenseModel model) {
		ExpenseModel expenseModel = service.updateExpenseById(id, model);
		return new ResponseEntity<Response>(new Response(new Date(), expenseModel), HttpStatus.OK);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "delete a expense by given id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id) {
		ExpenseModel expenseModel = service.deletExpenseById(id);
		return new ResponseEntity<Response>(new Response(new Date(), expenseModel), HttpStatus.OK);
	}

}
