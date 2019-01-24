package com.pkg.philips.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.philips.api.model.PatientExam;
import com.pkg.philips.api.services.PatientExamService;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientExamController {
	
	@Autowired
	PatientExamService patientExamService;
	
	@GetMapping("getPatientsExam")
	public List<PatientExam> getPatientExamList()
	{
		return patientExamService.getExamDetails();
	}
	
	@GetMapping("getPatientExam/{examId}")
	public Optional<PatientExam> getPatientExamById(@PathVariable int examId)
	{
		return patientExamService.getPatientById(examId);
	}
	
	@PostMapping("createPatientExam")
	public PatientExam getPatientExamById(@RequestBody PatientExam patientExam)
	{
		return patientExamService.createPatientExam(patientExam);
	}
	
	@PutMapping("updatePatientExam")
	public PatientExam updatePatientExamById(@RequestBody PatientExam patientExam)
	{
		return patientExamService.updatePatientExam(patientExam);
	}
	
	@GetMapping("deletePatientExam/{examId}")
	public List<PatientExam> deletePatientExamById(@PathVariable int examId)
	{
		return patientExamService.deletePatientExamById(examId);
	}
	

}
