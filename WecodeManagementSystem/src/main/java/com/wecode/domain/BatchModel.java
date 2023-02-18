package com.wecode.domain;

import java.util.Date;

import com.wecode.enums.BatchEnum;

public class BatchModel {
	private Long id;
	private Long studentId;
	private BatchEnum batchName;
	private Integer fee;
	private Integer duration;
	private Date date;

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

	public BatchEnum getBatchName() {
		return batchName;
	}

	public void setBatchName(BatchEnum batchName) {
		this.batchName = batchName;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BatchModel [id=" + id + ", studentId=" + studentId + ", batchName=" + batchName + ", fee=" + fee
				+ ", duration=" + duration + ", date=" + date + "]";
	}

}
