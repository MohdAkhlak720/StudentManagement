package com.wecode.main.entities;

import java.util.Date;

import com.wecode.main.enums.BatchEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "batch")
public class BatchEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated(EnumType.STRING)
	private BatchEnum batchName;
	private Integer fee;
	private Integer duration;
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "studentId", nullable = false)
	private StudentEntity studentEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

}
