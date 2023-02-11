package com.wecode.main.controller;

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

import com.wecode.main.domain.StudentModel;
import com.wecode.main.enums.GenderEnum;
import com.wecode.main.response.Response;
import com.wecode.main.service.IStudentService;

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
		Response response = new Response(new Date(), model);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "get a gateway by given gender", response = Response.class)
	@GetMapping("/gender")
	public ResponseEntity<Response> getStudentGender(@RequestParam GenderEnum gender) {
		List<StudentModel> studentModel = service.getByGender(gender);
		Response response = new Response(new Date(), studentModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
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
		Response response = new Response(new Date(), studentModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "delete a student by given id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteById(@PathVariable Long id) {
		StudentModel model = service.removeStudentById(id);
		Response response = new Response(new Date(), model);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/hello")
	public String msg() {
		return "This message for testing security in spring boot.";
	}
}
