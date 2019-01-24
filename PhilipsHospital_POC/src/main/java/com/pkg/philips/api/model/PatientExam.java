package com.pkg.philips.api.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class PatientExam {
	/*
	 * ID, ExamDate, Name, Description; Weight(kg) and Height(cms) *\
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer examId;
	private String name;
	private LocalDate ExamDate;
	private String description;
	private Float weight;
	private Float height;
	private Integer id;
	
	
	public PatientExam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientExam( String name, LocalDate examDate, String description, Float weight, Float height,Integer id) {
		super();
		
		this.name = name;
		this.ExamDate = examDate;
		this.description = description;
		this.weight = weight;
		this.height = height;
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getExamDate() {
		return ExamDate;
	}

	public void setExamDate(LocalDate examDate) {
		ExamDate = examDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

}
