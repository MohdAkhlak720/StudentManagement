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

import com.wecode.domain.CountryModel;
import com.wecode.response.Response;
import com.wecode.service.ICountryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	private ICountryService service;

	@ApiOperation(value = "add new Country", response = CountryModel.class)
	@PostMapping()
	public ResponseEntity<CountryModel> addNewCountry(@RequestBody CountryModel model) {
		CountryModel countryModel = service.addCountry(model);
		return new ResponseEntity<CountryModel>(countryModel, HttpStatus.CREATED);
	}

	@ApiOperation(value = "get a country by given id", response = Response.class)
	@GetMapping("/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) {
		CountryModel countryModel = service.getCountryById(id);
		return new ResponseEntity<Response>(new Response(new Date(), countryModel), HttpStatus.OK);
	}

	@ApiOperation(value = "get all country", response = Response.class)
	@GetMapping()
	public ResponseEntity<Response> getAllCountry() {
		List<CountryModel> countryModel = service.getAllCountry();
		return new ResponseEntity<Response>(new Response(new Date(), countryModel), HttpStatus.OK);
	}

	@ApiOperation(value = "update a country by given id", response = Response.class)
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateById(@PathVariable Long id, @RequestBody CountryModel model) {
		CountryModel countryModel = service.updateCountryById(id, model);
		return new ResponseEntity<Response>(new Response(new Date(), countryModel), HttpStatus.OK);
	}

	@ApiOperation(value = "delete a country by given id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id) {
		CountryModel countryModel = service.deleteCountryById(id);
		return new ResponseEntity<Response>(new Response(new Date(), countryModel), HttpStatus.OK);
	}
}
