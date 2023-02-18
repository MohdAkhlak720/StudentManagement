package com.wecode.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
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

import com.wecode.constants.Constants;
import com.wecode.domain.StudentModel;
import com.wecode.enums.GenderEnum;
import com.wecode.response.PageAndSizeResponse;
import com.wecode.response.Response;
import com.wecode.service.IStudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private IStudentService service;

	@ApiOperation(value = "add a new student", response = StudentModel.class, code = 201)
	@PostMapping()
	public ResponseEntity<StudentModel> addStudent(@Valid @RequestBody StudentModel model) {
		StudentModel createStudent = service.addStudent(model);
		return new ResponseEntity<StudentModel>(createStudent, HttpStatus.CREATED);
	}

	@ApiOperation(value = "get a student by given id", response = Response.class)
	@GetMapping("/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) {
		StudentModel model = service.getStudentById(id);
		return new ResponseEntity<Response>(new Response(new Date(), model), HttpStatus.OK);
	}

	@ApiOperation(value = "get a student by given gender", response = Response.class)
	@GetMapping("/gender")
	public ResponseEntity<Response> getStudentGender(@RequestParam GenderEnum gender) {
		List<StudentModel> studentModel = service.getByGender(gender);
		return new ResponseEntity<Response>(new Response(new Date(), studentModel), HttpStatus.OK);
	}

	@ApiOperation(value = "get student by count number", response = Response.class)
	@GetMapping("/")
	public ResponseEntity<Response> getStudentByPageNumberAndPageSize(
			@RequestParam(value = "pageNumber", defaultValue = Constants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = Constants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = Constants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = Constants.SORT_DIR, required = false) String sortDir) {
		PageAndSizeResponse pageAndSizeResponse = service.getAll(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<Response>(new Response(new Date(), pageAndSizeResponse), HttpStatus.OK);
	}

	@ApiOperation(value = "get all student", response = Response.class)
	@GetMapping()
	public ResponseEntity<Response> getAllStudent() {
		List<StudentModel> models = service.getAllStudent();
		Response response = null;
		if (models.size() <= 0) {
			response = new Response(new Date(), null);
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		} else {
			response = new Response(new Date(), models);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "update a student by given id", response = Response.class)
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateById(@PathVariable Long id, @Valid @RequestBody StudentModel model) {
		StudentModel studentModel = service.updateStudentById(id, model);
		return new ResponseEntity<Response>(new Response(new Date(), studentModel), HttpStatus.OK);
	}

	@ApiOperation(value = "delete a student by given id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id) {
		StudentModel model = service.removeStudentById(id);
		return new ResponseEntity<Response>(new Response(new Date(), model), HttpStatus.OK);
	}
}
