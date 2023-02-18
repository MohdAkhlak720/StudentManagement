package com.wecode.domain;

import java.util.Date;

import com.wecode.enums.BatchEnum;

public class FeeModel {
	private Long id;
	private Long studentId;
	private Date date;
	private Integer fee;
	private BatchEnum batch;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public BatchEnum getBatch() {
		return batch;
	}

	public void setBatch(BatchEnum batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "FeeModel [id=" + id + ", studentId=" + studentId + ", date=" + date + ", fee=" + fee + ", batch="
				+ batch + "]";
	}

}
