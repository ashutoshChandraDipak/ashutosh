package com.pkg.philips.api.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

@Table
@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String Name;
	private LocalDate dateOfBirth;
	private String gender;
	private Integer hospitalId;
	private Integer age;
  
    public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<PatientExam> patientExam;

	public List<PatientExam> getPatientExam() {
		return patientExam;
	}


	public void setPatientExam(List<PatientExam> patientExam) {
		this.patientExam = patientExam;
	}


	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(String name, LocalDate dateOfBirth2, String gender, Integer hospitalId,Integer age) {
		super();
		
		Name = name;
		this.dateOfBirth = dateOfBirth2;
		this.gender = gender;
		this.hospitalId = hospitalId;
		this.age=age;
		
	}
	public Patient(String name, LocalDate dateOfBirth2, String gender, Integer hospitalId) {
		super();
		
		Name = name;
		this.dateOfBirth = dateOfBirth2;
		this.gender = gender;
		this.hospitalId = hospitalId;
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", Name=" + Name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", hospitalId=" + hospitalId + "]";
	}

}
