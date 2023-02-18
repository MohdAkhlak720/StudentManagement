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
import org.springframework.web.bind.annotation.RestController;

import com.wecode.domain.BatchModel;
import com.wecode.response.Response;
import com.wecode.service.IBatchService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/batch")
public class BatchController {

	@Autowired
	private IBatchService service;

	@ApiOperation(value = "add new batch", response = BatchModel.class)
	@PostMapping()
	public ResponseEntity<BatchModel> addBatch(@RequestBody BatchModel batchModel) {
		return new ResponseEntity<BatchModel>(service.addBatch(batchModel), HttpStatus.CREATED);
	}

	@ApiOperation(value = "get a batch by given id", response = Response.class)
	@GetMapping("/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) {
		BatchModel batchModel = service.getBatchById(id);
		return new ResponseEntity<Response>(new Response(new Date(), batchModel), HttpStatus.OK);
	}

	@ApiOperation(value = "get all Batch", response = Response.class)
	@GetMapping()
	public ResponseEntity<Response> getAll() {
		List<BatchModel> batchModel = service.getAllBacth();
		return new ResponseEntity<Response>(new Response(new Date(), batchModel), HttpStatus.OK);
	}

	@ApiOperation(value = "update a batch by given id", response = Response.class)
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateById(@PathVariable Long id, @RequestBody BatchModel model) {
		BatchModel batchModel = service.updateBatchById(id, model);
		return new ResponseEntity<Response>(new Response(new Date(), batchModel), HttpStatus.OK);
	}

	@ApiOperation(value = "delte a batch by given id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id) {
		BatchModel batchModel = service.deleteBatchById(id);
		return new ResponseEntity<Response>(new Response(new Date(), batchModel), HttpStatus.OK);
	}
}
