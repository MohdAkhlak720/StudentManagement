package com.wecode.main.service;

import java.util.List;

import com.wecode.main.domain.StudentModel;
import com.wecode.main.enums.GenderEnum;
import com.wecode.main.response.PageAndSizeResponse;

public interface IStudentService {

	public StudentModel addStudent(StudentModel studentModel);

	public StudentModel getStudentById(Long id);

	public List<StudentModel> getAllStudent();

	public List<StudentModel> getByGender(GenderEnum gender);

	public StudentModel updateStudentById(Long id, StudentModel studentModel);

	public StudentModel removeStudentById(Long id);

	public PageAndSizeResponse getAll(Integer pageNumber, Integer pageSize);

}