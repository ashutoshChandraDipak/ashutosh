package com.pkg.philips.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Hospital {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer hospitalId;
	private String Name;
	private String description;
	
	
	  @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	  @JoinColumn(name ="hospitalId",referencedColumnName="hospitalId") 
	  private List<Patient> Patient;
	 
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(String name, String description) {
		super();
		
		Name = name;
		this.description = description;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getName() {
		return Name;
	}

	public List<Patient> getPatient() {
		return Patient;
	}

	public void setPatient(List<Patient> patient) {
		Patient = patient;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	
	
}
