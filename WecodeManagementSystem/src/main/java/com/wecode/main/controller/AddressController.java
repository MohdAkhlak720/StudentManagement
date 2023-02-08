package com.wecode.main.controller;

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

import com.wecode.main.domain.AddressModel;
import com.wecode.main.response.Response;
import com.wecode.main.service.IAddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	private IAddressService service;

	@ApiOperation(value = "add address of student", response = AddressModel.class)
	@PostMapping()
	public ResponseEntity<AddressModel> createAddress(@RequestBody AddressModel model) {
		AddressModel addressModel = service.addAddress(model);
		return new ResponseEntity<>(addressModel, HttpStatus.CREATED);
	}

	@ApiOperation(value = "get a address by given id", response = Response.class)
	@GetMapping("/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) {
		AddressModel model = service.getAddressById(id);
		Response response = new Response(new Date(), model);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "get all address", response = Response.class)
	@GetMapping()
	public ResponseEntity<Response> getAllAddress() {
		List<AddressModel> models = service.getAllAddress();
		Response response = new Response(new Date(), models);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "update a address by given id", response = Response.class)
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateById(@PathVariable Long id, @RequestBody AddressModel model) {
		AddressModel addressModel = service.updateAddressById(id, model);
		Response response = new Response(new Date(), addressModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "delete a address by given id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id) {
		AddressModel addressModel = service.deleteAddressById(id);
		Response response = new Response(new Date(), addressModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
