package com.wecode.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.wecode.enums.BatchEnum;

@Entity
@Table(name = "fee")
public class FeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private Integer fee;
	@Enumerated(EnumType.STRING)
	private BatchEnum batch;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "studentId", nullable = false)
	private StudentEntity student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "FeeEntity [id=" + id + ", date=" + date + ", fee=" + fee + ", batch=" + batch + ", student=" + student
				+ "]";
	}

}
