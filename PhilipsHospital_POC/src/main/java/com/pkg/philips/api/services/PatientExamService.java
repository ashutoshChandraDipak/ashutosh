package com.pkg.philips.api.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.philips.api.model.PatientExam;
import com.pkg.philips.api.repository.PatientExamRepository;

@Service
public class PatientExamService {
	
	@Autowired
	PatientExamRepository patientRepository;
	
	@PostConstruct
	public void savePatientExam() throws ParseException
	{
		List<PatientExam> list=new ArrayList<PatientExam>();
		/*
		 * DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); java.util.Date dt = new
		 * java.util.Date(); java.text.SimpleDateFormat sdf = new
		 * java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String dateOfBirth =
		 * sdf.format(dt); sdf.parse(dateOfBirth);
		 */
		LocalDate birthday5 = LocalDate.of(2018, Month.JANUARY, 1);
		LocalDate birthday6 = LocalDate.of(1923, Month.DECEMBER, 1);
		LocalDate birthday7 = LocalDate.of(2017, Month.JANUARY, 1);
		LocalDate birthday8 = LocalDate.of(1930, Month.FEBRUARY, 1);
		LocalDate birthday9 = LocalDate.of(2018, Month.JANUARY, 1);
		LocalDate birthday10 = LocalDate.of(2018, Month.MARCH, 1);
		//Integer examId, String name, Date examDate, String description, Float weight, Float height
		list.add(new PatientExam("Chandra Dipak",birthday5,"calara patient",12345.78F,3435.897F,1));
		list.add(new PatientExam("Kumar tripathi",birthday6,"Fever",12345.78F,3435.897F,1));
		list.add(new PatientExam("Manoj Joshi",birthday7,"calara patient",12345.78F,3435.897F,1));
		list.add(new PatientExam("Harpal",birthday6,"calara patient",12345.78F,3435.897F,1));
		list.add(new PatientExam("Ashutosh",birthday10,"Maleria",12345.78F,3435.897F,2));
		list.add(new PatientExam("Devanand",birthday9,"Diebaties",12345.78F,3435.897F,2));
		list.add(new PatientExam("Bhumika",birthday9,"Cancer",12345.78F,3435.897F,2));
		list.add(new PatientExam("Bhopesh Jaisawal",birthday8,"HIV",12345.78F,3435.897F,2));
		patientRepository.saveAll(list);
	}
	
	public List<PatientExam> getExamDetails()
	{
		return patientRepository.findAll();
	}
	
	public Optional<PatientExam> getPatientById(int id)
	{
		return patientRepository.findById(id);
	}
	public  PatientExam createPatientExam(PatientExam patientExam)
	{
		return patientRepository.save(patientExam);
	}
	public  PatientExam updatePatientExam(PatientExam patientExam)
	{				
		return patientRepository.save(patientExam);
	}
	public  List<PatientExam> deletePatientExamById(int examId)
	{
		patientRepository.deleteById(examId);
		
		return patientRepository.findAll();
	}

}
