package com.pkg.philips.api.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.philips.api.model.Patient;
import com.pkg.philips.api.services.PatientService;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping("getPatient/{id}")
	public Patient getPatient(@PathVariable int id)
	{
		Patient patient=new Patient();
		List<Patient> patientList=patientService.getPatientsList();
		for(Patient patient1:patientList)
		{
			if(patient1.getId().equals(id))
			{
				patient=patient1;
			}
		}
		LocalDate today = LocalDate.now();                          //Today's date
		LocalDate birthday=patient.getDateOfBirth();
		
		Period period = Period.between(birthday, today);
		patient.setAge(period.getYears());
		return patient;
	}
	
	@GetMapping("getPatients")
	public List<Patient> getPatients()
	{
		return patientService.getPatientsList();
	}
	
	@GetMapping("getPatientByHospitalId/{id}")
	public Optional<Patient> getPatientByHospitalId(@PathVariable int hospitalId)
	{
		return patientService.getPatient(hospitalId);
	}
	
	@PostMapping("createPatients")
	public List<Patient> createPatient(@RequestBody Patient patient)
	{
		LocalDate today = LocalDate.now();                          //Today's date
		LocalDate birthday=patient.getDateOfBirth();
		Period period = Period.between(birthday, today);
		patient.setAge(period.getYears());
		
		return patientService.createPatient(patient);
	}
	
	@PutMapping("updatePatients")
	public List<Patient> updatePatient(@RequestBody Patient patient)
	{
		LocalDate today = LocalDate.now();                          //Today's date
		LocalDate birthday=patient.getDateOfBirth();
		Period period = Period.between(birthday, today);
		patient.setAge(period.getYears());
		return patientService.updatePatient(patient);
	}
	
	@DeleteMapping("deletePatients/{id}")
	public Optional<Patient> deletePatient(@PathVariable int id)
	{
		 
		 patientService.deletePatient(id);
		return patientService.getPatient(id);
	}
	
	@GetMapping("getPatientsByHospitalId/{hospitalId}")
	public List<Patient> getPatientsListBiHospitalId(@PathVariable Integer hospitalId)
	{
		return patientService.getPatientsListBiHospitalId(hospitalId);
		
	}


}
