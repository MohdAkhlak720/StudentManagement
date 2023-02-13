package com.wecode.main.response;

import java.util.List;

import com.wecode.main.domain.StudentModel;

public class PageAndSizeResponse {
	private List<StudentModel> studentModel;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalStudent;
	private Integer totalPages;
	private Boolean lastPage;

	public PageAndSizeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageAndSizeResponse(List<StudentModel> studentModel, Integer pageNumber, Integer pageSize, Long totalStudent,
			Integer totalPages, Boolean lastPage) {
		super();
		this.studentModel = studentModel;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalStudent = totalStudent;
		this.totalPages = totalPages;
		this.lastPage = lastPage;
	}

	public List<StudentModel> getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(List<StudentModel> studentModel) {
		this.studentModel = studentModel;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(Long totalStudent) {
		this.totalStudent = totalStudent;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Boolean getLastPage() {
		return lastPage;
	}

	public void setLastPage(Boolean lastPage) {
		this.lastPage = lastPage;
	}

	@Override
	public String toString() {
		return "PageAndSizeResponse [studentModel=" + studentModel + ", pageNumber=" + pageNumber + ", pageSize="
				+ pageSize + ", totalStudent=" + totalStudent + ", totalPages=" + totalPages + ", lastPage=" + lastPage
				+ "]";
	}

}
