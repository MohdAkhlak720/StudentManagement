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

import com.wecode.domain.FeeModel;
import com.wecode.enums.BatchEnum;
import com.wecode.response.Response;
import com.wecode.service.IFeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/fee")
public class FeeController {

	@Autowired
	private IFeeService service;

	@ApiOperation(value = "add fee of student", response = FeeModel.class)
	@PostMapping()
	public ResponseEntity<FeeModel> addFee(@RequestBody FeeModel feeModel) {
		FeeModel model = service.createFee(feeModel);
		return new ResponseEntity<FeeModel>(model, HttpStatus.CREATED);
	}

	@ApiOperation(value = "get fee of student by given id", response = Response.class)
	@GetMapping("/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) {
		FeeModel feeModel = service.getFeeById(id);
		return new ResponseEntity<Response>(new Response(new Date(), feeModel), HttpStatus.OK);
	}

	@ApiOperation(value = "get fee for perticular batch using studentId and batchName", response = Response.class)
	@GetMapping("/batch")
	public ResponseEntity<Response> getFeeInfo(@RequestParam Long studentId, @RequestParam BatchEnum batch) {
		List<FeeModel> feeModels = service.getByBatchInfo(studentId, batch);
		return new ResponseEntity<Response>(new Response(new Date(), feeModels), HttpStatus.OK);
	}

	@ApiOperation(value = "get all fees", response = Response.class)
	@GetMapping()
	public ResponseEntity<Response> getAll() {
		List<FeeModel> feeModel = service.getAllFee();
		return new ResponseEntity<Response>(new Response(new Date(), feeModel), HttpStatus.OK);
	}

	@ApiOperation(value = "update a fee by given id", response = Response.class)
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateById(@PathVariable Long id, @RequestBody FeeModel model) {
		FeeModel feeModel = service.updateFeeById(id, model);
		return new ResponseEntity<Response>(new Response(new Date(), feeModel), HttpStatus.OK);
	}

	@ApiOperation(value = "delete fee by given id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id) {
		FeeModel feeModel = service.removeFeeById(id);
		return new ResponseEntity<Response>(new Response(new Date(), feeModel), HttpStatus.OK);
	}

}
