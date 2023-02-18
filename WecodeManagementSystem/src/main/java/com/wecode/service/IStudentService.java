package com.wecode.service;

import java.util.List;

import com.wecode.domain.StudentModel;
import com.wecode.enums.GenderEnum;
import com.wecode.response.PageAndSizeResponse;

public interface IStudentService {

	public StudentModel addStudent(StudentModel studentModel);

	public StudentModel getStudentById(Long id);

	public List<StudentModel> getAllStudent();

	public List<StudentModel> getByGender(GenderEnum gender);

	public StudentModel updateStudentById(Long id, StudentModel studentModel);

	public StudentModel removeStudentById(Long id);

	public PageAndSizeResponse getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

}